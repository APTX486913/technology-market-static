var name;//需求名称
var type;//需求种类
var date;//需求时间
var content;//需求描述
var id;//需求ID
var e_id;
var status;
var identity = sessionStorage.getItem("INF-identity");
var arr;
var array;



//页面渲染
window.onload = rendPage();

function rendPage() {
    title(identity);
    main(identity);
    footer(identity);
}

//获取需求名字。ID
function title(identity) {
    var ul = document.body.querySelector('#title');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/comxxrequire",
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
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    identity = sessionStorage.getItem('INF-identity');
                    identity = item["INF-identity"];
                    name = item["name"];
                    id = item["id"];
                    var li = document.createElement('li');
                    li.innerHTML = '<a><h2 class="fs-18">' + name + '</h2>' +
                        '<h3 class="fs-14">' + id + '</h3></a>';
                    ul.insertBefore(li, ul.lastChild);
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


//获取主要条目信息
function main(identity) {
    var div = document.body.querySelector('#main');
    div.innerHTML = "<table></table>";
    $.ajax({
        type: 'post',
        url: "/api/comxxrequire",
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

                indexNumber = 1;

                $.each(data['value'], function (index, item) {

                    identity = sessionStorage.getItem('identity');
                    identity = item["identity"];
                    name = item["name"];
                    date = item["date"];
                    type = item["type"];
                    status=item["status"];
                    content = item["content"];
                    e_id = item["e_id"];
                    arr=content.split("\n");
                   var table = document.createElement('table');
                    table.className = "cinfo";
                    table.innerHTML = '<tr><td>项目类型：' + type + '</td>' + '<td>项目ID：' + e_id + '</td></tr>' +
                        '<tr><td>地位：' + status + '</td>' + '<td>项目开始时间：' + date + '</td></tr>'+
                        '<tr><td>' + arr[0] + '</td>' + '<td>' + arr[2] + '</td></tr>'+
                        '<tr><td>' + arr[3] + '</td>' + '<td>' + arr[4] + '</td></tr>'
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


//需求描述
function footer(identity) {
    var ul = document.body.querySelector('#footer');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/comxxrequire",
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
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    identity = sessionStorage.getItem('identity');
                    identity = item["identity"];
                    content = item["content"];
                    array=content.split("\n");
                    var li = document.createElement('li');
                    li.className = "fs-14 ";
                    li.innerHTML = '<a>' + array[1] + '</a>';
                    ul.insertBefore(li, ul.lastChild);
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






