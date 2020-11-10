package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Hangyetype;
import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Bean.Sexhuoqu;
import com.wulianwang.technology_markets.Bean.Xuqiuleixing;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Hangyetype_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Sexhuoqu_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xuqiuleixing_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "各种类型接口", description = "各种类型接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class TypeController {
    @Autowired
    private Xuqiuleixing_Interface xuqiuleixing_interface;
    @Autowired
    private Hangyetype_Interface hangyetype_interface;
    @Autowired
    private Sexhuoqu_Interface sexhuoqu_interface;

    @ApiOperation(
            value = "获取需求类型接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "需求类型ID：\" id \"\n\n" +
                    "需求类型：\"type \"\n\n" +
                    "价值：\"value \"\n\n"
    )
    @RequestMapping(value = "/xuqiuleixing", method = RequestMethod.POST)
    public Result xuqiuleixing() {
        String logText = "●请求获取需求类型信息。";
        Result result = new Result();
        try {
            List<Xuqiuleixing> xuqiuleixingList = new ArrayList<>(xuqiuleixing_interface.getxuqiuleixing());
            if (xuqiuleixingList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(xuqiuleixingList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无需求类型信息或信息不足●");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }

    @ApiOperation(
            value = "获取行业类型接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "行业id：\" id \"\n\n" +
                    "行业类型：\"type \"\n\n" +
                    "价值：\"value \"\n\n"
    )
    @RequestMapping(value = "/hangyetype", method = RequestMethod.POST)
    public Result hangyetype() {
        String logText = "●请求获取行业类型。";
        Result result = new Result();
        try {
            List<Hangyetype> hangyetypeList = new ArrayList<>(hangyetype_interface.hangyetype());
            if (hangyetypeList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(hangyetypeList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无行业类型信息或信息不足●");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }

    @ApiOperation(
            value = "获取性别信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "性别ID：\" id \"\n\n" +
                    "性别：\"gender \"\n\n" +
                    "价值：\"value \"\n\n"
    )
    @RequestMapping(value = "/sexhuoqu", method = RequestMethod.POST)
    public Result sexhuoqu() {
        String logText = "●请求获取性别。";
        Result result = new Result();
        try {
            List<Sexhuoqu> sexhuoquList = new ArrayList<>(sexhuoqu_interface.getsexhuoqu());
            if (sexhuoquList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(sexhuoquList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无性别信息或信息不足●");
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
