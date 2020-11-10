package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Interface.Reset_Interface.Resetchengguotrans_Interface;
import com.wulianwang.technology_markets.Interface.Reset_Interface.Resettechchengguopass_Interface;
import com.wulianwang.technology_markets.Interface.Reset_Interface.Resettechreserchpass_Interface;
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

@Api(value = "验证通过接口", description = "验证通过接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class YanzhengpassController {
    @Autowired
    Resettechchengguopass_Interface resettechchengguopass_interface;
    @Autowired
    Resettechreserchpass_Interface resettechreserchpass_interface;
    @Autowired
    Resetchengguotrans_Interface resetchengguotrans_interface;
    @ApiOperation(
            value = "添加产品所处阶段接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据添加；\n\n" +
                    "601：数据异常禁止添加（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "id", required = true, dataType = "String", paramType = "String"),

    })
    @RequestMapping(value = "/resettechchengguopass", method = RequestMethod.POST)
    public Result resettechchengguopass(
            @Param("ident") String ident) {
        String logText = "●验证id号为" + ident ;
        Result result = new Result();
        try {
            resettechchengguopass_interface.resettechchengguopass(ident);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "验证成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "添加产品所处阶段接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据添加；\n\n" +
                    "601：数据异常禁止添加（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "id", required = true, dataType = "String", paramType = "String"),

    })
    @RequestMapping(value = "/resettechreserchpass", method = RequestMethod.POST)
    public Result resettechreserchpass(
            @Param("ident") String ident) {
        String logText = "●验证id号为" + ident ;
        Result result = new Result();
        try {
            resettechchengguopass_interface.resettechchengguopass(ident);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "验证成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "添加产品所处阶段接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据添加；\n\n" +
                    "601：数据异常禁止添加（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "id", required = true, dataType = "String", paramType = "String"),

    })
    @RequestMapping(value = "/resetchengguotrans", method = RequestMethod.POST)
    public Result resetchengguotrans(
            @Param("ident") String ident) {
        String logText = "●验证id号为" + ident ;
        Result result = new Result();
        try {
            resetchengguotrans_interface.resetchengguotrans(ident);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "验证成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
}
