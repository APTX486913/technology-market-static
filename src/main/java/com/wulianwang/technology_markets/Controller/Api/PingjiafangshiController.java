package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "评价方式接口", description = "评价方式接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class PingjiafangshiController {
    @Autowired
    private Pingjiafangshi_Interface pingjiafangshi_interface;
    @Autowired
    private Jiandingpingjia_Interface jiandingpingjia_interface;
    @Autowired
    private Jietipingjia_Interface jietipingjia_interface;
    @Autowired
    private Yanshoupingjia_Interface yanshoupingjia_interface;
    @Autowired
    private Waypingjia_Interface waypingjia_interface;
    @ApiOperation(
            value = "获取评价方式接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "评价ID：\" id \"\n\n" +
                    "评价方式或评价水平：\"type \"\n\n" +
                    "value(1or0)：\"value \"\n\n"
    )
    @RequestMapping(value = "/pingjiafangshi", method = RequestMethod.POST)
    public Result pingjiafangshi() {
        String logText = "●请求获取評價方式。";

        Result result = new Result();

        try {
            List<Pingjiafangshi> pingjiafangshisList = new ArrayList<>(pingjiafangshi_interface.getpingjiafangshi());
            if (pingjiafangshisList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(pingjiafangshisList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无评价方式信息或信息不足●");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @RequestMapping(value = "/jiandingpingjia", method = RequestMethod.POST)
    public Result jiandingpingjia() {
        String logText = "●请求获取评价方式_鉴定。";

        Result result = new Result();

        try {
            List<Jiandingpingjia> jiandingpingjiaList = new ArrayList<>(jiandingpingjia_interface.getjiandingpingjia());
            if (jiandingpingjiaList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(jiandingpingjiaList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无评价方式_鉴定信息或信息不足●");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @RequestMapping(value = "/jietipingjia", method = RequestMethod.POST)
    public Result jietipingjia() {
        String logText = "●请求获取评价方式_结题。";

        Result result = new Result();

        try {
            List<Jietipingjia> jietipingjiaList = new ArrayList<>(jietipingjia_interface.getjietipingjia());
            if (jietipingjiaList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(jietipingjiaList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无评价方式_结题信息或信息不足●");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @RequestMapping(value = "/yanshoupingjia", method = RequestMethod.POST)
    public Result yanshoupingjia() {
        String logText = "●请求获取评价方式_验收。";

        Result result = new Result();

        try {
            List<Yanshoupingjia> yanshoupingjiaList = new ArrayList<>(yanshoupingjia_interface.getyanshoupingjia());
            if (yanshoupingjiaList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(yanshoupingjiaList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无评价方式_验收信息或信息不足●");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @RequestMapping(value = "/waypingjia", method = RequestMethod.POST)
    public Result waypingjia() {
        String logText = "●请求获取评价方式。";

        Result result = new Result();

        try {
            List<Waypingjia> waypingjiaList = new ArrayList<>(waypingjia_interface.getwaypingjia());
            if (waypingjiaList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(waypingjiaList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无评价方式信息或信息不足●");
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
