var platform_number;
var name;
var identity = sessionStorage.getItem("INF-identity");
var industry_1;
var industry_2;
var undertaking_unit;
var address;
var person_in_charge;
var platform_classification;
var attached_unit;
var approval_unit;
var establishment_time;
var unit_introduction;
var unit_homepage;
var contact;
var contact_phone_number;
var e_mail;
var postal_code;
var jingshouren;
var registration_data;
var approval_mark;
var audit_results_school;
var audit_results_hall;
var remark;
var organization_id;
var verifier_scchool;
var verifier_hall;
var reporting_unit_court;
var reporting_unit_school;


window.onload = rendPage();

function rendPage() {
    title(identity);
    main(identity);
    footer(identity);
}

//获取平台名字，id
function title(identity) {
    var ul = document.body.querySelector('#title');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/innovatexiangxi",
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
                    name = item["name"];
                    platform_number = item["platform_number"];
                    var li = document.createElement('li');
                    li.innerHTML = '<a><h2 class="fs-18">' + name + '</h2>' +
                        '<h3 class="fs-14">' + platform_number + '</h3></a>';
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


//主要条目的获取
function main(identity) {
    var div = document.body.querySelector('#main');
    div.innerHTML = "<table></table>";

    $.ajax({
        type: 'post',
        url: "/api/innovatexiangxi",
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
                    address=item["address"];
                    attached_unit=item["attached_unit"];
                    platform_classification = item["platform_classification"];
                    undertaking_unit = item["undertaking_unit"];
                    platform_number = item["platform_number"];
                    person_in_charge=item["person_in_charge"];
                    reporting_unit_court=item["reporting_unit_court"];
                    approval_unit=item["approval_unit"];
                    industry_1=item["industry_1"];
                    industry_2=item["industry_2"];
                    unit_homepage=item["unit_homepage"];
                    contact=item["contact"];
                    contact_phone_number =item["contact_phone_number"];
                    e_mail =item["e_mail"];
                    postal_code =item["postal_code"];
                    jingshouren=item["jingshouren"];
                    registration_data =item["registration_data"];
                    approval_mark =item["approval_mark"];
                    audit_results_school=item["audit_results_school"];
                    audit_results_hall =item["audit_results_hall"];
                    organization_id =item["organization_id"];
                    verifier_scchool =item["verifier_scchool"];
                    verifier_hall=item["verifier_hall"];
                    reporting_unit_court =item["reporting_unit_court"];
                    reporting_unit_school =item["reporting_unit_school"];
                    establishment_time=item["establishment_time"];
                    unit_introduction=item["unit_introduction"];
                    var table = document.createElement('table');
                    table.className = "cinfo";
                    table.innerHTML = '<tr><td>地址：' + address + '</td>' + '<td>负责人：' +person_in_charge+'</td></tr>' +
                        '<tr><td>平台分类：' + platform_classification + '</td>' + '<td>挂靠单位：' +attached_unit +'</td></tr>' +
                        '<tr><td>批准单位：' + approval_unit + '</td>' + '<td>批准成立时间：' +establishment_time +'</td></tr>' +
                        '<tr><td>行业1：' + industry_1 + '</td>' + '<td>行业2：' +industry_2+'</td></tr>' +
                        '<tr><td>单位主页：' + unit_homepage + '</td>'+'<td>单位简介：' + unit_introduction + '</td></tr>'+
                        '<tr><td>联系人：' + contact + '</td>'+'<td>联系电话：' + contact_phone_number + '</td></tr>'+
                        '<tr><td>电子邮箱：' + e_mail + '</td>'+'<td>邮编：' + postal_code + '</td></tr>'+
                        '<tr><td>经手人：' + jingshouren + '</td>'+'<td>登记日期：' + registration_data  + '</td></tr>'+
                        '<tr><td>审批标志：' + approval_mark  + '</td>'+'<td>校审核结果：' + audit_results_school + '</td></tr>'+
                        '<tr><td>厅审核结果：' + audit_results_hall  + '</td>'+'<td>组织编号：' + organization_id  + '</td></tr>'+
                        '<tr><td>校审核人：' + verifier_scchool  + '</td>'+'<td>厅审核人：' + verifier_hall + '</td></tr>'+
                        '<tr><td>填报单位一院：' + reporting_unit_court  + '</td>'+'<td>填报单位一校：' + reporting_unit_school  + '</td></tr>';
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


//知识产权详情
function footer(identity) {
    var ul = document.body.querySelector('#footer');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/innovatexiangxi",
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
                    remark=item["remark"];


                    var li = document.createElement('li');
                    li.className = "fs-14";

                    li.innerHTML = '<a>备注：'+remark+'</a>';


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






