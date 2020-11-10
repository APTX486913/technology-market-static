var page = 1;
var pagesize = 5;

var name;
var type;
var results_type;
var id;
var professor_number;
var professor_number2;


//分页判断
var totalPages;
var moduleName = 'zhuanjiaxinxi';
var ord_id = sessionStorage.getItem('INF-identity');
var pageSize = 20;
var a = sessionStorage.getItem('aa');


var indexNumber = 1;

var zlpage = 1;
var zlpagesize = 20;
var results_name;
var identity = sessionStorage.getItem('INF-identity');

var firstGaoxiaoId = 2;


window.onload = rendPage();

function rendPage() {
    getData(page, pagesize);
    getDataSsdw(page, pagesize);
    getDataZc();
    getDataGender();
    getDataDhy();

}

// window.onload=getDataSsdw(page,pagesize);


function getDataSsdw(page, pagesize) {
    var select = document.getElementById('AreaId');
    // select.innerHTML="";
    $.ajax({
        type: 'post',
        url: "/api/suoshudanwei",
        timeout: 15000,
        dataType: "json",
        data: {
            getall: 1,
            page: page,
            pagesize: pagesize,
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                indexNumber = 1;


                $.each(data['value'], function (index, item) {

                    var option = document.createElement('option');
                    option.name = data["value"]["name"];

                    identity = item["identity"];
                    name = item["name"];

                    option.className = "selectdiv fl";
                    option.value = identity;
                    option.innerHTML = '<a>所属单位：' + name + '</a>';
                    select.insertBefore(option, select.lastChild);

                    indexNumber++;
                });

            } else if (data['status'] === 100) {
                toast("无更多内容了");
            } else if (data['status'] === 100) {
                toast("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//成果类型改成职业
function getDataZc() {
    var select = document.getElementById('AreaId1');

    $.ajax({
        type: 'post',
        url: "/api/zhicheng",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];

                    type = item["type"];
                    id = item["id"];

                    option.className = "selectdiv fl";
                    option.value = id;
                    option.innerHTML = '<a> 职业：' + type + '</a>';
                    select.insertBefore(option, select.lastChild);

                    indexNumber++;
                });
            } else if (data['status'] === 100) {
                toast("无更多内容了");
            } else if (data['status'] === 100) {
                toast("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//性别
function getDataGender() {
    var select = document.getElementById('AreaId4');

    $.ajax({
        type: 'post',
        url: "/api/sexhuoqu",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.gender = data["value"]["gender"];

                    gender = item["gender"];
                    id = item["id"];

                    option.className = "selectdiv fl";
                    option.value = id;
                    option.innerHTML = '<a> 性别：' + gender + '</a>';
                    select.insertBefore(option, select.lastChild);

                    indexNumber++;
                });
            } else if (data['status'] === 100) {
                toast("无更多内容了");
            } else if (data['status'] === 100) {
                toast("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//监听大行业选择器变动
$("#AreaId2").change(function () {
    var a = $("#AreaId2").val();
    if (a == "00") {
        $("#AreaId3").html("<option>小行业： 不限</option>");
    }
    if (a == "01") {
        getDataNlmy();//改过了！！！农林牧渔
    }
    if (a == "02") {
        getDataCk();//采矿
    }
    if (a == "03") {
        getDataZz();//制造业
    }
    if (a == "04") {
        getDataDlrqs();//电力燃气水
    }
    if (a == "05") {
        getDataJz();//建筑
    }
    if (a == "06") {
        getDataJtysyz();//交通运输仓储邮政
    }
    if (a == "07") {
        getDataXxjsjrj();//信息计算机软件
    }
    if (a == "08") {
        getDataPfls();//批发零售
    }
    if (a == "09") {
        getDataZscy();//住宿餐饮
    }
    if (a == "10") {
        getDataJry();//金融业
    }
    if (a == "11") {
        getDataFdc();//房地产
    }
    if (a == "12") {
        getDataZlsw();//租赁商务
    }
    if (a == "13") {
        getDataKxyjjs();//科学研究技术
    }
    if (a == "14") {
        getDataSlhjggss();//水利环境公共设施
    }
    if (a == "15") {
        getDataJmfu();//居民服务其他
    }
    if (a == "16") {
        getDataJy();//教育
    }
    if (a == "17") {
        getDataWsshbzshfl();//卫生社会保障社会福利
    }
    if (a == "18") {
        getDataWhtyyl();//文化体育娱乐
    }
    if (a == "19") {
        getDataGggl();//公共管理和社会组织
    }
    if (a == "20") {
        getDataGjzz();//国际组织
    }
});


//获取大行业
function getDataDhy() {
    var select = document.getElementById('AreaId2');

    $.ajax({
        type: 'post',
        url: "/api/dahangyetype",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];

                    type = item["type"];
                    id = item["id"];

                    option.className = "selectdiv fl";
                    option.value = id;
                    option.innerHTML = '<a>大行业：' + type + '</a>';
                    select.insertBefore(option, select.lastChild);

                    indexNumber++;
                });
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（农林牧渔）获取数据
function getDataNlmy() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=01",//所有接口都不知道！！先别改！！zhuanjiaxinxi要改每个小行业的！！！
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（采矿）获取数据
function getDataCk() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=02",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（制造业）获取数据
function getDataZz() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=03",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（电力燃气水）获取数据
function getDataDlrqs() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=04",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（建筑）获取数据
function getDataJz() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=05",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（交通运输仓储邮政）获取数据
function getDataJtysyz() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=06",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（信息计算机软件）获取数据
function getDataXxjsjrj() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=07",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（批发零售）获取数据
function getDataPfls() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=08",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（;//住宿餐饮）获取数据
function getDataZscy() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=09",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（;//金融业）获取数据
function getDataJry() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=10",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（;//房地产）获取数据
function getDataFdc() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=11",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（;//租赁商务）获取数据
function getDataZlsw() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=12",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（;//科学研究技术）获取数据
function getDataKxyjjs() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=13",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（;//水利环境公共设施）获取数据
function getDataSlhjggss() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=14",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（;//居民服务其他）获取数据
function getDataJmfu() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=15",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（教育）获取数据
function getDataJy() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=16",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（卫生社会保障社会福利）获取数据
function getDataWsshbzshfl() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=17",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（文化体育娱乐）获取数据
function getDataWhtyyl() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=18",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（公共管理和社会组织）获取数据
function getDataGggl() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=19",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//大行业（国际组织）获取数据
function getDataGjzz() {
    var select = document.getElementById('AreaId3');

    $.ajax({
        type: 'post',
        url: "/api/xiaohangyetype?industry_big=20",
        timeout: 15000,
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您的网络状态不佳，请检查您的网络连接", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] == 100) {
                var tempHTML = "";
                $.each(data['value'], function (index, item) {
                    var option = document.createElement('option');
                    option.type = data["value"]["type"];
                    // select.innerHTML="";

                    type = item["type"];
                    id = item["id"];

                    if (id === id) {
                        tempHTML += '<option value="' + id + '"selected>小行业：' + type + '</option>'
                    } else {
                        tempHTML += '<option value="' + id + '">小行业：' + type + '</option>'
                    }
                });
                document.getElementById("AreaId3").innerHTML = tempHTML;
            } else if (data['status'] === 100) {
                alert("无更多内容了");
            } else if (data['status'] === 100) {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

/**
 * 拉取学校数据     下面不准改了！！！！！！！！！
 */
function getData(page, pagesize) {

    var dl = document.body.querySelector('#gaoxiao_mingchen');
    dl.innerHTML = "<dd></dd>";

    $.ajax({
        type: 'post',
        url: "/api/suoshudanwei",
        timeout: 15000,
        dataType: "json",
        data: {
            page: page,
            pagesize: pagesize,
            getall: 0

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {

                indexNumber = 1;

                $.each(data['value'], function (index, item) {
                    var dd = document.createElement('dd');
                    dd.name = item['name'];
                    dd.identity = item['identity'];

                    identity = item['identity'];
                    name = item['name'];

                    //记录第一所高校ID，默认展示其成果信息
                    if (index === 0) {
                        firstGaoxiaoId = item['identity'];
                        sessionStorage.setItem("INF-identity", firstGaoxiaoId);
                    }

                    dd.className = 'fs-14';
                    //dd.innerHTML = '<a href=""> '+ item['name'] + '</a>';
                    dd.innerHTML = '<a onclick="showpage(' + item['identity'] + ')"> ' + item['name'] + '</a>';

                    dl.insertBefore(dd, dl.lastChild);

                    indexNumber++;
                });


                var dt = document.createElement('dt');
                dt.className = "fs-16";
                dt.innerHTML = '专家信息';
                dl.insertBefore(dt, dl.firstChild);

                var tempHtml = document.getElementById("gaoxiao_mingchen").outerHTML;
                document.getElementById("gaoxiao_mingchen").innerHTML = tempHtml +
                    '<dd class="fs-14" onclick="pageUp()"><a style="margin-top: 50px;">上一页</a></dd>' +
                    '<dd class="fs-14" onclick="pageDown()"><a>下一页</a></dd>';
                showzhuanjiaxinxi(1, zlpagesize, firstGaoxiaoId);

            } else if (data['status'] === 200) {
                mui.toast("无更多内容了");
            } else {
                mui.toast("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}

//点击上一页翻页
function pageUp() {
    --page;
    getData(page, pagesize);
}

//点击下一页翻页
function pageDown() {
    ++page;
    getData(page, pagesize);
}

// 点击调用的获取identity 函数和加载页面函数
function showpage(identity) {
    //初始化成果页码
    zlpage = 1;
    showzhuanjia(identity);
    showzhuanjiaxinxi(zlpage, zlpagesize, identity);
    gettotalPages(moduleName, ord_id, pageSize);//获取成果页码
}

//存储获取的identity
function showzhuanjia(identity) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", identity);
}

//专家信息条目加载
function showzhuanjiaxinxi(tpage, tpagesize, gxidentity) {
    var ul = document.body.querySelector('#zhuanjia_name');
    ul.innerHTML = "<li></li>";
    // alert("lllll");
    $.ajax({
        type: 'post',
        url: "/api/zhuanjiaxinxi",
        timeout: 15000,
        dataType: "json",
        data: {
            page: tpage,
            pagesize: tpagesize,
            identity: gxidentity
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            if (data['status'] === 100) {

                indexNumber = 1;

                $.each(data['value'], function (index, item) {

                    identity = sessionStorage.getItem('INF-identity');
                    //identity = item["identity"];
                    name = item["name"];
                    organization = item["organization"];
                    tianbao_yuan = item["tianbao_yuan"];
                    professor_number2 = "'" + item["professor_number"] + "'";

                    var li = document.createElement('li');

                    li.innerHTML = '<a onclick="showdetails(' + professor_number2 + ')"><h2 class="one_hidden fs-14 fl" style="width: 70%; background-color: rgba(255, 255, 255, 0)">' + name + '</h2>' +
                        '<p class="one_hidden fr fs-14" style="width: 20%; background-color: rgba(255, 255, 255, 0)">' + organization + '</p></a>';


                    ul.insertBefore(li, ul.lastChild);

                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("此高校无更多专家信息了");
            } else {
                alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });
}


function gettotalPages(moduleName, org_id, pageSize) {
    $.ajax({
        type: 'post',
        url: "/api/getPagingInformation",
        timeout: 15000,
        dataType: "json",
        data: {
            moduleName: 'zhuanjiaxinxi',
            org_id: sessionStorage.getItem('INF-identity'),
            pageSize: pageSize,

        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("连接服务器失败，您当前的网络状态不佳，请检查您的网络连接！", "加载数据失败！");
        },
        success: function (data) {
            // alert(data['status']);
            if (data['status'] === 100) {
                indexNumber = 1;
                $.each(data['value'], function (index, item) {
                    totalPages = data["value"]["totalPages"];
                    sessionStorage.setItem('aa', data["value"]["totalPages"]);
                    indexNumber++;
                });
            } else if (data['status'] === 200) {
                alert("无更多内容了");
            } else {
                //alert("获取数据出错！\n数据获取出现错误，请联系系统维护人员处理。");
            }
        }
    });

}


////详情获取identification_number函数
function showdetails(ident) {
    sessionStorage.removeItem('INF-identity');
    sessionStorage.setItem("INF-identity", ident);
    window.location.href = "/zjxxxq?identity=" + sessionStorage.getItem("INF-identity");
}

function zlpageDown() {

    a = sessionStorage.getItem('aa');
    if (a > zlpage) {
        ++zlpage;
        showzhuanjiaxinxi(zlpage, zlpagesize, identity)
    } else {
        alert("这个是最后一页");
    }
}

function zlpageUp() {
    if (zlpage === 1) {
        alert("当前是第一页")
    } else {
        --zlpage;
        showzhuanjiaxinxi(zlpage, zlpagesize, identity)
    }


}
