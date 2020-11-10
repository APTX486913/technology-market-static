var project_number;
var project_name;
var identity = sessionStorage.getItem('INF-identity');
var project_type;
var contract_number;
var person_in_charge;
var start_time;
var end_time;
var contract_funding;
var project_level;
var service_industry;
var undertaking_unit;
var canjiadanwei1;
var canjiadanwei2;
var project_state;
var content_abstract;
var contact;
var contact_phone_number;
var e_mail;
var communication_address;
var postal_code;
var jingshouren;
var registration_data;
var approval_mark;
var audit_results_school;
var audit_results_hall;
var comment;
var organization_id;
var verifier_scchool;
var verifier_hall;
var reporting_unit_court;
var reporting_unit_school;
//页面渲染
window.onload = rendPage();

function rendPage() {
    title(identity);
    main(identity);
    footer(identity);
}

//获取项目名称，id
function title(identity) {
    var ul = document.body.querySelector('#title');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/xiangmuxxxinxi",
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
                    project_name = item["project_name"];
                    project_number = item["project_number"];
                    var li = document.createElement('li');
                    li.innerHTML = '<a><h2 class="fs-18">' + project_name + '</h2>' +
                        '<h3 class="fs-14">' + project_number + '</h3></a>';
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


//显示具体信息
function main(identity) {
    var div = document.body.querySelector('#main');
    div.innerHTML = "<table></table>";
    $.ajax({
        type: 'post',
        url: "/api/xiangmuxxxinxi",
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
                    project_type = item["project_name"];
                    person_in_charge = item["person_in_charge"];
                    project_level = item["project_level"];
                    undertaking_unit = item["undertaking_unit"];
                    canjiadanwei1=item["canjiadanwei1"];
                    canjiadanwei2=item["canjiadanwei2"];
                    project_number = item["project_number"];
                    contract_number = item["contract_number"];
                    start_time = item["start_time"];
                    end_time = item["end_time"];
                    service_industry = item["service_industry"];
                    project_state = item["project_state"];
                    contact_phone_number = item["contact_phone_number"];
                    e_mail = item["e_mail"];
                    contract_funding=item["contract_funding"];
                    postal_code = item["postal_code"];
                    jingshouren = item["jingshouren"];
                    registration_data = item["registration_data"];
                    approval_mark = item["approval_mark"];
                    audit_results_school = item["audit_results_school"];
                    audit_results_hall = item["audit_results_hall"];
                    organization_id = item["organization_id"];
                    verifier_scchool = item["verifier_scchool"];
                    verifier_hall = item["verifier_hall"];
                    reporting_unit_court = item["reporting_unit_court"];
                    reporting_unit_school = item["reporting_unit_school"];
                    communication_address = item["communication_address"];
                    contact = item["contact"];
                    var table = document.createElement('table');
                    table.className = "cinfo";
                    table.innerHTML = '<tr><td>项目来源：' + project_level + '</td>' + '<td>合同编号：' + contract_number + '</td></tr>' +
                        '<tr><td>负责人：' + person_in_charge + '</td>' + '<td>开始时间：' + start_time + '</td></tr>' +
                        '<tr><td>结束时间：' + end_time + '</td>' + '<td>合同经费：' + contract_funding + '</td></tr>' +
                        '<tr><td>项目级别：' + project_type + '</td>' + '<td>服务行业：' + service_industry + '</td></tr>' +
                        '<tr><td>承担单位：' + reporting_unit_school + '</td>' + '<td>参加单位1：' + canjiadanwei1 + '</td></tr>' +
                        '<tr><td>参加单位2：' + canjiadanwei2 + '</td>' + '<td>项目状态：' + project_state + '</td></tr>' +
                        '<tr><td>联系人：' + contact + '</td>' + '<td>联系电话：' + contact_phone_number + '</td></tr>' +
                        '<tr><td>电子邮箱：' + e_mail + '</td>' + '<td>通讯地址：' + communication_address + '</td></tr>' +
                        '<tr><td>邮编：' + postal_code + '</td>' + '<td>经手人：' + jingshouren + '</td></tr>' +
                        '<tr><td>登记日期：' + registration_data + '</td>' + '<td>审批标志：' + approval_mark + '</td></tr>' +
                        '<tr><td>校审核结果：' + audit_results_school + '</td>' + '<td>厅审核结果：' + audit_results_hall + '</td></tr>';
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


//下部
function footer(identity) {
    var ul = document.body.querySelector('#footer');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/xiangmuxxxinxi",
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
                    content_abstract  = item["content_abstract"];
                    comment  = item["comment"];
                    var li = document.createElement('li');
                    li.className = "fs-14";
                    li.innerHTML = '<a style="margin-left: 2px">内容简介:' + content_abstract + '</a><br>'+'<a style="margin-left: 2px;">备注：'+comment+'</a>';
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






