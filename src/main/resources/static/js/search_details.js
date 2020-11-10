//项目需求
var page = 1;
var pagesize = 20;
var name;





var indexNumber = 1;

var dataFrom=sessionStorage.getItem("dataFrom");
var school=sessionStorage.getItem("school");
var type=sessionStorage.getItem("type");
var begin_time=sessionStorage.getItem("begin_time");
var end_time=sessionStorage.getItem("end_time");
var iframe_url=sessionStorage.getItem("iframe_url");

//页面渲染
window.onload = rendPage();

function rendPage() {
    showSouSuoJieGuo(page, pagesize);


}


//展示企业需求
function showSouSuoJieGuo(page, pagesize) {

    $.ajax({
        type: 'post',
        // url: "/api/filtrategetRequirement",
        url: "/api/filtrateinfo",
        timeout: 15000,

        dataType: "json",
        data: {
            end_time:end_time,
            begin_time:begin_time,
            dataFrom:dataFrom,
            type:type,
            school:school,
            page: page,
            pagesize: pagesize,
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                var ul = document.body.querySelector('#qiyexuqiu');
                ul.innerHTML = "<li></li>";
                $.each(data['value'], function (index,item) {
                    var li = document.createElement('li');
                    li.name = item["name"];
                    results_name = item["results_name"];


                    var id = "'" + item["Identification_number"] + item["id"] + item["professor_number"] +item["serial_number"] +item["shebei_number"] +item["platform_number"]+item["project_number"]+"'";
                    id=id.split("undefined").join("");
                    id=id.split("NaN").join("");


                    var str=item["results_name"]+item["name"]+item["shebei_name"]+item["project_name"];
                    str=str.split("undefined").join("");
                    str=str.split("NaN").join("");


                    li.innerHTML = '<a onclick="showdetails(' + id + ')"><h2 class="one_hidden fs-14 fl" style="width: 70%; margin-top: 10px; margin-left: 20px; background-color: rgba(255, 255, 255, 0)">' + str + '</h2>'
                    '</a>';
                    ul.insertBefore(li, ul.lastChild);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                --page;
                alert("已经是最后一页了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


//下一页
function pageDown() {
    ++page;
    showSouSuoJieGuo(page, pagesize);
}

//上一页
function pageUp() {
    if(page===1){
        alert("当前是第一页");
    }
    else{
        --page;
        showSouSuoJieGuo(page, pagesize);
    }

}

//详情跳转
function showdetails(id) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", id);
    // alert(iframe_url + sessionStorage.getItem("INF-identity"));
    window.location.href = iframe_url + sessionStorage.getItem("INF-identity");
}