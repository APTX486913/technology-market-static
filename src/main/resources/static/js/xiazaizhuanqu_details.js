var download_title;
var download_link;
var release_time;
var download_content;
var id;
var file_id = sessionStorage.getItem("INF-identity");

//页面渲染
window.onload = rendPage();

function rendPage() {
    title(file_id);
    main(file_id);
    footer(file_id);
}

//获取需求名字。ID
function title(file_id) {
    var ul = document.body.querySelector('#title');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/downloadfile",
        timeout: 15000,
        dataType: "json",
        data: {
            file_id: sessionStorage.getItem("INF-identity"),
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    file_id = sessionStorage.getItem('INF-identity');
                    file_id = item["file_id"];
                    download_title = item["download_title"];
                    id = item["id"];
                    var li = document.createElement('li');
                    li.innerHTML = '<a><h2 class="fs-18">' + download_title + '</h2>' +
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
function main(file_id) {
    var ul = document.body.querySelector('#main');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/downloadfile",
        timeout: 15000,
        dataType: "json",
        data: {
            file_id: sessionStorage.getItem("INF-identity"),
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {

                indexNumber = 1;

                $.each(data['value'], function (index, item) {
                    file_id = sessionStorage.getItem('INF-identity');
                    file_id = item["file_id"];
                    download_content=item["download_content"];
                    download_link = item["download_link"];
                    var li = document.createElement('li');
                    li.classdownload_title = "fs-14 ";
                    li.innerHTML = '<a>' + download_content + '</a>' +'<a>下载链接:' + download_link + '</a>';
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
function footer(file_id) {
    var ul = document.body.querySelector('#footer');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/downloadfile",
        timeout: 15000,
        dataType: "json",
        data: {
            file_id: sessionStorage.getItem("INF-identity"),
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    file_id = sessionStorage.getItem('INF-identity');
                    file_id = item["file_id"];
                    release_time = item["release_time"];
                    var li = document.createElement('li');
                    li.classdownload_title = "fs-14 ";
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