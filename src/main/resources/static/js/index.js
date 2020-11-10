var page = 1;
var pagesize = 7;
var identity = sessionStorage.getItem('INF-identity');

//成果信息
var results_name;

//企业需求
var name;
//下载专区
var download_title;

//通知公告；下载专区
var release_time;


var ident = 2;


//下载专区
var xzpage=1;
var xzpagesize=6;
var file_id=sessionStorage.getItem('INF-identity');

//项目信息
var xmdpage = 1;
var xmdpagesize = 6;
var xmdident = 5;
//企业需求
var qypage = 1;
var qypagesize = 6;

var id;//企业需求；下载专区；通知公告
var id2;
var id3;

// var TotalChengGuo=999;
var TotalXiangMu=999;
var TotalTongZhi=999;
var TotalQiYe=999;


//页面渲染
window.onload = rendPage();

function rendPage() {
    chengguoxinxi(page, pagesize, ident);//首页成果信息
    xiangmuxinxi(xmdpage, xmdpagesize, xmdident);//首页项目信息
    qiyexuqiu(qypage, qypagesize);//首页企业需求
    xiazaizhuanqu(xzpage,xzpagesize);//首页下载专区
    tongzhigonggao(xzpage,xzpagesize);//首页通知公告
}

//成果信息条目加载
function chengguoxinxi(page, pagesize, identity) {
    var ul = document.body.querySelector('#shouye_chengguo');
    ul.innerHTML = "<div></div>";

    // var jiaChengGuo=new Array(7);

    $.ajax({
        type: 'post',
        url: "/api/chengguoxinxi",
        timeout: 15000,
        dataType: "json",
        data: {
            page: page,
            pagesize: pagesize,
            identity: identity
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    identity = sessionStorage.getItem('INF-identity');
                    results_name = item["results_name"];
                    subordinate_units = item["subordinate_units"];
                    ident = "'" + item["identification_number"] + "'";


                    var div = document.createElement('div');
                    // if (indexNumber<8)
                    // {
                    //     jiaChengGuo[indexNumber-1]=
                    //         '<a onclick="showdetail_chengguo(' + ident + ')"><h3 class="fs-12 fl one_hidden" style="width:60%;overflow: hidden">' + results_name + '</h3>' +
                    //         '<p class="one_hidden fr fs-14" style="width: 35%;">' + subordinate_units + '</p>' +
                    //         '</a>';
                    // }



                    div.innerHTML =
                        // results_name;
                        '<a onclick="showdetail_chengguo(' + ident + ')"><h3 class="fs-12 fl one_hidden" style="width:60%;overflow: hidden">' + results_name + '</h3>' +
                        '<p class="one_hidden fr fs-14" style="width: 35%;">' + subordinate_units + '</p>' +
                        '</a>';

                    ul.insertBefore(div, ul.lastChild);
                    indexNumber++;

                });
                // TotalChengGuo=indexNumber-1;//储存条目数
                // for(var i=0;i<=6;i++)//添加虚假的六个重复节点
                // {
                //     var div = document.createElement('div');
                //     div.innerHTML =jiaChengGuo[i];
                //     ul.insertBefore(div, ul.lastChild);
                // }
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


//成果信息详情跳转
function showdetail_chengguo(number) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", number);
    window.location.href = "/cgxxxq?identity=" + sessionStorage.getItem("INF-identity");
}
////项目信息条目加载
function xiangmuxinxi(page, pagesize, identity) {
    var ul = document.body.querySelector('#shouye_xiangmu');
    ul.innerHTML = "<div></div>";

    // var jiaXiangMu=new Array(6);
    $.ajax({
        type: 'post',
        url: "/api/xiangmuxinxi",
        timeout: 15000,
        dataType: "json",
        data: {
            page: page,
            pagesize: pagesize,
            identity: identity
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
                    identity = item["identity"];
                    project_name = item["project_name"];
                    undertaking_unit = item["undertaking_unit"];
                    project_number2 = "'" + item["project_number"] + "'";

                    var div = document.createElement('div');
                    // if (indexNumber<7)
                    // {
                    //     jiaXiangMu[indexNumber-1]=
                    //         '<a onclick="showdetail_xiangmu(' + project_number2 + ')"><h3 class="one_hidden fs-12 fl" style="width: 70%;">' + project_name + '</h3>'
                    //         + '<p class="one_hidden fr fs-14" style="width: 20%;">' + undertaking_unit + '</p>' +
                    //         '</a>';
                    // }



                    div.innerHTML =
                        // results_name;
                        '<a onclick="showdetail_xiangmu(' + project_number2 + ')"><h3 class="one_hidden fs-12 fl" style="width: 70%;">' + project_name + '</h3>'
                    + '<p class="one_hidden fr fs-14" style="width: 20%;">' + undertaking_unit + '</p>' +
                    '</a>';

                    ul.insertBefore(div, ul.lastChild);

                    // var li = document.createElement('li');
                    // li.innerHTML = '<a onclick="showdetail_xiangmu(' + project_number2 + ')"><h3 class="one_hidden fs-12 fl" style="width: 70%;">' + project_name + '</h3>'
                    // // + '<p class="one_hidden fr fs-14" style="width: 20%;">' + undertaking_unit + '</p>' +
                    // '</a>';
                    // ul.insertBefore(li, ul.lastChild);
                    indexNumber++;
                });

                // TotalXiangMu=indexNumber-1;//储存条目数
                // for(var i=0;i<=5;i++)//添加虚假的六个重复节点
                // {
                //     var div = document.createElement('div');
                //     div.innerHTML =jiaXiangMu[i];
                //     ul.insertBefore(div, ul.lastChild);
                // }
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//项目信息详情跳转
function showdetail_xiangmu(ident) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", ident);
    window.location.href = "/xmxxxq?identity=" + sessionStorage.getItem("INF-identity");
}
//企业需求
function qiyexuqiu(page, pagesize) {
    var ul = document.body.querySelector('#shouye_qiye');
    ul.innerHTML = "<div></div>";

    var jiaQiYe=new Array(6);
    $.ajax({
        type: 'post',
        url: "/api/comrequire",
        timeout: 15000,
        dataType: "json",
        data: {
            page: page,
            pagesize: pagesize,
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    identity = sessionStorage.getItem('INF-identity');
                    // var li = document.createElement('li');
                    // li.name = item["name"];
                    name = item["name"];
                    id = item["id"];
                    id2 = "'" + item["id"] + "'";

                    var div = document.createElement('div');
                    if (indexNumber<7)
                    {
                        jiaQiYe[indexNumber-1]=
                            '<a onclick="showdetail_qiye(' + id2 + ')"><h3 class="fs-12 fl one_hidden">' + name + '</h3>'
                        + '<p class="one_hidden fr fs-14" style="width: 20%;"></p>' +
                        '</a>';
                    }



                    div.innerHTML =
                        // results_name;
                        '<a onclick="showdetail_qiye(' + id2 + ')"><h3 class="fs-12 fl one_hidden">' + name + '</h3>'
                    + '<p class="one_hidden fr fs-14" style="width: 20%;"></p>' +
                    '</a>';

                    ul.insertBefore(div, ul.lastChild);

                    // li.innerHTML = '<a onclick="showdetail_qiye(' + id2 + ')"><h3 class="fs-12 fl one_hidden">' + name + '</h3>'
                    // + '<p class="one_hidden fr fs-14" style="width: 20%;">' + subordinate_units + '</p>' +
                    // '</a>';
                    // ul.insertBefore(li, ul.lastChild);

                    indexNumber++;
                });
                TotalQiYe=indexNumber-1;//储存条目数
                for(var i=0;i<=5;i++)//添加虚假的六个重复节点
                {
                    var div = document.createElement('div');
                    div.innerHTML =jiaQiYe[i];
                    ul.insertBefore(div, ul.lastChild);
                }
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}
//企业需求详情跳转
function showdetail_qiye(ident1) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", ident1);
    window.location.href = "/qyxqxq?identity=" + sessionStorage.getItem("INF-identity");
}

//下载专区
function xiazaizhuanqu(page,pagesize) {
    var ul = document.body.querySelector('#shouye_xiazai');
    ul.innerHTML = "<li></li>";
    $.ajax({
        type: 'post',
        url: "/api/download",
        timeout: 15000,
        dataType: "json",
        data: {
            page: page,
            pagesize: pagesize,
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            // alert(status);
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    file_id = sessionStorage.getItem("INF-identity");
                    // var li = document.createElement('li');
                    // li.download_title = item["download_title"];
                    // li.release_time = item["release_time"];


                    download_title = item["download_title"];
                    release_time = item["release_time"];
                    id3 = "'" + item["id"] + "'";
                    // id=item["id"];
                    var li = document.createElement('li');
                    li.innerHTML = '<a onclick="showdetail_xiazai('+id3+')"><h2 class="fs-14 fl one_hidden" style="width: 60%;">' + download_title + '</h2>' +
                        '<p class="one_hidden fr fs-10" style="width: 30%;">' + release_time + '</p></a>';
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
//下载专区详情跳转
function showdetail_xiazai(iddddd) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", iddddd);
    window.location.href = "/xzzqxq?file_id=" + sessionStorage.getItem("INF-identity");
}




//通知公告
function tongzhigonggao(page,pagesize) {
    var ul = document.body.querySelector('#shouye_tongzhi');
    ul.innerHTML = "<div></div>";

    // var jiaTongZhi=new Array(6);
    // alert("llll");
    $.ajax({
        type: 'post',
        url: "/api/tongzhiliebiao",
        timeout: 15000,
        dataType: "json",
        data: {
            page: page,
            pagesize: pagesize,
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    notification_id	 = sessionStorage.getItem("INF-identity");
                    // var li = document.createElement('li');
                    // li.headline = item["headline"];
                    // li.release_time = item["release_time"];
                    // identity = item["identity"];
                    headline = item["headline"];
                    release_time = item["release_time"];
                    id2 = "'" + item["id"] + "'";

                    var div = document.createElement('div');
                    // if (indexNumber<7)
                    // {
                    //     jiaTongZhi[indexNumber-1]=
                    //         '<a onclick="showdetail_tongzhi(' + id2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 60%;">' + headline + '</h2>' +
                    //         '<p class="one_hidden fr fs-10" style="width: 30%;">' + release_time + '</p></a>';
                    // }



                    div.innerHTML =
                        // results_name;
                        '<a onclick="showdetail_tongzhi(' + id2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 60%;">' + headline + '</h2>' +
                        '<p class="one_hidden fr fs-10" style="width: 30%;">' + release_time + '</p></a>';

                    ul.insertBefore(div, ul.lastChild);

                    // var li = document.createElement('li');
                    // li.innerHTML = '<a onclick="showdetail_tongzhi(' + id2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 60%;">' + headline + '</h2>' +
                    //     '<p class="one_hidden fr fs-10" style="width: 30%;">' + release_time + '</p></a>';
                    // ul.insertBefore(li, ul.lastChild);
                    indexNumber++;
                });
                // TotalTongZhi=indexNumber-1;//储存条目数
                // for(var i=0;i<=5;i++)//添加虚假的六个重复节点
                // {
                //     var div = document.createElement('div');
                //     div.innerHTML =jiaTongZhi[i];
                //     ul.insertBefore(div, ul.lastChild);
                // }
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//通知公告详情跳转
function showdetail_tongzhi(id4) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", id4);
    window.location.href = "/tzggxq?notification_id	=" + sessionStorage.getItem("INF-identity");
}
function upAndDownRotation(container,mytop) {//滚动播放

    mytop -= 1;
    var time = 100;
    // if (mytop % 45 == 0) {
    //     time = 2000;
    // }
    if(container.id=="shouye_chengguo")
    {
        if (mytop == -TotalChengGuo*45) {
            mytop = 0;
        }
    }
    else if(container.id=="shouye_xiangmu")
    {
        if (mytop == -TotalXiangMu*45) {
            mytop = 0;
        }
    }
    else if(container.id=="shouye_tongzhi")
    {
        if (mytop == -TotalTongZhi*45) {
            mytop = 0;
        }
    }
    else if(container.id=="shouye_qiye")
    {
        if (mytop == -TotalQiYe*45) {
            mytop = 0;
        }
    }
    container.style.marginTop = mytop + "px";
    setTimeout(function ()
    {
        upAndDownRotation(container,mytop);
    }, time);
}
// //成果信息动态轮播
// var mytopChengGuo = 0;
// var rotationContant = document.getElementById("shouye_chengguo");
// //轮播考评
// upAndDownRotation(rotationContant,mytopChengGuo);

// //通知动态轮播
// var mytopTongZhi = 0;
// var tongzhiContant = document.getElementById("shouye_tongzhi");
// //轮播考评
// upAndDownRotation(tongzhiContant,mytopTongZhi);

//企业动态轮播
var mytopQiYe = 0;
var qiyeContant = document.getElementById("shouye_qiye");
//轮播考评
upAndDownRotation(qiyeContant,mytopQiYe);

// //项目动态轮播
// var mytopXiangMu = 0;
// var xiangmuContant = document.getElementById("shouye_xiangmu");
// //轮播考评
// upAndDownRotation(xiangmuContant,mytopXiangMu);