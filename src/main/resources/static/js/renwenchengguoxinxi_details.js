var release_time;
var content;
var id;
var result_name;
var identity = sessionStorage.getItem("INF-identity");
var result_award;
var result_benefit;
var category;
var result_accept;
var application_area;
var affiliated_unit;
var use_unit;
var use_time;
var result_intro;
var accomplish_people;
var contact_people;
var contact_number;
var E_mail;
var mailing_address;
var postcode;
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
    // alert("lllll");
    $.ajax({
        type: 'post',
        url: "/api/socialresultxiangxi",
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
                    identity = item["identity"];
                    result_name = item["result_name"];
                    id = item["id"];
                    var li = document.createElement('li');
                    li.innerHTML = '<a><h2 class="fs-18">' + result_name + '</h2>' +
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
        url: "/api/socialresultxiangxi",
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
                    identity = sessionStorage.getItem("INF-identity");
                    identity = item["identity"];
                    result_award = item["result_award"];
                    result_benefit = item["result_benefit"];
                    category = item["category"];
                    undertaking_unit = item["undertaking_unit"];
                    project_number = item["project_number"];
                    result_accept = item["result_accept"];
                    application_area = item["application_area"];
                    affiliated_unit = item["affiliated_unit"];
                    use_time = item["use_time"];
                    use_unit = item["use_unit"];
                    accomplish_people = item["accomplish_people"];
                    contact_people = item["contact_people"];
                    contact_number = item["contact_number"];
                    E_mail = item["E_mail"];
                    mailing_address=item["mailing_address"];
                    postcode=item["postcode"];
                    var table = document.createElement('table');
                    table.className = "cinfo";
                    table.innerHTML = '<tr><td>学科门类：' + category + '</td>' + '<td>成果获奖情况：' + result_award + '</td></tr>' +
                        '<tr><td>成果社会效益：' + result_benefit + '</td>' + '<td>成果引用或被采纳情况：' + result_accept + '</td></tr>' +
                        '<tr><td>应用领域：' + application_area + '</td>' + '<td>所属单位：' + affiliated_unit + '</td></tr>' +
                        '<tr><td>出版、发表或使用单位：' + use_unit + '</td>' + '<td>出版、发表或使用时间：' + use_time + '</td></tr>' +
                        '<tr><td>完成人：' + accomplish_people + '</td>' + '<td>联系人：' + contact_people + '</td></tr>'+
                        '<tr><td>联系电话：' + contact_number + '</td>' + '<td>电子邮件：' + E_mail + '</td></tr>'+
                        '<tr><td>通信地址：' + mailing_address + '</td>' + '<td>邮编：' + postcode + '</td></tr>';
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
        url: "/api/socialresultxiangxi",
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
                    identity = item["identity"];
                    result_intro = item[result_intro];
                    var li = document.createElement('li');
                    li.className = "fs-14 ";
                    li.innerHTML = '<a style="margin-left: 2px">成果简介:' + result_intro + '</a>';
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