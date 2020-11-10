var identity;
var name;
var photo;

var page = 1;
var pagesize = 15;
var getall = 0

window.onload = rendPage();

function rendPage() {
    getData(page, pagesize);
}


function getData(page, pagesize) {
    var ul = document.body.querySelector('#gaoxiao_mingchen');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/suoshudanwei",
        timeout: 15000,
        dataType: "json",
        data: {
            page: page,
            pagesize: pagesize,
            getall: 1
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    var li = document.createElement('li');
                    var bigImg = document.createElement("img");
                    li.name = item['name'];
                    li.identity = item['identity'];
                    li.photo = item["photo"];
                    identity = item['identity'];
                    name = item['name'];
                    photo = item["photo"]
                    bigImg.src = photo;
                    console.log(name+":"+photo);
                    li.innerHTML = '<a href="'+gaoxiaoUrl[name]+'" target="_blank"><img style="height: 130px;" src="' + 'image/' + photo + '"><p class="fs-14 fc3 one_hidden text-c">' + name + '</p></a>';
                    ul.insertBefore(li, ul.lastChild);
                    indexNumber++;
                });


            } else if (data['status'] === 200) {
                mui.alert("无更多内容了");
            } else {
                mui.alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}