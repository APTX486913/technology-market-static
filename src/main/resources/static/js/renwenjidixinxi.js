//高校名称
var page = 1;
var pagesize = 5;
var name;

var indexNumber = 1;

/**
 * 页面问题：获取页数出现问题gettotalPages()
 * */

var rely_unit;//依托单位
var id;//人文基地
var firstGaoxiaoId = 2;//第一个高校



var rwpagesize = 20;//条目数量
var rwpage = 1;//条目页数
var base_name;//基地名称
var identity = sessionStorage.getItem('INF-identity');


//分页判断
var totalPages;
var moduleName='renwenjidi';
var ord_id=sessionStorage.getItem('INF-identity');
var a=sessionStorage.getItem('aa');

//页面渲染
window.onload = rendPage();

function rendPage() {
    getData(page, pagesize);//高校名称
}


// 学校名称
function getData(ipage, pagesize) {
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
                    }

                    dd.className = 'fs-14';
                    dd.innerHTML = '<a onclick="showpage(' + item['identity'] + ')"> ' + item['name'] + '</a>';
                    dl.insertBefore(dd, dl.lastChild);
                    indexNumber++;
                });


                var dt = document.createElement('dt');
                dt.className = "fs-16";
                dt.innerHTML = '人文基地';
                dl.insertBefore(dt, dl.firstChild);
                var tempHtml = document.getElementById("gaoxiao_mingchen").outerHTML;
                document.getElementById("gaoxiao_mingchen").innerHTML = tempHtml +
                    '<dd class="fs-14" onclick="pageUp()"><a style="margin-top: 50px;">上一页</a></dd>' +
                    '<dd class="fs-14" onclick="pageDown()"><a>下一页</a></dd>';
                showrenwenjidi(rwpage, rwpagesize,  firstGaoxiaoId);
            } else if (data['status'] === 200) {
                mui.alert("此高校无更多人文基地信息了");
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
function showpage(identity) {
    //初始化成果页码
    rwpage = 1;
    showrenwen(identity);
    showrenwenjidi(rwpage, rwpagesize, identity);//展示列表
}

//存储获取的identity
function showrenwen(identity) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", identity);
}


//人文社科条目加载
function showrenwenjidi(tmpage,tmpagesize,tmidentity) {
    var ul = document.body.querySelector('#renwen_name');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/socialbase",
        timeout: 15000,
        dataType: "json",
        data: {
            page: tmpage,
            pagesize: tmpagesize,
            identity: tmidentity
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    identity = sessionStorage.getItem('INF-identity');

                    base_name = item["base_name"];
                    rely_unit = item["rely_unit"];
                    id2 = "'" + item["id"] + "'";
                    var li = document.createElement('li');
                    li.innerHTML = '<a onclick="showdetails(' + id2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 70%;background-color:rgba(255,255,255,0);">' + base_name + '</h2>' +
                        '<p class="one_hidden fr fs-14" style="width: 20%;background-color:rgba(255,255,255,0);">' + rely_unit + '</p></a>';
                    ul.insertBefore(li, ul.lastChild);
                    indexNumber++;
                });
                gettotalPages(moduleName,ord_id, rwpagesize);//获取人文社科页码

            } else if (data['status'] === 200) {
                alert("无更多内容了");
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
    window.location.href = "/rwjdxq?identity=" + sessionStorage.getItem("INF-identity");
}


// //获取成果信息页数
function gettotalPages(moduleName,org_id, pageSize) {
    $.ajax({
        type: 'post',
        url: "/api/getPagingInformation",
        timeout: 15000,
        dataType: "json",
        data: {
            moduleName: 'renwenjidi',
            org_id:sessionStorage.getItem('INF-identity'),
            pageSize: pageSize,

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
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


//人文基地信息下一页
function rwpageDown() {
    a=sessionStorage.getItem('aa');
    if (a > rwpage) {
        ++rwpage;
        showrenwenjidi(rwpage, rwpagesize, identity);
    }
    else{
        alert("这是最后一页");
    }
}


//上一页
function rwpageUp() {

    if (rwpage===1) {
        alert("当前是第一页")
    }
    else{
        --rwpage;
        showchengguoxinxi(rwpage, rwpagesize, identity)
    }

}



