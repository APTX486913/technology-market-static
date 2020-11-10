package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Pingtaisort;
import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Pingtaisort_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "平台分类接口", description = "平台分类接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class PingtaisortController {
    @Autowired
    private Pingtaisort_Interface pingtaisort_interface;
    @ApiOperation(
            value = "获取所平台分类信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "平台分类ID：\" id \"\n\n" +
                    "平台类别：\"sorts \"\n\n" +
                    "价值：\"value \"\n\n"
    )
    @RequestMapping(value = "/pingtaisort", method = RequestMethod.POST)
    public Result pingtaisort() {
        String logText ="●请求获取平台分类信息。";
        Result result = new Result();
        try {
            List<Pingtaisort> pingtaisortList = new ArrayList<>(pingtaisort_interface.getpingtaisort());
            if (pingtaisortList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(pingtaisortList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无平台分类信息或信息不足●");
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
