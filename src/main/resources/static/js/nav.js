
var iframe = document.getElementById('external-frame');

var head = document.getElementById('head');

var nowTab = 0;

window.onload = renderPage();

function renderPage()
{
    document.body.style.backgroundImage = "url(/img/bgr.jpg)";
    document.body.style.backgroundSize = "100% 100%";
    getVisits();
    tabTrans(head)
    iframe.onload = function (ev) {
        var number = 0;
        var a = window.setInterval(function () {
            number++;
            if (number == 300){
                clearInterval(a);
            }
            setIframeHeight();
        },10);
    }
    if(sessionStorage.getItem("visits")==null){
        sessionStorage.setItem("visits","1");
        //调用访问量添加接口
        setVisits();
    }
}

function tabTrans(head) {
    var lis = $(head).children(); // 全部子节点
    console.log(lis);
    for (var i = 0;i<lis.length;i++){
        lis[i].position = i;
        $(lis[i]).on("click",function () {
            lis[this.position].classList.add('on');
            lis[nowTab].classList.remove('on');
            console.log(nowTab+"");
            nowTab = this.position;
            if (nowTab == 0){
                $(".bay-window").show(10);
            }else{
                $(".bay-window").hide(10);
            }
        });
    }
}

//设置页面高度
function setIframeHeight() {
    if (iframe) {
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
        if (iframeWin.document.body) {
            iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
        }
    }
}

function getVisits()
{
    //调用获取访问量获取接口
    $.ajax({
        type: 'post',
        url: "/api/getVisits",
        timeout: 15000,
        dataType: "json",
        data: {

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {
                document.getElementById("visit").innerText="访问量："+data["value"];
            }

        }
    });
}

function setVisits(){
    //调用更新访问量获取接口
    $.ajax({
        type: 'post',
        url: "/api/updateVisits",
        timeout: 15000,
        dataType: "json",
        data: {

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {

            }else{
                console.log("访问量更新失败")
            }

        }
    });
}

// $("#nav_cgxx").on("click", function () {
//     var lis = $(head).children();
//     lis[this.position].classList.add('on');
//     lis[nowTab].classList.remove('on');
//     console.log(nowTab+"");
//     nowTab = this.position;
//     if ($("#nav_cgxx_sub_menu").is(":hidden")) {
//         $("ul .childMenu").hide();
//         $("#nav_cgxx_sub_menu").show();
//     } else {
//         $("ul .childMenu").hide();
//     }
// });

$("#nav_nycg").on("click",function () {
    iframe.src = "/nycg";
});


// $("#nav_cxpt").on("click", function () {
//     if ($("#nav_cxpt_sub_menu").is(":hidden")) {
//         $("ul .childMenu").hide();
//         $("#nav_cxpt_sub_menu").show();
//     } else {
//         $("ul .childMenu").hide();
//     }
// });

// $("#nav_rwsk").on("click", function () {
//     if ($("#nav_rwsk_sub_menu").is(":hidden")) {
//         $("ul .childMenu").hide();
//         $("#nav_rwsk_sub_menu").show();
//     } else {
//         $("ul .childMenu").hide();
//     }
// });

// $(function () {
//     $('.mainlevel').mouseover(function () {
//         $(this).children('ul').show();
//     });
//     $('.mainlevel').mouseover(function () {
//         $(this).children('ul').hide();
//     });
// });

$("#titleImg").on("click", function () {
    window.location.href = "/";
});

$("#banner1").on("click", function () {
    window.location.href = "/";
});

$("#banner2").on("click", function () {
    iframe.src = "/rwcg";
});

//导航栏按钮点击事件监听
$("#nav_sy").on("click", function () {
    iframe.src = "/indexSmall";
});

$("#nav_lgcg").on("click", function () {
    iframe.src = "/cgxx";
});

$("#nav_rwcg").on("click", function () {
    iframe.src = "/rwcg";
});

$("#nav_xmxx").on("click", function () {
    iframe.src = "/xmxx";
});

$("#nav_zjxx").on("click", function () {
    iframe.src = "/zjxx";
});

$("#nav_zlxx").on("click", function () {
    iframe.src = "/zlxx";
});

$("#nav_sysb").on("click", function () {
    iframe.src = "/sysb";
});

$("#nav_lgjd").on("click", function () {
    iframe.src = "/cxpt";
});

$("#nav_rwjd").on("click", function () {
    iframe.src = "/rwjd";
});

// $("#nav_qyxq").on("click", function () {
//    // window.location.href = "/qyxq";
//     if ($("#nav_qyxq_sub_menu").is(":hidden")) {
//         $("ul .childMenu").hide();
//         $("#nav_qyxq_sub_menu").show();
//     } else {
//         $("ul .childMenu").hide();
//     }
// });

$("#nav_jsxq").on("click",function () {
    iframe.src = "/jsxq";
});

$("#nav_rcxq").on("click",function () {
    iframe.src = "/rcxq";
});

$("#nav_jrfwxq").on("click",function () {
    iframe.src = "/jrfwxq";
});

$("#nav_rwcg1").on("click", function () {
    iframe.src = "/rwcg";
});

$("#nav_rwjd1").on("click", function () {
    iframe.src = "/rwjd";
});

$("#nav_gxfc").on("click", function () {
    iframe.src = "/gxfc";
});

$("#nav_jnhb").on("click",function () {
    iframe.src = "/jnhb";
});

$("#nav_yyjk").on("click",function () {
    iframe.src = "/yyjk";
});

$("#nav_swzz").on("click",function () {
    iframe.src = "/swzz";
});

$("#nav_dzxx").on("click",function () {
    iframe.src = "/dzxx";
});

$("#nav_xnyqc").on("click",function () {
    iframe.src = "/xnyqc";
});

$("#nav_xcl").on("click", function () {
    iframe.src = "/xcl";
});

$("#nav_xnykf").on("click", function () {
    iframe.src = "/xnykf";
});

$("#nav_xjzb").on("click", function () {
    iframe.src = "/xjzb";
});
$("#nav_sdt").on("click", function () {
    iframe.src = "/sc_dt";
});


// $("#nav_cgxx").on("click", function () {
//
// });
//
// $("#nav_cxpt").on("click", function () {
// });
//
// $("#nav_rwsk").on("click", function () {
// });

