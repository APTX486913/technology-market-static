package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Dahangyetype;
import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Bean.Xiaohangyetype;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Dahangyetype_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiaohangyetype_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "行业类型信息接口", description = "行业类型信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class HangyeTypeController {
    @Autowired
    private Xiaohangyetype_Interface xiaohangyetype_interface;
    @Autowired
    private Dahangyetype_Interface dahangyetype_interface;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry_big", value = "大行业id即[industry_type表中id]", required = true, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/xiaohangyetype", method = RequestMethod.POST)
    public Result xiaohangyetype(
            @Param("industry_big") String industry_big
    ) {
        String logText = "●请求获取小行业类型信息（大行业id即[industry_type表中id(例如01 02...)]）：" + industry_big + "。";
        Result result = new Result();
        try {
            List<Xiaohangyetype> xiaohangyetypeList = new ArrayList<>(xiaohangyetype_interface.xiaohangyetype(industry_big));
            if (xiaohangyetypeList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(xiaohangyetypeList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无小行业类型信息或信息不足●");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @RequestMapping(value = "/dahangyetype", method = RequestMethod.POST)
    public Result dahangyetype() {
        String logText = "●请求获取大行业类型信息。";
        Result result = new Result();
        try {
            List<Dahangyetype> dahangyetypeList = new ArrayList<>(dahangyetype_interface.getdahangyetype());
            if (dahangyetypeList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(dahangyetypeList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无大行业类型信息或信息不足●");
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
