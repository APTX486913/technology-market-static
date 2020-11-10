var identification_number;
var registration_data;//开始时间
var subordinate_units;//所属单位，学院
var results_name;//成果名称
var results_type;//成果类型
var audit_results_school;//是否转化
var reporting_unit_school;//所属单位
var reporting_unit_court;
var audit_results_hall;
var application_field;
var subordinate_units;
var finish_time;
var evaluation_way_level;
var evaluation_date;
var evaluation_institution;
var result_id;
var result_summary;
var wanchengren;
var converted_or_not;
var contact;
var contact_phone_number;
var e_mail;
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




var identity = sessionStorage.getItem("INF-identity");

//页面渲染
window.onload = renderPage();

function renderPage() {
    showname(identity);
    showdetail(identity);
}


//展示成果名字、ID
function showname(identity) {
    var ul = document.body.querySelector('#title');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/chengguoxxxinxi",
        timeout: 15000,
        dataType: "json",
        data: {
            identity: sessionStorage.getItem("INF-identity"),
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            // alert(status);
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    identity = sessionStorage.getItem('INF-identity');
                    results_name = item["results_name"];
                    identification_number = item["identification_number"];
                    var li = document.createElement('li');
                    li.innerHTML = '<a><h2 class="fs-18">' + results_name + '</h2>' +
                        '<h3 class="fs-14">' + identification_number + '</h3></a>';
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


//展示具体条目
function showdetail(identity) {
    var div = document.body.querySelector('#main');
    div.innerHTML = "<table></table>";
    $.ajax({
        type: 'post',
        url: "/api/chengguoxxxinxi",
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
                    results_type=item["results_type"];
                    application_field = item["application_field"];
                    undertaking_unit = item["undertaking_unit"];
                    platform_number = item["platform_number"];
                    application_field=item["application_field"];
                    reporting_unit_court=item["reporting_unit_court"];
                    evaluation_way_level =item["evaluation_way_level"];
                    evaluation_institution=item["evaluation_institution"];
                    result_id =item["result_id"];
                    converted_or_not =item["converted_or_not"];
                    contact=item["contact "];
                    contact_phone_number =item["contact_phone_number"];
                    e_mail =item["e_mail"];
                    finish_time=item["finish_time"];
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
                    communication_address=item["communication_address"];
                    evaluation_date=item["evaluation_date"];
                    result_summary=item["result_summary"];
                    wanchengren=item["wanchengren"];
                    contact=item["contact"];
                    var table = document.createElement('table');
                    table.className = "cinfo";
                    table.innerHTML = '<tr><td>成果类型：' + results_type + '</td>' + '<td>应用领域：' +application_field+'</td></tr>' +
                        '<tr><td>所属单位：' + application_field + '</td>' + '<td>完成时间：' +application_field +'</td></tr>' +
                        '<tr><td>评价方式-水平：' + evaluation_way_level  + '</td>' + '<td>评价日期：' +evaluation_date  +'</td></tr>' +
                        '<tr><td>评价机构：' + evaluation_institution + '</td>' + '<td>成果登记号：' +result_id +'</td></tr>' +
                        '<tr><td>成果简介：' + result_summary  + '</td>'+'<td>完成人：' + wanchengren + '</td></tr>'+
                        '<tr><td>是否已转化：' + converted_or_not  + '</td>'+'<td>联系人：' + contact + '</td></tr>'+
                        '<tr><td>联系电话：' + contact_phone_number + '</td>'+'<td>通信地址：' + communication_address + '</td></tr>'+
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
                alert("信息数据获取失败，可能已被删除，请刷新数据列表重试。", "数据获取失败！");
            } else {
                alert("当前操作出现错误，请联系系统维护人员处理。", "操作出错！");
            }
        }
    });
}

