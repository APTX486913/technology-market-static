var shebei_number;
var shebei_name;
var identity = sessionStorage.getItem("INF-identity");
var project_type;
var person_in_charge;
var keyword;
var picture;
var undertaking_unit;
var production_unit;
var start_time;
var service_life;
var price;
var introduction;
var quantity;
var purpose;
var linkman;
var contact_number;
var e_mail;
var mailing_address;
var postcode;
var jing_shou_ren;
var register_date;
var review_sign;
var audit_result_xiao;
var audit_result_ting;
var remarks;
var group_number;
var auditor_xiao;
var auditor_ting;
var tianbao_danwei_yuan;
var tianbao_danwei_xiao;

window.onload = rendPage();

function rendPage() {
    title(identity);
    main(identity);
    footer(identity);
}

//获取试验设备的名字，id
function title(identity) {
    var ul = document.body.querySelector('#title');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/shiyanxinxi",
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
                    shebei_name = item["shebei_name"];
                    shebei_number = item["shebei_number"];


                    var li = document.createElement('li');

                    li.innerHTML = '<a><h2 class="fs-18">' + shebei_name + '</h2>' +
                        '<h3 class="fs-14">' + shebei_number + '</h3></a>';


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



//获取主要条目
function main(identity) {
    var div = document.body.querySelector('#main');
    div.innerHTML = "<table></table>";

    $.ajax({
        type: 'post',
        url: "/api/shiyanxinxi",
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
                    keyword = item["keyword"];
                    undertaking_unit = item["undertaking_unit"];
                    shebei_number = item["shebei_number"];
                    production_unit=item["production_unit"];
                    service_life=item["service_life"];
                    price=item["price"];
                    start_time=item["start_time"];
                    quantity=item["quantity"];
                    purpose=item["purpose"];
                    picture=item["picture"];
                    linkman=item["linkman"];
                    contact_number=item["contact_number"];
                    e_mail=item["e_mail"];
                    mailing_address=item["mailing_address"];
                    register_date=item["register_date"];
                    postcode=item["postcode"];
                    jing_shou_ren=item["jing_shou_ren"];
                    review_sign=item["review_sign"];
                    audit_result_xiao=item["audit_result_xiao"];
                    audit_result_ting=item["audit_result_ting"]

                    var table = document.createElement('table');
                    table.className = "cinfo";

                    table.innerHTML = '<tr><td rowspan="6" style="width: 30%"><img src=picture width="300" height="300" /></td>'+'<td style="width: 30%">关键字：' + keyword + '</td>' + '<td style="width: 30%">生产单位：' +production_unit+'</td></tr>' +
                        '<tr><td style="width: 30%">使用寿命：' +  service_life + '</td>' + '<td style="width: 30%">设备价格：' +price+'</td></tr>' +
                        '<tr><td style="width: 30%">启用日期：' + start_time + '</td>' + '<td style="width: 30%">设备数量：' +quantity+'</td></tr>' +
                        '<tr><td style="width: 30%">设备用途：' + purpose + '</td>' + '<td style="width: 30%">联系人：' +linkman +'</td></tr>'+
                        '<tr><td style="width: 30%">联系电话：' + contact_number  + '</td>' + '<td style="width: 30%">电子邮箱：' +e_mail +'</td></tr>'+
                        '<tr><td style="width: 30%">通信地址：' + mailing_address  + '</td>' + '<td style="width: 30%">邮编：' +postcode  +'</td></tr>'+
                        '<tr><td style="width: 30%">经手人：' + jing_shou_ren  + '</td>' + '<td style="width: 30%">登记日期：' +register_date  +'</td></tr>'+
                        '<tr><td style="width: 30%">审批标志：' + review_sign + '</td>' + '<td style="width: 30%">校审核结果：' +audit_result_xiao  +'</td></tr>'+
                        '<tr><td style="width: 30%">厅审核结果：' + audit_result_ting + '</td></tr>';


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

//试验设备的详细条目
function footer(identity) {
    var ul = document.body.querySelector('#footer');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/shiyanxinxi",
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
                    remarks=item["remarks"];
                    introduction=item["introduction"]


                    var li = document.createElement('li');
                    li.className = "fs-14";

                    li.innerHTML = '<a style="margin-left: 2px">设备简介:' + introduction + '</a><br>'+'<a style="margin-left: 2px;">备注：'+remarks+'</a>';


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