package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.Interface.SearchInterface.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "搜索接口", description = "管理网站信息搜索接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class SearchController {
    @Autowired
    private SearchChengguoxinxi_Interface searchChengguoxinxi_interface;
    @Autowired
    private SearchInnovateplat_Interface searchInnovateplat_interface;
    @Autowired
    private SearchXiangmuxinxi_Interface searchXiangmuxinxi_interface;
    @Autowired
    private SearchZhuanjiaxinxi_Interface searchZhuanjiaxinxi_interface;
    @Autowired
    private SearchZhuanlixinxi_Interface searchZhuanlixinxi_interface;
    @Autowired
    private SearchShebeixinxi_Interface searchShebeixinxi_interface;
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keywords", value = "关键字", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "moduleName", value = "模块名\n\n" +
                    "成果信息：chengguo\n\n" +
                    "平台信息：innovateplat\n\n" +
                    "设备信息：shebei\n\n" +
                    "项目信息：xiangmu"+
                    "专家信息：zhuanjia\n\n" +
                    "专利信息：zhuanli\n\n" , required = true, dataType = "String", paramType = "String"),
    })
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result search(
            @RequestParam(value = "keywords") String keywords,
            @RequestParam(value = "moduleName") String moduleName
    ) {
        String logText = "●检索" + moduleName + "模块，关键字为：" + keywords + " 的信息，";

        //处理关键字长度，避免数据库检索操作出现异常
        if (keywords.length() > 60)
            keywords = keywords.substring(0, 60);

        Result result = new Result();
        List<Chengguoxinxi> chengguoList= new ArrayList<>();
        List<Innovateplat> innovateplatList = new ArrayList<>();
        List<Shebeixinxi> shebeiList = new ArrayList<>();
        List<Xiangmuxinxi> xiangmuList = new ArrayList<>();
        List<Zhuanjiaxinxi> zhuanjiaList= new ArrayList<>();
        List<Zhuanlixinxi> zhuanliList = new ArrayList<>();

        try {
            switch (moduleName) {
                case "chengGuo":
                    chengguoList = searchChengguoxinxi_interface.searchChengguoxinxi(keywords);
                    if (chengguoList.size() > 0) {
                        result.setStatus(100);
                        result.setMsg("信息检索成功");
                        result.setValue(chengguoList);
                        log.info(logText + "成果信息检索成功●");
                    } else {
                        result.setStatus(200);
                        result.setMsg("无匹配的信息");
                        log.info(logText + "无匹配的成果信息●");
                    }
                    break;
                case "innovateplat":
                    innovateplatList = searchInnovateplat_interface.searchInnovateplat(keywords);
                    if (innovateplatList.size() > 0) {
                        result.setStatus(100);
                        result.setMsg("信息检索成功");
                        result.setValue(innovateplatList);
                        log.info(logText + "平台信息检索成功●");
                    } else {
                        result.setStatus(200);
                        result.setMsg("无匹配的信息");
                        log.info(logText + "无匹配的平台信息●");
                    }
                    break;
                case "sheBei":
                    shebeiList = searchShebeixinxi_interface.searchShebeixinxi(keywords);
                    if (shebeiList.size() > 0) {
                        result.setStatus(100);
                        result.setMsg("信息检索成功");
                        result.setValue(shebeiList);
                        log.info(logText + "设备信息检索成功●");
                    } else {
                        result.setStatus(200);
                        result.setMsg("无匹配的信息");
                        log.info(logText + "无匹配的设备信息●");
                    }
                    break;
                case "xiangMu":
                    xiangmuList = searchXiangmuxinxi_interface.searchXiangmuxinxi(keywords);
                    if (xiangmuList.size() > 0) {
                        result.setStatus(100);
                        result.setMsg("信息检索成功");
                        result.setValue(xiangmuList);
                        log.info(logText + "项目信息检索成功●");
                    } else {
                        result.setStatus(200);
                        result.setMsg("无匹配的信息");
                        log.info(logText + "无匹配的项目信息●");
                    }
                    break;
                case "zhuanJia":
                    zhuanjiaList = searchZhuanjiaxinxi_interface.searchZhuanjiaxinxi(keywords);
                    if (zhuanjiaList.size() > 0) {
                        result.setStatus(100);
                        result.setMsg("信息检索成功");
                        result.setValue(zhuanjiaList);
                        log.info(logText + "专家信息检索成功●");
                    } else {
                        result.setStatus(200);
                        result.setMsg("无匹配的信息");
                        log.info(logText + "无匹配的专家信息●");
                    }
                    break;

                case "zhuanLi":
                    zhuanliList = searchZhuanlixinxi_interface.searchZhuanlixinxi(keywords);
                    if (zhuanliList.size() > 0) {
                        result.setStatus(100);
                        result.setMsg("信息检索成功");
                        result.setValue(zhuanliList);
                        log.info(logText + "专利信息检索成功●");
                    } else {
                        result.setStatus(200);
                        result.setMsg("无匹配的信息");
                        log.info(logText + "无匹配的专利信息●");
                    }
                    break;
                default:
                    result.setStatus(400);
                    result.setMsg("Wrong！");
                    log.warn(logText + "★传入的模块名错误，可能存在非本系统调用后台接口，系统维护人员应注意此种情况！★");
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
