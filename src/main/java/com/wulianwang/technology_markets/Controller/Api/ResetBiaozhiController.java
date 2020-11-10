package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "检验通过接口", description = "检验通过接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ResetBiaozhiController {
    @Autowired
    ChengguoxinxiPass_Interface chengguoxinxiPass_interface;
    @Autowired
    Chengguozhuanhua_Interface chengguozhuanhua_interface;
    @Autowired
    ChuangxinpingtaiPass_Interface chuangxinpingtaiPass_interface;
    @Autowired
    Gaoxiaokeji_Interface gaoxiaokeji_interface;
    @Autowired
    Qiyexuqiu_Interface qiyexuqiu_interface;
    @Autowired
    RenwencjengguoPass_Interface renwencjengguoPass_interface;
    @Autowired
    Renwenjidi_Interface renwenjidi_interface;
    @Autowired
    RuanjianzhuzuoquanPass_Interface ruanjianzhuzuoquanPass_interface;
    @Autowired
    Shiyanshebei_Interface shiyanshebei_interface;
    @Autowired
    Shuangshikeji_Interface shuangshikeji_interface;
    @Autowired
    XiangmuPass_Interface xiangmuPass_interface;
    @Autowired
    ZhuanjiaxinxiPass_Interface zhuanjiaxinxiPass_interface;
    @Autowired
    ZhuanlixinxiPass_Interface zhuanlixinxiPass_interface;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "moduleName", value = "模块名\n\n" +
                    "项目信息：xiangmu\n\n" +
                    "双十科技成果信息：shuangshikeji\n\n" +
                    "高校科技信息：gaoxiaokeji\n\n" +
                    "成果转化信息：chengguozhuanhua"+
                    "企业需求信息：qiyexuqiu\n\n" +
                    "实验设备信息：shiyanshebei\n\n" +
                    "专利信息：zhuanlixinxi\n\n" +
                    "创新平台信息：chuangxinpingtai\n\n" +
                    "专家信息：zhuanjiaxinxi"+
                    "成果信息：chengguoxinxi\n\n" +
                    "软件著作权信息：ruanjianzhuzuoquan\n\n" +
                    "人文社科成果信息：renwencjengguo\n\n" +
                    "人文社尔基地：renwenjidi\n\n" , required = true, dataType = "String", paramType = "String"),
    })
    @RequestMapping(value = "/resetbiaozhi", method = RequestMethod.POST)
    public Result search(
            @RequestParam(value = "ident") String ident,
            @RequestParam(value = "moduleName") String moduleName
    ) {
        String logText = "●检验" + moduleName + "id：" + ident + " 是否通过，";
        Result result = new Result();
        try {
            switch (moduleName) {
                case "xiangmu":
                    try {
                        xiangmuPass_interface.xiangmuPass(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "shuangshikeji":
                    try {
                        shuangshikeji_interface.shuangshikeji(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "gaoxiaokeji":
                    try {
                        gaoxiaokeji_interface.gaoxiaokeji(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "chengguozhuanhua":
                    try {
                        chengguozhuanhua_interface.chengguozhuanhua(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "qiyexuqiu":
                    try {
                        qiyexuqiu_interface.qiyexuqiu(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "shiyanshebei":
                    try {
                        shiyanshebei_interface.shiyanshebei(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "zhuanlixinxi":
                    try {
                        zhuanlixinxiPass_interface.zhuanlixinxiPass(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "chuangxinpingtai":
                    try {
                        chuangxinpingtaiPass_interface.chuangxinpingtaiPass(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "zhuanjiaxinxi":
                    try {
                        zhuanjiaxinxiPass_interface.zhuanjiaxinxiPass(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "chengguoxinxi":
                    try {
                        chengguoxinxiPass_interface.chengguoxinxiPass(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "ruanjianzhuzuoquan":
                    try {
                        ruanjianzhuzuoquanPass_interface.ruanjianzhuzuoquanPass(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "renwencjengguo":
                    try {
                        renwencjengguoPass_interface.renwencjengguoPass(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                case "renwenjidi":
                    try {
                        renwenjidi_interface.renwenjidiPass(ident);
                        result.setStatus(100);
                        result.setMsg("success");
                        log.info(logText + "修改成功●");
                    }catch (Exception e){
                        e.printStackTrace();
                        result.setStatus(601);
                        result.setMsg("Error!");
                        log.error(logText + "★操作出现异常！★");
                    }
                    break;
                default:
                    result.setStatus(400);
                    result.setMsg("Wrong！");
                    log.warn(logText + "★传入的id错误，可能存在非本系统调用后台接口，系统维护人员应注意此种情况！★");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }

        return result;
    }


    }
