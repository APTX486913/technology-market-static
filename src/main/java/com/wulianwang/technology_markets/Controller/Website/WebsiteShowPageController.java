package com.wulianwang.technology_markets.Controller.Website;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "网站页面请求路径", description = "网站页面请求路径")
@Slf4j
@Controller
public class WebsiteShowPageController {

    private String returnLoginPage() {
        log.info("●访问登录页●");
        return "website-wraper";
    }

    @ApiOperation(
            value = "获取登录页面真实路径",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginContentPage() {
        String logText = "●请求访问登录真实页";

        log.info(logText + "，允许访问。●");
        return "login";

    }

    @RequestMapping(value = "/cgxx", method = RequestMethod.GET)
    public String showCgxxPage() {
        String logText = "●请求访問成果信息页";

        log.info(logText + "，允许访问。●");
        return "chengguoxinxi";

    }

    @RequestMapping(value = "/indexSmall", method = RequestMethod.GET)
    public String showIndexSmallPage() {
        String logText = "●请求访问首页";

        log.info(logText + "，允许访问。●");
        return "index-small";

    }

    @RequestMapping(value = "/cgxxxq", method = RequestMethod.GET)
    public String showCgxxxqPage() {
        String logText = "●请求访問成果信息详情页";

        log.info(logText + "，允许访问。●");
        return "chengguoxinxineiye";

    }

    @RequestMapping(value = "/xmxx", method = RequestMethod.GET)
    public String showXmxxPage() {
        String logText = "●请求访問项目信息页";

        log.info(logText + "，允许访问。●");
        return "xiangmuxinxi";

    }

    @RequestMapping(value = "/xmxxxq", method = RequestMethod.GET)
    public String showXmxxxqPage() {
        String logText = "●请求访問项目信息详情页";

        log.info(logText + "，允许访问。●");
        return "xiangmuxinxineiye";

    }

    @RequestMapping(value = "/zjxx", method = RequestMethod.GET)
    public String showZjxxPage() {
        String logText = "●请求访問专家信息页";

        log.info(logText + "，允许访问。●");
        return "zhuanjiaxinxi";

    }

    @RequestMapping(value = "/zjxxxq", method = RequestMethod.GET)
    public String showZjxxxqPage() {
        String logText = "●请求访問专家信息详情页";

        log.info(logText + "，允许访问。●");
        return "zhuanjiaxinxineiye";

    }

    @RequestMapping(value = "/zlxx", method = RequestMethod.GET)
    public String showZlxxPage() {
        String logText = "●请求访問专利信息页";

        log.info(logText + "，允许访问。●");
        return "zhuanlixinxi";

    }

    @RequestMapping(value = "/zlxxxq", method = RequestMethod.GET)
    public String showZlxxxqPage() {
        String logText = "●请求访問专利信息详情页";

        log.info(logText + "，允许访问。●");
        return "zhuanlixinxineiye";

    }

    @RequestMapping(value = "/sysb", method = RequestMethod.GET)
    public String showSysbPage() {
        String logText = "●请求访問试验设备页";

        log.info(logText + "，允许访问。●");
        return "shiyanshebei";

    }

    @RequestMapping(value = "/sysbxq", method = RequestMethod.GET)
    public String showSysbxqPage() {
        String logText = "●请求访問试验设备详情页";

        log.info(logText + "，允许访问。●");
        return "shiyanshebeineiye";

    }

    @RequestMapping(value = "/cxpt", method = RequestMethod.GET)
    public String showCxptPage() {
        String logText = "●请求访問创新平台页";

        log.info(logText + "，允许访问。●");
        return "chuangxinpingtai";

    }

    @RequestMapping(value = "/cxptxq", method = RequestMethod.GET)
    public String showCxptxqPage() {
        String logText = "●请求访問创新平台详情页";

        log.info(logText + "，允许访问。●");
        return "chuangxinpingtaineiye";

    }

    @RequestMapping(value = "/qyxq", method = RequestMethod.GET)
    public String showQyxqPage() {
        String logText = "●请求访問企业需求页";

        log.info(logText + "，允许访问。●");
        return "qiyexuqiu";

    }

    @RequestMapping(value = "/qyxqxq", method = RequestMethod.GET)
    public String showQyxqxqPage() {
        String logText = "●请求访問企业需求详情页";

        log.info(logText + "，允许访问。●");
        return "qiyexuqiuneiye";
    }

    @RequestMapping(value = "/rwjd", method = RequestMethod.GET)
    public String showRwjdPage() {
        String logText = "●请求访問人文基地页";

        log.info(logText + "，允许访问。●");
        return "renwenjidixinxi";

    }

    @RequestMapping(value = "/rwjdxq", method = RequestMethod.GET)
    public String showRwjdxqPage() {
        String logText = "●请求访問人文基地详情页";

        log.info(logText + "，允许访问。●");
        return "renwenjidixinxineiye";

    }

    @RequestMapping(value = "/rwcg", method = RequestMethod.GET)
    public String showRwcgPage() {
        String logText = "●请求访問人文成果页";

        log.info(logText + "，允许访问。●");
        return "renwenchengguoxinxi";

    }

    @RequestMapping(value = "/rwcgxq", method = RequestMethod.GET)
    public String showRwcgxqPage() {
        String logText = "●请求访問人文成果详情页";

        log.info(logText + "，允许访问。●");
        return "renwenchengguoxinxineiye";

    }

    @RequestMapping(value = "/gxfc", method = RequestMethod.GET)
    public String showGxfcPage() {
        String logText = "●请求访問高校风采页";

        log.info(logText + "，允许访问。●");
        return "gaoxiaofengcai";

    }

    @RequestMapping(value = "/gxfcxq", method = RequestMethod.GET)
    public String showGxfcxqPage() {
        String logText = "●请求访問高校风采详情页";

        log.info(logText + "，允许访问。●");
        return "gaoxiaofengcaineiye";
    }

    @RequestMapping(value = "/xzzq", method = RequestMethod.GET)
    public String showXzzqPage() {
        String logText = "●请求访問下载专区页";

        log.info(logText + "，允许访问。●");
        return "xiazaizhuanqu";
    }

    @RequestMapping(value = "/xzzqxq", method = RequestMethod.GET)
    public String showXzzqxqPage() {
        String logText = "●请求访問下载专区详情页";

        log.info(logText + "，允许访问。●");
        return "xiazaizhuanquneiye";
    }

    @RequestMapping(value = "/tzgg", method = RequestMethod.GET)
    public String showTzggPage() {
        String logText = "●请求访問通知公告页";

        log.info(logText + "，允许访问。●");
        return "tongzhigonggao";
    }

    @RequestMapping(value = "/tzggxq", method = RequestMethod.GET)
    public String showTzggxqPage() {
        String logText = "●请求访問通知公告详情页";

        log.info(logText + "，允许访问。●");
        return "tongzhigonggaoneiye";
    }






    @RequestMapping(value = "/htgl", method = RequestMethod.GET)
    public String showhtglPage() {
        String logText = "●请求访問后台管理页";

        log.info(logText + "，允许访问。●");
        return "index1";
    }

    @RequestMapping(value = "/zzgl", method = RequestMethod.GET)
    public String showZzglPage() {
        String logText = "●请求访問组织管理页";

        log.info(logText + "，允许访问。●");
        return "zuzhiguanlishouye";
    }

    @RequestMapping(value = "/zjk", method = RequestMethod.GET)
    public String showZjkPage() {
        String logText = "●请求访問专家库后台管理页";

        log.info(logText + "，允许访问。●");
        return "zhuanjiaku";
    }


    @RequestMapping(value = "/Zlxx", method = RequestMethod.GET)
    public String showzlxxPage() {
        String logText = "●请求访問专家库后台管理页";

        log.info(logText + "，允许访问。●");
        return "zhuanlixinxi1";
    }

    @RequestMapping(value = "/jsjzzqxx", method = RequestMethod.GET)
    public String showjsjzzqxxPage() {
        String logText = "●请求访問计算机著作权信息后台管理页";

        log.info(logText + "，允许访问。●");
        return "jisuanjizhuzuoquanxinxi";
    }


    @RequestMapping(value = "/Cgxx", method = RequestMethod.GET)
    public String showcgxxPage() {
        String logText = "●请求访問成果信息后台管理页";

        log.info(logText + "，允许访问。●");
        return "chengguoxinxi1";
    }

    @RequestMapping(value = "/Xmxx", method = RequestMethod.GET)
    public String showxmxxPage() {
        String logText = "●请求访問项目信息后台管理页";

        log.info(logText + "，允许访问。●");
        return "xiangmuxinxi1";
    }
    @RequestMapping(value = "/kjcxptxx", method = RequestMethod.GET)
    public String showkjcxptxxPage() {
        String logText = "●请求访問科技创新平台信息后台管理页";

        log.info(logText + "，允许访问。●");
        return "kejichuangxinpingtai";
    }
    @RequestMapping(value = "/sysbzyxx", method = RequestMethod.GET)
    public String showsysbzyxxPage() {
        String logText = "●请求访問试验设备资源信息后台管理页";

        log.info(logText + "，允许访问。●");
        return "shiyanshebeiziyuanxinxi";
    }

    @RequestMapping(value = "/cgzhxx", method = RequestMethod.GET)
    public String showcgzhxxPage() {
        String logText = "●请求访問成果转化信息后台管理页";

        log.info(logText + "，允许访问。●");
        return "chengguozhuanhuaxinxi";
    }



    @RequestMapping(value = "/zhyztk", method = RequestMethod.GET)
    public String showzhyztkPage() {
        String logText = "●请求访問高校科技成果转化研助推库后台管理页";

        log.info(logText + "，允许访问。●");
        return "yanzhutuiku";
    }

    @RequestMapping(value = "/sskjcgcyhk", method = RequestMethod.GET)
    public String showsskjcgcyhkPage() {
        String logText = "●请求访問双十科技成果产业化库后台管理页";

        log.info(logText + "，允许访问。●");
        return "shuangshikejichengguochanyehuaku";
    }







    @ApiOperation(
            value = "获取注册页路径",
            notes = "1.返回页面：\n\n" +
                    "返回注册页：register.html\n\n"
    )
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage() {
        log.info("●请求访问注册页。●");
        return "register";
    }


    @ApiOperation(
            value = "获取修改密码界面路径",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回修改密码页面：ChangePassword.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userIdentity", value = "用户ID", required = false, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "password", value = "用户授权码", required = false, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/ChangePassword", method = RequestMethod.GET)
    public String showChangePasswordPage(
            @RequestParam(value = "userIdentity", required = false) String id,
            @RequestParam(value = "password", required = false) String shouquanma
    ) {
        String logText = "●id：" + id + "，授权码：" + shouquanma + " 的用户请求修改密码界面，";

        if (id != null && shouquanma != null) {
//            Count judgeShouquan = judgeShouquan_interface.judgeShouquan(id, shouquanma, "User");
//            if (judgeShouquan.getCountResult() == 1) {
//                log.info(logText + "验证通过，允许访问。●");
//                return "ChangePassword";
//            } else {
//                log.info(logText + "授权码错误，返回403错误页面●");
            return "page_403";
//            }
        } else {
            log.info(logText + "参数错误或不足，可能为浏览器直接访问网页路径，返回404错误页面●");
            return "page_404";
        }
    }
    @ApiOperation(
            value = "跳转人才需求页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/rcxq", method = RequestMethod.GET)
    public String showRenCaiXuQiuPage() {
        String logText = "●请求访问人才需求页";

        log.info(logText + "，允许访问。●");
        return "rencaixuqiu";

    }
    @ApiOperation(
            value = "跳转金融服务需求页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/jrfwxq", method = RequestMethod.GET)
    public String showJingRongFuWuXuQiuPage() {
        String logText = "●请求访问金融服务需求页";

        log.info(logText + "，允许访问。●");
        return "jinrongfuwuxuqiu";

    }
    @ApiOperation(
            value = "跳转技术需求页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/jsxq", method = RequestMethod.GET)
    public String showJiShuWuXuQiuPage() {
        String logText = "●请求访问金融服务需求页";

        log.info(logText + "，允许访问。●");
        return "jishuxuqiu";

    }
    @ApiOperation(
            value = "跳转农业成果页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/nycg", method = RequestMethod.GET)
    public String showNongYeChengGuoPage() {
        String logText = "●请求访问农业成果页";

        log.info(logText + "，允许访问。●");
        return "nongyechengguo";

    }
    @ApiOperation(
            value = "跳转医药健康页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/yyjk", method = RequestMethod.GET)
    public String showYiYaoJianKangPage() {
        String logText = "●请求访问医药健康页";

        log.info(logText + "，允许访问。●");
        return "yiyaojiankang";

    }
    @ApiOperation(
            value = "跳转生物制造页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/swzz", method = RequestMethod.GET)
    public String showShengWuZhiZaoPage() {
        String logText = "●请求访问生物制造页";

        log.info(logText + "，允许访问。●");
        return "shengwuzhizao";

    }
    @ApiOperation(
            value = "跳转电子信息页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/dzxx", method = RequestMethod.GET)
    public String showDianZiXinXiPage() {
        String logText = "●请求访问电子信息页";

        log.info(logText + "，允许访问。●");
        return "dianzixinxi";

    }
    @ApiOperation(
            value = "跳转新能源汽车页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/xnyqc", method = RequestMethod.GET)
    public String showXinNengYuanQiChePage() {
        String logText = "●请求访问新能源汽车页";

        log.info(logText + "，允许访问。●");
        return "xinnengyuanqiche";

    }
    @ApiOperation(
            value = "跳转新材料页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/xcl", method = RequestMethod.GET)
    public String showXinCaiLiaoPage() {
        String logText = "●请求访问新材料页";

        log.info(logText + "，允许访问。●");
        return "xincailiao";

    }
    @ApiOperation(
            value = "跳转新能源开发页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/xnykf", method = RequestMethod.GET)
    public String showXinNengYuanPage() {
        String logText = "●请求访问新能源开发页";

        log.info(logText + "，允许访问。●");
        return "xinnengyuan";

    }
    @ApiOperation(
            value = "跳转先进装备制造页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/xjzb", method = RequestMethod.GET)
    public String showXianJinZhuangBeiPage() {
        String logText = "●请求访问先进装备制造页";

        log.info(logText + "，允许访问。●");
        return "xianjinzhuangbei";

    }
    @ApiOperation(
            value = "跳转节能环保页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/jnhb", method = RequestMethod.GET)
    public String showJieNengHuanBaoPage() {
        String logText = "●请求访问节能环保页";

        log.info(logText + "，允许访问。●");
        return "jienenghuanbao";

    }
    @ApiOperation(
            value = "跳转搜索结果页面",
            notes = "1.返回页面：\n\n" +
                    "若授权码正确，返回登录页面：login.html\n\n" +
                    "若授权码不正确，返回403错误页面\n\n" +
                    "若缺少参数，返回404错误页面\n\n"
    )
    @RequestMapping(value = "/sc_dt", method = RequestMethod.GET)
    public String showSouSuoPage() {
        String logText = "●请求访问搜索结果页";

        log.info(logText + "，允许访问。●");
        return "search_details";

    }

}
