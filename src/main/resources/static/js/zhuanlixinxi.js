var page = 1;
var pagesize = 5;

var name;
var type;
var patent_type_name;
var id;
var serial_number2;
var serial_number;

//分页判断
var totalPages;
var moduleName='zhuanlixinxi';
var ord_id=sessionStorage.getItem('INF-identity');
var pageSize=20;
var a=sessionStorage.getItem('aa');

var indexNumber = 1;

var zlpage = 1;
var zlpagesize = 20;
var zhuanli_name;
var identity = sessionStorage.getItem('INF-identity');

var firstGaoxiaoId = 2;


window.onload = rendPage()

function rendPage() {
    getData(page, pagesize);
    getDataSsdw(page, pagesize);
    getDataZllx();
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
            } else if (data['status'] === 100) {
                toast("无更多内容了");
            } else if (data['status'] === 100) {
                toast("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//专利类型-选择器
function getDataZllx() {
    var select = document.getElementById('AreaId2');
    $.ajax({
        type: 'post',
        url: "/api/typezhuanli",
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
                    option.patent_type_name = data["value"]["patent_type_name"];
                    patent_type_name = item["patent_type_name"];
                    id = item["id"];
                    option.className = "selectdiv fl";
                    option.value = id;
                    option.innerHTML = '<a> 专利展示：' + patent_type_name + '</a>';
                    select.insertBefore(option, select.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 100) {
                toast("无更多内容了");
            } else if (data['status'] === 100) {
                toast("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


/**
 * 拉取学校数据
 */
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
                    name = item['name'];

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
                dt.innerHTML = '专利信息';
                dl.insertBefore(dt, dl.firstChild);

                var tempHtml = document.getElementById("gaoxiao_mingchen").outerHTML;
                document.getElementById("gaoxiao_mingchen").innerHTML = tempHtml +
                    '<dd class="fs-14" onclick="pageUp()"><a style="margin-top: 50px;">上一页</a></dd>' +
                    '<dd class="fs-14" onclick="pageDown()"><a>下一页</a></dd>';
                showzhuanlixinxi(1, zlpagesize, firstGaoxiaoId);
            } else if (data['status'] === 200) {
                mui.toast("无更多内容了");
            } else {
                mui.toast("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//点击上一页翻页
function pageUp() {
    --page;
    getData(page, pagesize);
}

//点击下一页翻页
function pageDown() {
    ++page;
    getData(page, pagesize);
}

// 点击调用的获取identity 函数和加载页面函数
function showpage(identity) {
    //初始化专利页码
    zlpage = 1;
    showzhuanli(identity);
    showzhuanlixinxi(zlpage, zlpagesize, identity);
    gettotalPages(moduleName,ord_id,pageSize);//获取成果页码
}

//存储获取的identity
function showzhuanli(identity) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", identity);
}

//专利信息条目加载
function showzhuanlixinxi(tpage, tpagesize, gxidentity) {
    var ul = document.body.querySelector('#zhuanli_name');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/zhuanlixinxi",
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
                    zhuanli_name = item["name"];
                    patent_person = item["patent_person"];
                    serial_number2 = "'" + item["serial_number"] + "'";
                    var li = document.createElement('li');
                    li.innerHTML = '<a onclick="showdetails(' + serial_number2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 70%; background-color: rgba(255, 255, 255, 0)">' + zhuanli_name + '</h2>' +
                        '<p class="one_hidden fr fs-14" style="width: 20%; background-color: rgba(255, 255, 255, 0)">' + patent_person + '</p></a>';
                    ul.insertBefore(li, ul.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("此高校无更多专利信息了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


function gettotalPages(moduleName,org_id, pageSize) {
    $.ajax({
        type: 'post',
        url: "/api/getPagingInformation",
        timeout: 15000,
        dataType: "json",
        data: {
            moduleName: 'zhuanlixinxi',
            org_id:sessionStorage.getItem('INF-identity'),
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
                    totalPages=data["value"]["totalPages"];
                    sessionStorage.setItem('aa', data["value"]["totalPages"]);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
               // alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });

}


////详情获取identification_number函数
function showdetails(identification_number) {
    sessionStorage.removeItem('zlxxdetai');
    sessionStorage.setItem("zlxxdetai", identification_number);
}


//专利信息下一页
function zlpageDown() {

    a=sessionStorage.getItem('aa');
    if (a > zlpage) {
        ++zlpage;
        showzhuanlixinxi(zlpage, zlpagesize, identity)
    }
    else{
        alert("这个是最后一页");
    }
}

//专利信息上一页
function zlpageUp() {
    if(zlpage===1){
        alert("当前是第一页")
    }
    else{
        --zlpage;
        showzhuanlixinxi(zlpage, zlpagesize, identity)
    }
}

//专利信息详情页跳转
function showdetails(ident) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", ident);
    window.location.href = "/zlxxxq?identity=" + sessionStorage.getItem("INF-identity");
}