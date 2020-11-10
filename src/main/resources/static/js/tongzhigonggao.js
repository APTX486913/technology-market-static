var page=1;
var pagesize=20;
var notification_id	 = sessionStorage.getItem("INF-identity");
var release_time;
var headline;

var indexNumber=1;

window.onload=rendPage();

function rendPage() {
    showtongzhigonggao(page,pagesize);
}

function showtongzhigonggao(page,pagesize) {
    var ul = document.body.querySelector('#tongzhigonggao');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/tongzhiliebiao",
        timeout: 15000,
        dataType: "json",
        data: {
            page: page,
            pagesize: pagesize,
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index,item) {
                    // alert("lll");
                    notification_id	 = sessionStorage.getItem("INF-identity");
                    var li = document.createElement('li');
                    li.headline = item["headline"];
                    li.release_time = item["release_time"];
                    // identity = item["identity"];
                    headline = item["headline"];
                    release_time = item["release_time"];
                    id2 = "'" + item["id"] + "'";
                    li.innerHTML = '<a onclick="showdetails(' + id2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 70%;margin-top: 10px;margin-left: 20px">' + headline + '</h2>'+
                        '<p class="one_hidden fr fs-12" style="width: 20%;">' + release_time + '</p></a>';
                    ul.insertBefore(li, ul.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("无更多通知公告了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

function showdetails(id) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", id);
    window.location.href = "/tzggxq?notification_id	=" + sessionStorage.getItem("INF-identity");
}