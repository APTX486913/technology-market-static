var release_time;
var content;
var id;
var base_name;
var identity = sessionStorage.getItem("INF-identity");
var base_award;
var base_benefit;
var project_level;
var rely_unit;
var ratify_time;
var ratify_department;
var site;
var category;
var fuzeren_name;
var fuzuren_age;
var fuzeren_duty;
var fuzeren_unit;
var fuzeren_parttime_job;
var fuzeren_award;
var team_introduction;
var base_intro;
var social_benefit;
var connect_people;
var connect_number;
var e_mail;
var mailing_address;
var postcode;
var remark;
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
        url: "/api/socialbasexiangxi",
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
                    base_name = item["base_name"];
                    id = item["id"];
                    var li = document.createElement('li');
                    li.innerHTML = '<a><h2 class="fs-18">' + base_name + '</h2>' +
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
        url: "/api/socialbasexiangxi",
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
                    ratify_time = item["ratify_time"];
                     site = item["site"];
                    ratify_department = item["ratify_department"];
                    undertaking_unit = item["undertaking_unit"];
                    project_number = item["project_number"];
                    category = item["category"];
                    fuzeren_name = item["fuzeren_name"];
                    fuzuren_age = item["fuzuren_age"];
                    fuzeren_unit = item["fuzeren_unit"];
                    fuzeren_duty = item["fuzeren_duty"];
                    //fuzeren_parttime_job = item["fuzeren_parttime_job"];
                    fuzeren_award = item["fuzeren_award"];
                    //social_benefit = item["social_benefit"];
                    connect_number=item["connect_number"];
                    mailing_address=item["mailing_address"];
                    e_mail=item["e_mail"];
                    rely_unit=item["rely_unit"];
                    postcode=item["postcode"];
                    connect_people=item["connect_people"];
                    e_mail=item["e_mail"];
                    var table = document.createElement('table');
                    table.className = "cinfo";
                    table.innerHTML = '<tr><td>批准部门：' + ratify_department + '</td>' + '<td>批准时间：' + ratify_time + '</td></tr>' +
                        '<tr><td>所在地点：' +  site + '</td>' + '<td>学科门类：' + category + '</td></tr>' +
                        '<tr><td>负责人姓名：' + fuzeren_name + '</td>' + '<td>负责人年龄：' + fuzuren_age + '</td></tr>' +
                        '<tr><td>负责人所在职称职务：' + fuzeren_duty + '</td>' + '<td>负责人所在单位：' + fuzeren_unit + '</td></tr>' +
                        // '<tr><td>负责人社会兼职：' + fuzeren_parttime_job + '</td>' + '<td>负责人获得奖励情况：' + fuzeren_award + '</td></tr>'+
                    '<tr><td>负责人获得奖励情况：' + fuzeren_award + '</td>' + '<td>联系人：' +connect_people + '</td></tr>'+
                    '<tr><td>联系电话：' + connect_number + '</td>' + '<td>电子邮件：' + e_mail + '</td></tr>'+
                    '<tr><td>通信地址：' + mailing_address + '</td>'+'<td>依托单位：'+rely_unit+'</td></tr>'+
                    '<tr><td>邮编：'+postcode+'</td></tr>';
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
        url: "/api/socialbasexiangxi",
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
                    social_benefit = item["social_benefit"];
                    fuzeren_award = item["fuzeren_award"];
                    team_introduction=item["team_introduction"];
                    base_intro=item["base_intro"];
                    var li = document.createElement('li');
                    li.className = "fs-14";
                    li.innerHTML = '<a style="margin-left: 2px">团队情况:' + team_introduction + '</a>' +
                    '<br>'+'<a style="margin-left: 2px">负责人获奖情况：'+fuzeren_award+'</a>'+
                    '<br>'+'<a style="margin-left: 2px">社会效益情况：'+social_benefit+'</a>'+
                        '<br>'+'<a style="margin-left: 2px">其他介绍：'+base_intro+'</a>';
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