//展示变量
var name; //专家名字
var background;//学历
var tianbao_xiao;//填报单位——校
var duty;//职称
var gender;//性别
var industry;//行业



var tpage=1
var tpagesize=20
var gxidentity=2


//详情变量

//页码变量


window.onload = rendPage();

function rendPage() {
    showzhuanjiaxinxi(tpage, tpagesize, gxidentity)
    alert("jhfjdhf")

    // getData(page, pagesize);
    // getDataSsdw(page, pagesize);
    // getDataZc();
    // getDataGender();
    // getDataDhy();
    // gettotalssdwPages(moduleName,org_id, pageSize);
    // alert("lllllll");
}


//专家信息条目加载
function showzhuanjiaxinxi(tpage, tpagesize, gxidentity) {
    var div = document.body.querySelector('#zzzz');
    div.innerHTML = "<table></table>";
    $.ajax({
        type: 'post',
        url: "/api/zhuanjiaxinxi",
        timeout: 15000,
        dataType: "json",
        data: {
            identity: sessionStorage.getItem("INF-identity"),
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                alert("JJJJJ")

                indexNumber = 1;

                $.each(data['value'], function (index, item) {
                    name = item["name"];
                    background = ["education_background"];
                    gender = ["gender"];
                    industry = ["industry_1"];
                    duty = ["duty"]
                    tianbao_xiao = ["tianbao_xiao"];

                    var table = document.createElement('table');
                    table.className = "table";

                    table.innerHTML =
                        '<tr><td>' + name + '</td>' + '<td>' + gender + '</td>' + '<td>' + industry + '</td>'
                        + '<td>' + background + '</td>' + '<td>' + duty + '</td>' + '<td>' + tianbao_xiao + '</td></tr>'
                    div.insertBefore(table, div.lastChild);

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


function searchZJ(moduleName, keywords) {
    var div = document.body.querySelector('#adMain');
    div.innerHTML = "<table></table>";
    // alert("lllll");
    $.ajax({
        type: 'post',
        url: "/api/search",
        timeout: 15000,
        dataType: "json",
        data: {
            moduleName: 'zhuanJia',
            keywords: $("#key").val(),
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {

                indexNumber = 1;

                $.each(data['value'], function (index, item) {

                    name = item["name"];
                    background = ["education_background"];
                    gender = ["gender"];
                    industry = ["industry_1"];
                    duty = ["duty"];
                    tianbao_xiao = ["tianbao_xiao"];

                    var table = document.createElement('table');
                    table.className = "table";

                    table.innerHTML =
                        '<tr><td>' + name + '</td>' + '<td>' + gender + '</td>' + '<td>' + industry + '</td>' + '<td>' + background + '</td>' + '<td>' + tianbao_xiao + '</td></tr>'
                    div.insertBefore(table, div.lastChild);

                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("无匹配的信息");
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
            moduleName: 'zhuanjiaxinxi',
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


////详情获取identification_number函数
function showdetails(ident) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", ident);
    window.location.href = "/zjxxxq?identity=" + sessionStorage.getItem("INF-identity");
}


//首页
function fristPage() {
    showzhuanjiaxinxi(1, zlpagesize, identity)

}

//尾页
function lastPage() {
    showzhuanjiaxinxi(1, zlpagesize, identity)

}

//下一页
function pageDown() {
    a = sessionStorage.getItem('aa');
    if (a > zlpage) {
        ++zlpage;
        showzhuanjiaxinxi(zlpage, zlpagesize, identity)
    } else {
        alert("这个是最后一页");
    }
}

//上一页
function pageUp() {
    if (zlpage === 1) {
        alert("当前是第一页")
    } else {
        --zlpage;
        showzhuanjiaxinxi(zlpage, zlpagesize, identity)
    }
}


// 点击调用的获取identity 函数和加载页面函数
function showpage(identity) {
    //初始化成果页码
    zlpage = 1;
    showzhuanjia(identity);
    showzhuanjiaxinxi(zlpage, zlpagesize, identity);
    gettotalPages(moduleName, org_id, pageSize);//获取成果页码
}

//存储获取的identity
function showzhuanjia(identity) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", identity);
}
