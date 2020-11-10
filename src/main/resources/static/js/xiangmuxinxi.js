var page = 1;
var pagesize = 5;
var name;
var xmpage = 1;
var xmpagesize = 20;
var identity = sessionStorage.getItem('INF-identity');

var totalPages;
var moduleName = 'xiangmuxinxi';
var ord_id = sessionStorage.getItem('INF-identity');
var pageSize = 20;
var a = sessionStorage.getItem('aa');

var project_number;
var project_number2;

var firstGaoxiaoId = 5;

var resources;
var type;
var undertaking_unit;
var project_name;


var indexNumber = 1;
// 页面渲染
window.onload = rendPage();

function rendPage() {
    getData(page, pagesize);
    getDataXmly();
    getDataSsdw(page, pagesize);
    getDataXmjb();
    // setTimeout(function () {
    //     showxiangmuxinxi(1, xmpagesize, firstGaoxiaoId);
    // }, 300);
}


//项目条目
function getDataXmly() {
    var select = document.getElementById('AreaId1');

    $.ajax({
        type: 'post',
        url: "/api/xiangmulaiyuan",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] == 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.resources = data["value"]["resources"];
                    resources = item["resources"];
                    id = item["id"];
                    option.className = "selectdiv fl";
                    option.value = id;
                    option.innerHTML = '<a> 项目来源：' + resources + '</a>';
                    select.insertBefore(option, select.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//所属单位-选择器
function getDataSsdw(page, pagesize) {
    var select = document.getElementById('AreaId');
    $.ajax({
        type: 'post',
        url: "/api/suoshudanwei",
        timeout: 15000,
        dataType: "json",
        data: {
            getall: 1,
            page: page,
            pagesize: pagesize,
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] == 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    // alert(index);
                    var option = document.createElement('option');
                    option.name = data["value"]["name"];
                    identity = item["identity"];
                    name = item["name"];
                    option.className = "selectdiv fl";
                    option.value = identity;
                    option.innerHTML = '<a>所属单位：' + name + '</a>';
                    select.insertBefore(option, select.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


//项目级别-选择器
function getDataXmjb() {
    var select = document.getElementById('AreaId2');
    $.ajax({
        type: 'post',
        url: "/api/xiangmujibie",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] == 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    type = item["type"];
                    id = item["id"];
                    option.className = "selectdiv fl";
                    option.value = id;
                    option.innerHTML = '<a> 项目级别：' + type + '</a>';
                    select.insertBefore(option, select.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


//高校名称
function getData(page, pagesize) {
    var dl = document.body.querySelector('#gaoxiao_mingchen');
    dl.innerHTML = "<dd></dd>";
    $.ajax({
        type: 'post',
        url: "/api/suoshudanwei",
        timeout: 15000,
        dataType: "json",
        data: {
            page: page,
            pagesize: pagesize,
            getall: 0
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    var dd = document.createElement('dd');
                    dd.name = item["name"];
                    dd.identity = item["identity"];

                    identity = item["identity"];
                    name = item["name"];

                    //记录第一所高校ID，默认展示其成果信息
                    if (index === 0) {
                        firstGaoxiaoId = item['identity'];
                        sessionStorage.setItem("INF-identity", firstGaoxiaoId);
                    }

                    dd.className = 'fs-14';
                    //dd.innerHTML = '<a href=""> '+ item['name'] + '</a>';
                    dd.innerHTML = '<a onclick="showpage(' + item["identity"] + ')"> ' + item["name"] + '</a>';

                    dl.insertBefore(dd, dl.lastChild);

                    indexNumber++;
                });


                var dt = document.createElement('dt');
                dt.className = "fs-16";
                dt.innerHTML = '项目信息';
                dl.insertBefore(dt, dl.firstChild);

                var tempHtml = document.getElementById("gaoxiao_mingchen").outerHTML;
                document.getElementById("gaoxiao_mingchen").innerHTML = tempHtml +
                    '<dd class="fs-14" onclick="pageUp()"><a style="margin-top: 50px;">上一页</a></dd>' +
                    '<dd class="fs-14" onclick="pageDown()"><a>下一页</a></dd>';
                showxiangmuxinxi(1, xmpagesize, firstGaoxiaoId);
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


//高校名称上一页
function pageUp() {
    --page;
    getData(page, pagesize);
}

//高校名称下一页
function pageDown() {
    ++page;
    getData(page, pagesize);
}

//根据高校名称，获取具体条目
function showpage(identity) {
    xmpage = 1;
    showxiangmu(identity);
    showxiangmuxinxi(xmpage, xmpagesize, identity);
    gettotalPages(moduleName, ord_id, pageSize);//获取成果页码
}


function showxiangmu(ident) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", ident);
}


//项目信息条目
function showxiangmuxinxi(tpage, tpagesize, gxidentity) {
    var ul = document.body.querySelector('#xiangmu_name');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/xiangmuxinxi",
        timeout: 15000,
        dataType: "json",
        data: {
            page: tpage,
            pagesize: tpagesize,
            identity: gxidentity
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    identity = sessionStorage.getItem("INF-identity");
                    // identity = item["identity"];
                    project_name = item["project_name"];
                    undertaking_unit = item["undertaking_unit"];
                    project_number2 = "'" + item["project_number"] + "'";
                    var li = document.createElement('li');
                    li.innerHTML = '<a onclick="showdetails(' + project_number2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 70%;background-color:rgba(255,255,255,0);">' + project_name + '</h2>' +
                        '<p class="one_hidden fr fs-14" style="width: 20%;background-color:rgba(255,255,255,0);">' + undertaking_unit + '</p></a>';
                    ul.insertBefore(li, ul.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("此高校无更多项目信息了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

function gettotalPages(moduleName, org_id, pageSize) {
    $.ajax({
        type: 'post',
        url: "/api/getPagingInformation",
        timeout: 15000,
        dataType: "json",
        data: {
            moduleName: 'xiangmuxinxi',
            org_id: sessionStorage.getItem('INF-identity'),
            pageSize: pageSize,

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    totalPages = data["value"]["totalPages"];
                    sessionStorage.setItem('aa', data["value"]["totalPages"]);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
              //  alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });

}

//条目下一页
function xmpageDown() {

    a = sessionStorage.getItem('aa');
    if (a > xmpage) {
        ++xmpage;
        showxiangmuxinxi(xmpage, xmpagesize, identity)
    } else {
        alert("这个是最后一页");
    }
}


//条目上一页
function xmpageUp() {
    if (xmpage === 1) {
        alert("当前是第一页")
    } else {
        --xmpage;
        showxiangmuxinxi(xmpage, xmpagesize, identity);
    }

}


//详情跳转
function showdetails(ident) {

    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", ident);
    // alert(ident);
    window.location.href = "/xmxxxq?identity=" + sessionStorage.getItem("INF-identity");
}