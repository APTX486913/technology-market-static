//高校名称
var page = 1;
var pagesize = 5;

var name;
var type;
var results_type;
var id;


//分页判断
var totalPages;
var moduleName = 'chengguoxinxi';
var ord_id = sessionStorage.getItem('INF-identity');
var pageSize = 20;
var a = sessionStorage.getItem('aa');


var cgpage = 1;
var cgpagesize = 20;
var results_name;
var identity = sessionStorage.getItem('INF-identity');


var firstGaoxiaoId = 2;
var firstGaoxiaoName;

var identification_number;
var ident;


//页面渲染
window.onload = rendPage();


function rendPage() {
    getData(page, pagesize);//高校名称
    getDataSsdw(page, pagesize);//所属单位—选择器
    getDataCglx();//成果类型-选择器
    getDataPjfs();//评价方式-选择器

    // setTimeout(function () {
    //     showchengguoxinxi(1, cgpagesize, firstGaoxiaoId);
    // }, 300);
}

//所属单位-选择器
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


//成果类型-选择器
function getDataCglx() {
    var select = document.getElementById('AreaId1');
    $.ajax({
        type: 'post',
        url: "/api/chengguoleixing",
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
                    option.results_type = data["value"]["results_type"];
                    results_type = item["results_type"];
                    id = item["id"];
                    option.className = "selectdiv fl";
                    option.value = id;
                    option.innerHTML = '<a> 成果展示：' + results_type + '</a>';
                    select.insertBefore(option, select.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


//监听评价水平选择器变动
$("#AreaId2").change(function () {
    var a = $("#AreaId2").val();
    if (a == "00") {
        $("#AreaId3").html("<option>评价水平：不限</option>");
    }
    if (a == "01") {
        getDataJdpj();
    }
    if (a == "02") {
        getDataJtpj();
    }
    if (a == "03") {
        getDataYspj();
    }
});


//获取评价方式
function getDataPjfs() {
    var select = document.getElementById('AreaId2');
    $.ajax({
        type: 'post',
        url: "/api/pingjiafangshi",
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
                    option.innerHTML = '<a> 评价方式：' + type + '</a>';
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


//评价方式（鉴定评价）获取数据
function getDataJdpj() {
    var select = document.getElementById('AreaId3');
    $.ajax({
        type: 'post',
        url: "/api/jiandingpingjia",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    type = item["type"];
                    id = item["id"];
                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>评价水平：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">评价水平：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


//评价方式（结题评价）获取数据
function getDataJtpj() {
    var select = document.getElementById('AreaId3');
    $.ajax({
        type: 'post',
        url: "/api/jietipingjia",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    type = item["type"];
                    id = item["id"];
                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>评价水平：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">评价水平：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


//评价方式（验收评价）获取数据
function getDataYspj() {
    var select = document.getElementById('AreaId3');
    $.ajax({
        type: 'post',
        url: "/api/yanshoupingjia",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    type = item["type"];
                    id = item["id"];
                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>评价水平：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">评价水平：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


// 学校名称
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
                    dd.identity = item['identity'];
                    identity = item['identity'];
                    name = item['name'];

                    //记录第一所高校ID，默认展示其成果信息
                    if (index === 0) {
                        firstGaoxiaoId = item['identity'];
                        sessionStorage.setItem("INF-identity", firstGaoxiaoId);
                        firstGaoxiaoName = item['name'];
                        sessionStorage.setItem("INF-name", firstGaoxiaoName);
                    }

                    dd.className = 'fs-14';
                    dd.innerHTML = '<a onclick="showpage(' + item['identity'] + '\,\'' + item['name'] + '\');"> ' + item['name'] + '</a>';
                    dl.insertBefore(dd, dl.lastChild);
                    indexNumber++;
                });


                var dt = document.createElement('dt');
                dt.className = "fs-16";
                dt.innerHTML = '理工成果';
                dl.insertBefore(dt, dl.firstChild);
                var tempHtml = document.getElementById("gaoxiao_mingchen").outerHTML;
                document.getElementById("gaoxiao_mingchen").innerHTML = tempHtml +
                    '<dd class="fs-14" onclick="pageUp()"><a style="margin-top: 50px;">上一页</a></dd>' +
                    '<dd class="fs-14" onclick="pageDown()"><a>下一页</a></dd>';
                showchengguoxinxi(1, cgpagesize, firstGaoxiaoName);


                // size=totalPages;


            } else if (data['status'] === 200) {
                mui.alert("无更多内容了");
            } else {
                mui.alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


//学校名称点击上一页翻页
function pageUp() {
    --page;
    getData(page, pagesize);
}

//学校名称点击下一页翻页
function pageDown() {
    ++page;
    getData(page, pagesize);
}


// 点击调用的获取identity 函数和加载页面函数
function showpage(identity, schoolName) {
    //初始化成果页码
    cgpage = 1;
    showchengguo(identity, schoolName);
    showchengguoxinxi(cgpage, cgpagesize, schoolName);
    gettotalPages(moduleName, ord_id, pageSize);//获取成果页码
}

//存储获取的identity
function showchengguo(identity, schoolName) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", identity);
    sessionStorage.removeItem('INF-name');
    sessionStorage.setItem("INF-name", schoolName);
}

//成果信息条目加载
function showchengguoxinxi(tpage, tpagesize, gxname) {
    var ul = document.body.querySelector('#chengguo_name');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/filtrategetResultByTS",
        timeout: 15000,
        dataType: "json",
        data: {
            page: tpage,
            pagesize: tpagesize,
            school: gxname,
            results_TypeId: "02"
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    identity = sessionStorage.getItem('INF-identity');
                    results_name = item["results_name"];
                    subordinate_units = item["subordinate_units"];
                    ident = "'" + item["identification_number"] + "'";
                    var li = document.createElement('li');
                    li.innerHTML = '<a onclick="showdetails(' + ident + ')"><h2 class="one_hidden fs-14 fl" style="width: 70%; background-color: rgba(255, 255, 255, 0)"  style="">' + results_name + '</h2>' +
                        '<p class="one_hidden fr fs-14" style="width: 20%; background-color: rgba(255, 255, 255, 0)">' + subordinate_units + '</p></a>';
                    ul.insertBefore(li, ul.lastChild);
                    // li.className = "li-style";
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("此高校无更多成果信息了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


////详情获取identification_number函数
function showdetails(number) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", number);
    window.location.href = "/cgxxxq?identity=" + sessionStorage.getItem("INF-identity");
}


//获取成果信息页数
function gettotalPages(moduleName, org_id, pageSize) {
    $.ajax({
        type: 'post',
        url: "/api/getPagingInformation",
        timeout: 15000,
        dataType: "json",
        data: {
            moduleName: 'chengguoxinxi',
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


//成果信息下一页
function cgpageDown() {
    a = sessionStorage.getItem('aa');
    if (a > cgpage) {
        ++cgpage;
        showchengguoxinxi(cgpage, cgpagesize, identity)
    } else {
        alert("这个是最后一页");
    }
}


//成果信息上一页
function cgpageUp() {
    if (cgpage === 1) {
        alert("当前是第一页")
    } else {
        --cgpage;
        showchengguoxinxi(cgpage, cgpagesize, identity)
    }

}



