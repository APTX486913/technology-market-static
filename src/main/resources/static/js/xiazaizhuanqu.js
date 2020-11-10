var xzpage=1;
var xzpagesize=20;
var id;
var id2;
var download_title;
var release_time;
var file_id = sessionStorage.getItem('INF-identity');

window.onload=rendPage();

function rendPage() {
    showxiazaizhuanqu(xzpage,xzpagesize);
}


function showxiazaizhuanqu(page,pagesize) {
    var ul = document.body.querySelector('#xiazaizhuanqu');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/download",
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
            // alert("lll");
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    file_id = sessionStorage.getItem("INF-identity");
                    var li = document.createElement('li');
                    li.download_title = item["download_title"];
                    li.release_time = item["release_time"];

                    download_title = item["download_title"];
                    release_time = item["release_time"];
                    id2 = "'" + item["id"] + "'";
                    // id=data["value"]["id"];
                    var li = document.createElement('li');
                    li.innerHTML = '<a onclick="showdetails(' + id2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 70%;margin-top: 10px;margin-left: 20px">' + download_title + '</h2>'+
                        '<p class="one_hidden fr fs-12" style="width: 20%;">' + release_time + '</p></a>';
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


function xzpageDown() {
    ++xzpage;
    showxiazaizhuanqu(xzpage, xzpagesize)
}

//成果信息下一页
function xzpageUp() {
    --xzpage;
    showxiazaizhuanqu(xzpage, xzpagesize)
}

function showdetails(number) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", number);
    window.location.href = "/xzzqxq?file_id=" + sessionStorage.getItem("INF-identity");
}