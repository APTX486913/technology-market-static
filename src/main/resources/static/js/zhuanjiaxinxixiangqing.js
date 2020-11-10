var professor_number;
var name;
var identity=sessionStorage.getItem("INF-identity");
var gender;
var born_date;
var industry_1;
var industry_2;
var education_background;
var zhi_cheng;
var duty;
var level;
var title;
var organization;
var id_number;
var commodation_address;
var e_maile;
var phone_number;
var intro;
var photograph;
var jing_shou_ren;
var register_date;
var sign;
var check_result_xiao;
var check_result_ting;
var remarks;
var organization_number;
var auditor_xiao;
var auditor_ting;
var tianbao_yuan;
var tianbao_xiao;

window.onload = rendPage();

function rendPage() {
    title(identity);
    main(identity);
    footer(identity);
}


function title(identity) {
    var ul = document.body.querySelector('#title');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/zhuanjiaxiangxi",
        timeout: 15000,
        dataType: "json",
        data: {
            identity:sessionStorage.getItem("INF-identity"),
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
                    professor_number = item["professor_number"];


                    var li = document.createElement('li');

                    li.innerHTML = '<a><h2 class="fs-18">' + name + '</h2>' +
                        '<h3 class="fs-14">' + professor_number + '</h3></a>';


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



function main(identity) {
    var div = document.body.querySelector('#main');
    div.innerHTML = "<table></table>";

    $.ajax({
        type: 'post',
        url: "/api/zhuanjiaxiangxi",
        timeout: 15000,
        dataType: "json",
        data: {
            identity:sessionStorage.getItem("INF-identity"),
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
                    gender = item["gender"];
                    born_date=item["born_date"];
                    industry_1 = item["industry_1"];
                    industry_2=item["industry_2"];
                    education_background=item["education_background"];
                    zhi_cheng=item["zhi_cheng"];
                    duty=item["duty"];
                    title=item["title"];
                    level=item["level"];
                    organization=item["organization"];
                    photograph=["photograph"];
                    id_number=item["id_number"];
                    commodation_address=item["commodation_address"];
                    e_maile=item["e_maile"];
                    phone_number=item["phone_number"];
                    intro=item["intro"];
                    jing_shou_ren=item["jing_shou_ren"];
                    register_date=item["register_date"];
                    sign=item["sign"];
                    check_result_xiao=item["check_result_xiao"];
                    check_result_ting=item["check_result_ting"];
                    organization_number=item["organization_number"];
                    auditor_xiao=item["auditor_xiao"];
                    auditor_ting=item["auditor_ting"];
                    tianbao_yuan=item["tianbao_yuan"];
                    tianbao_xiao=item["tianbao_xiao"];



                    var table = document.createElement('table');
                    table.className="cinfo1";

                    table.innerHTML ='<tr><td rowspan="6" style="width: 30%"><img src=photograph width="300" height="300"></td>'+'<td style="width: 30%">性别：'+gender+'</td>'+'<td style="width: 30%">出生日期：'+ born_date+'</td></tr>'+
                        '<tr><td style="width: 30%">行业1：'+industry_1+'</td>'+'<td style="width: 30%">行业2：'+industry_2  +'</td></tr>'+
                        '<tr><td style="width: 30%">专家学历：'+education_background +'</td>'+'<td style="width: 30%">专家职称：'+ zhi_cheng +'</td></tr>'+
                        '<tr><td style="width: 30%">专家职务：'+duty+'</td>'+'<td style="width: 30%">级别：'+level  +'</td></tr>'+
                        '<tr><td style="width: 30%">称号：'+title+'</td>'+'<td style="width: 30%">单位：'+organization+'</td></tr>'+
                        '<tr><td style="width: 30%">身份证号：'+id_number +'</td>'+'<td style="width: 30%">通信地址：'+commodation_address +'</td></tr>'+
                        '<tr><td style="width: 30%">电子邮件：'+e_maile +'</td>'+'<td style="width: 30%">常用电话：'+phone_number  +'</td></tr>'+
                        '<tr><td style="width: 30%">经手人：'+jing_shou_ren +'</td>'+'<td style="width: 30%">登记日期：'+register_date +'</td></tr>'+
                        '<tr><td style="width: 30%">审批标志：'+sign  +'</td>'+ '<td style="width: 30%">校审核结果：'+check_result_xiao +'</td></tr>'+
                        '<tr><td style="width: 30%">厅审核结果：'+check_result_ting  +'</td>'+ '<td style="width: 30%">组织编号：'+organization_number +'</td></tr>'+
                        '<tr><td style="width: 30%">校审核人：'+auditor_xiao  +'</td>'+ '<td style="width: 30%">厅审核人：'+auditor_ting +'</td></tr>'+
                        '<tr><td style="width: 30%">填报单位_院：'+tianbao_yuan  +'</td>'+ '<td style="width: 30%">填报单位_校：'+tianbao_xiao+'</td></tr>';

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



function footer(identity) {
    var ul = document.body.querySelector('#footer');
    ul.innerHTML = "<li></li>";

    $.ajax({
        type: 'post',
        url: "/api/zhuanjiaxiangxi",
        timeout: 15000,
        dataType: "json",
        data: {
            identity:sessionStorage.getItem("INF-identity"),
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
                    remarks  = item["remarks"];
                    intro=item["intro"];


                    var li = document.createElement('li');
                    li.className="fs-14";

                    li.innerHTML = '<a style="margin-left: 2px">专家简介:' + intro  + '</a><br>'+'<a style="margin-left: 2px;">备注：'+remarks+'</a>';


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
