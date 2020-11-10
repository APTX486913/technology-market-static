//项目需求
var page = 1;
var pagesize = 20;
var name;
var id;
var id2;
//需求类型选择器
var type;

//分页判断
var totalPages;
var moduleName='qiyexuqiu';
var ord_id=2;
var pageSize=20;
var a=sessionStorage.getItem('aa');

var identity = sessionStorage.getItem("INF-identity");

var indexNumber = 1;


//页面渲染
window.onload = rendPage();

function rendPage() {
    showqiyexuqiu(page, pagesize);
    xuqiuleixing();

}


//展示企业需求
function showqiyexuqiu(page, pagesize) {
    $.ajax({
        type: 'post',
        // url: "/api/filtrategetRequirement",
        url: "/api/comrequire",
        timeout: 15000,

        dataType: "json",
        data: {
            // identity = sessionStorage.getItem('INF-identity'),
            // requirement_type:'03',
            page: page,
            pagesize: pagesize,
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                var ul = document.body.querySelector('#qiyexuqiu');
                ul.innerHTML = "<li></li>";
                $.each(data['value'], function (index,item) {
                    identity = sessionStorage.getItem('INF-identity');
                    var li = document.createElement('li');
                    li.name = item["name"];
                    name = item["name"];
                    id = item["id"];
                    id2 = "'" + item["id"] + "'";
                    li.innerHTML = '<a onclick="showdetails(' + id2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 70%; margin-top: 10px; margin-left: 20px; background-color: rgba(255, 255, 255, 0)">' + name + '</h2>'
                    '</a>';
                    ul.insertBefore(li, ul.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                --page;
                alert("已经是最后一页了");
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
            moduleName: 'qiyexuqiu',
            org_id:ord_id,
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
                    // alert(data["value"]["totalPages"]);
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


//下一页
function pageDown() {
    ++page;
    showqiyexuqiu(page, pagesize, identity);
}

//上一页
function pageUp() {
    if(page===1){
        alert("当前是第一页");
    }
    else{
        --page;
        showqiyexuqiu(page, pagesize);
    }

}


//需求类型选择器
function xuqiuleixing() {
    var select = document.getElementById('hhhh');
    $.ajax({
        type: 'post',
        url: "/api/xuqiuleixing",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    type = item["type"];
                    id = item["id"];
                    option.className = "selectdiv fl";
                    option.value = id;
                    option.innerHTML = '<a> 需求类型：' + type + '</a>';
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


//详情跳转
function showdetails(id) {
    // alert(id);
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", id);
    window.location.href = "/qyxqxq?identity=" + sessionStorage.getItem("INF-identity");
}