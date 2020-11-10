package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.FiltrategetRequirementInterface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Comrequire_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Comxxrequire_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Suoshudanwei_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xuqiuleixing_Interface;
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

@Api(value = "企业需求接口", description = "企业需求信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ComrequireController {
    @Autowired
    private Comrequire_Interface comrequire_interface;
    @Autowired
    private Comxxrequire_Interface comxxrequire_interface;
    @Autowired
    private FiltrategetRequirementInterface filtrategetRequirementInterface;
    @ApiOperation(
            value = "获取企业需求接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "企业需求ID：\" id \"\n\n" +
                    "企业项目名称：\"name \"\n\n" +
                    "需求内容：\"content \"\n\n" +
                    "企业ID：\"e_id\" \n\n" +
                    "日期：\"date \"\n\n" +
                    "地位1or0：\"status\" \n\n" +
                    "项目类型：\"type \" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/comrequire", method = RequestMethod.POST)
    public Result comrequire(
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求获取企业需求信息，页码为："  + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Comrequire> comrequireList = new ArrayList<>(comrequire_interface.comrequire(start_subscript, pagesize));
            if (comrequireList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(comrequireList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无企业需求信息或信息不足●");
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
            value = "分类获取企业需求接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    +"2.返回值value数组：\n\n" +
                    "企业需求ID：\" id \"\n\n" +
                    "企业项目名称：\"name \"\n\n" +
                    "需求内容：\"content \"\n\n" +
                    "企业ID：\"e_id\" \n\n" +
                    "日期：\"date \"\n\n" +
                    "地位1or0：\"status\" \n\n" +
                    "项目类型：\"type \" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "requirement_type", value = "企业需求类型", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/filtrategetRequirement", method = RequestMethod.POST)
    public Result filtrategetRequirement(
            @Param("requirement_type")String requirement_type,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求获取企业需求信息，页码为："  + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Comxxrequire> comrequires = new ArrayList<>(filtrategetRequirementInterface.filtrategetRequirement(requirement_type,start_subscript, pagesize));
            if (comrequires.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(comrequires);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无企业需求信息或信息不足●");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiImplicitParams({
            @ApiImplicitParam(name = "identity", value = "获取企业需求ID(id)", required = true, dataType = "String", paramType = "String"),
    })
    @RequestMapping(value = "/comxxrequire", method = RequestMethod.POST)
    public Result comrequire(

            @Param("identity") String identity
    ) {
        String logText = "●请求获取企业需求ID(id)：" + identity + "。";
        Result result = new Result();
        try {
            List<Comxxrequire> comxxrequireList = new ArrayList<>(comxxrequire_interface.comxxrequire(identity));
            if (comxxrequireList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(comxxrequireList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无企业需求详细信息或信息不足●");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @Autowired
    Xuqiuleixing_Interface xuqiuleixing_interface;
    @ApiOperation(
            value = "获取企业需求类型接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    +"2.返回值value数组：\n\n" +
                    "企业需求类型ID：\" id \"\n\n" +
                    "企业需求类型：\"type \"\n\n" +
                    "价值：\"value \" \n\n"
    )
    @RequestMapping(value = "/getXuqiuleixing", method = RequestMethod.POST)
    public Result getXuqiuleixing(
    ) {
        String logText = "●请求获取企业需求信息类型列表。";
        Result result = new Result();


        try {
            List<Xuqiuleixing> xuqiuleixings = new ArrayList<>(xuqiuleixing_interface.getxuqiuleixing());
            if (xuqiuleixings.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(xuqiuleixings);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无企业需求类型信息或信息不足●");
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
