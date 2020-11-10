var release_time;
var content;
var id;
var headline;
var notification_id = sessionStorage.getItem("INF-identity");

//页面渲染
window.onload = rendPage();

function rendPage() {
    title(notification_id);
    main(notification_id);
    footer(notification_id);
}

//获取需求名字。ID
function title(notification_id) {
    var ul = document.body.querySelector('#title');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/tongzhineirong",
        timeout: 15000,
        dataType: "json",
        data: {
            notification_id: sessionStorage.getItem("INF-identity"),
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    notification_id = sessionStorage.getItem('INF-identity');
                    notification_id = item["notification_id"];
                    headline = item["headline"];
                    id = item["id"];
                    var li = document.createElement('li');
                    li.innerHTML = '<a><h2 class="fs-18">' + headline + '</h2>' +
                        '</a>';
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
function main(notification_id) {
    var ul = document.body.querySelector('#main');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/tongzhineirong",
        timeout: 15000,
        dataType: "json",
        data: {
            notification_id: sessionStorage.getItem("INF-identity"),
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {

                indexNumber = 1;

                $.each(data['value'], function (index, item) {
                    notification_id = sessionStorage.getItem('INF-identity');
                    notification_id = item["notification_id"];
                    release_time=item["release_time"];
                    content = item["content"];
                    var li = document.createElement('li');
                    li.className = "fs-14 ";
                    li.innerHTML = '<a>' + content + '</a>';// +'<a>下载链接:' + content + '</a>';
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


//需求描述
function footer(notification_id) {
    var ul = document.body.querySelector('#footer');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/tongzhineirong",
        timeout: 15000,
        dataType: "json",
        data: {
            notification_id: sessionStorage.getItem("INF-identity"),
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    notification_id = sessionStorage.getItem('INF-identity');
                    notification_id = item["notification_id"];
                   release_time=item['release_time'];
                    var li = document.createElement('li');
                    li.classheadline = "fs-14 ";
                    li.innerHTML = '<a>发布时间:' + release_time + '</a>';
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