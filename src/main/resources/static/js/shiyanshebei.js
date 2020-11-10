var page = 1;
var pagesize = 5;
var indexNumber = 1;

var sysbpage = 1;
var sysbpagesize = 20;
var identity = sessionStorage.getItem('INF-identity');

var name;
var shebei_name;
var shebei_number;
var shebei_number2;
var tianbao_danwei_xiao;
var firstGaoxiaoId = 2;


//分页判断
var totalPages;
var moduleName = 'sheibeixinxi';
var ord_id = sessionStorage.getItem('INF-identity');
var pageSize = 20;
var a = sessionStorage.getItem('aa');


//页面渲染
window.onload = rendPage();

function rendPage() {
    getData(page, pagesize);//高校名称
    getDataSsdw(page, pagesize);//所属单位选择器
    // setTimeout(function () {//试验设备条目加载
    //     showshiyanshebei(1, sysbpagesize, firstGaoxiaoId);
    // }, 300);
}

//首页
function showpage(identity) {
    sysbpage = 1;
    showshebei(identity);
    showshiyanshebei(sysbpage, sysbpagesize, identity);
    gettotalPages(moduleName, ord_id, pageSize);//获取成果页码
}


function showshebei(ident) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", ident);
}


function gettotalPages(moduleName, org_id, pageSize) {
    $.ajax({
        type: 'post',
        url: "/api/getPagingInformation",
        timeout: 15000,
        dataType: "json",
        data: {
            moduleName: 'sheibeixinxi',
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
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });

}


//所属单位选择器
function getDataSsdw(page, pagesize) {
    var select = document.getElementById('AreaId');
    // select.innerHTML="";
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
            // alert(data['status']);
            if (data['status'] == 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
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
                    dd.name = item['name'];
                    dd.identity = item["identity"];
                    identity = item["identity"];
                    name = item["name"];

                    //记录第一所高校ID，默认展示其成果信息
                    if (index === 0) {
                        firstGaoxiaoId = item["identity"];
                        sessionStorage.setItem('INF-identity', firstGaoxiaoId);
                    }
                    dd.className = 'fs-14';
                    //dd.innerHTML = '<a href=""> '+ item['name'] + '</a>';
                    dd.innerHTML = '<a onclick="showpage(' + item["identity"] + ')"> ' + item["name"] + '</a>';
                    dl.insertBefore(dd, dl.lastChild);
                    indexNumber++;
                });
                var dt = document.createElement('dt');
                dt.className = "fs-16";
                dt.innerHTML = '设备资源信息';
                dl.insertBefore(dt, dl.firstChild);
                var tempHtml = document.getElementById("gaoxiao_mingchen").outerHTML;
                document.getElementById("gaoxiao_mingchen").innerHTML = tempHtml +
                    '<dd class="fs-14" onclick="pageUp()"><a style="margin-top: 50px;">上一页</a></dd>' +
                    '<dd class="fs-14" onclick="pageDown()"><a>下一页</a></dd>';
                showshiyanshebei(1, sysbpagesize, firstGaoxiaoId);
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

    setTimeout(function () {
        showshiyanshebei(1, pagesize, firstGaoxiaoId);
    }, 300);
}

//高校名称下一页
function pageDown() {
    ++page;
    getData(page, pagesize);

    setTimeout(function () {
        showshiyanshebei(1, pagesize, firstGaoxiaoId);
    }, 300);
}


//试验设备条目
function showshiyanshebei(tpage, tpagesize, gxidentity) {
    var ul = document.body.querySelector('#shebei_name');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/shebeixinxi",
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
                    identity = sessionStorage.getItem('INF-identity');
                    // identity = item["identity"];
                    shebei_name = item["shebei_name"];
                    tianbao_danwei_xiao = item["tianbao_danwei_xiao"];
                    shebei_number2 = "'" + item["shebei_number"] + "'";
                    var li = document.createElement('li');
                    li.innerHTML = '<a onclick="showdetails(' + shebei_number2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 70%; background-color: rgba(255, 255, 255, 0)">' + shebei_name + '</h2>' +
                        '<p class="one_hidden fr fs-14" style="width: 20%; background-color: rgba(255, 255, 255, 0)">' + tianbao_danwei_xiao + '</p></a>';
                    ul.insertBefore(li, ul.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("此高校无更多实验设备信息了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


//详情页跳转
function showdetails(ident) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", ident);
    window.location.href = "/sysbxq?identity=" + sessionStorage.getItem("INF-identity");
}


//试验设备条目上一页
function sysbpageDown() {
    a = sessionStorage.getItem('aa');
    if (a > sysbpage) {
        ++sysbpage;
        showshiyanshebei(sysbpage, sysbpagesize, identity)
    } else {
        alert("这个是最后一页");
    }
}


//试验设备条目下一页
function sysbpageUp() {
    if (sysbpage === 1) {
        alert("当前是第一页")
    } else {
        --sysbpage;
        showshiyanshebei(sysbpage, sysbpagesize, identity)
    }

}


