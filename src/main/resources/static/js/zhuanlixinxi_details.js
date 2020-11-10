var serial_number;//专利编号
var serial_name;
var identity = sessionStorage.getItem("INF-identity");
var serial_type;
var patent_person;
var number;
var serial_number2;
var credential_number;
var apply_date;
var remark;
var name;//专利名称
var type;
var apply_number;
var apply_data;
var contact_person;
var contact_number;
var communication_address;
var postcode;
var jing_shou_ren;
var register_data;
var sign;
var xiao_result;
var ting_result;
var organization_id;
var xiao_auditor;
var ting_audior;
var tianbao_yuan;
var tianbao_xiao;
var e_mail;
var register_date;






//页面渲染
window.onload = rendPage();

function rendPage() {
    title(identity);
    main(identity);
    footer(identity);
}

//专利名称，id
function title(identity) {
    var ul = document.body.querySelector('#title');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/zhuanlixiangxi",
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
                    serial_name = item["name"];
                    number = item["number"];


                    var li = document.createElement('li');

                    li.innerHTML = '<a><h2 class="fs-18">' + serial_name + '</h2>' +
                        '<h3 class="fs-14">' + number + '</h3></a>';


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


//项目信息具体条目
function main(identity) {
    var div = document.body.querySelector('#main');
    div.innerHTML = "<table></table>";

    $.ajax({
        type: 'post',
        url: "/api/zhuanlixiangxi",
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
                    serial_type = item["serial_type"];
                    patent_person = item["patent_person"];
                    number = item["number"];
                    serial_number2 = "'" + item["serial_number"] + "'";
                    credential_number = item["credential_number"];
                    apply_date = item["apply_date"];
                    remark = item["remark"];
                    apply_number=item["apply_number"];
                    contact_person=item["contact_person"];
                    contact_number=item["contact_number"];
                    communication_address=item["communication_address"];
                    e_mail=item["e_mail"];
                    postcode=item["postcode"];
                    jing_shou_ren=item["jing_shou_ren"];
                    register_date=item["register_date"];
                    sign=item["sign"];
                    xiao_result=item["xiao_result"];
                    ting_result=item["ting_result"];
                    organization_id=item["organization_id"];
                    xiao_auditor=item["xiao_auditor"];
                    ting_auditor=item["ting_auditor"];
                    tianbao_yuan=item["tianbao_yuan"];
                    tianbao_xiao=item["tianbao_xiao"];

                    var table = document.createElement('table');
                    table.className = "cinfo";

                    table.innerHTML = '<td>专利编号：' + serial_number2 + '</td></tr>' +
                        '<tr><td>专利名称：' + name + '</td>' + '<td>专利类型：' + type + '</td></tr>' +
                        '<tr><td>专利号：' + number + '</td>' + '<td>申请号' + apply_number + '</td></tr>' +
                        '<tr><td>申请日期：' + apply_data + '</td>' + '<td>专利权人：' + patent_person + '</td></tr>' +
                        '<tr><td>联系人：' + contact_person + '</td>' + '<td>证书号：' + credential_number + '</td></tr>' +
                        '<tr><td>联系电话：' + number + '</td>' + '<td>电子邮件：' +e_mail+ '</td></tr>' +
                        '<tr><td>通信地址：' + communication_address + '</td>' + '<td>邮编：' + postcode + '</td></tr>' +
                        '<tr><td>经手人：' + jing_shou_ren + '</td>' + '<td>登记日期：' + register_date + '</td></tr>' +
                        '<tr><td>组织编号：' + number + '</td>' + '<td>审批标志：' + sign + '</td></tr>' +
                        '<tr><td>厅审批结果：' + ting_result + '</td>' + '<td>校审批结果：' + xiao_result + '</td></tr>' +
                        '<tr><td>厅核审人：' + ting_audior + '</td>' + '<td>校核审人：' + xiao_auditor + '</td></tr>' +
                        '<td>填报单位_校：' + tianbao_xiao  + ' </td>' +'<td>填报单位_院：' + tianbao_yuan+ ' </td></tr>'+
                    '<tr><td>备注：' + remark + '</td></tr>';


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


//知识产权及获奖情况
function footer(identity) {
    var ul = document.body.querySelector('#footer');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/zhuanlixiangxi",
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
                    serial_name = item["serial_name"];
                    number = item["number"];


                    var li = document.createElement('li');
                    li.className = "fs-14";

                    li.innerHTML = '<a>知识产权及获奖情况:' + +'</a>';


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






