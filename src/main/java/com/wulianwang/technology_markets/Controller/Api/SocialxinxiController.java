package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.*;
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

@Api(value = "人文信息接口", description = "人文相关信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class SocialxinxiController {
    @Autowired
    private Socialbase_Interface socialbase_interface;
    @Autowired
    private Socialbasexiangxi_Interface socialbasexiangxi_interface;
    @Autowired
    private Socialtype_Interface socialtype_interface;
    @Autowired
    private Socialresult_Interface socialresult_interface;
    @Autowired
    private Socialresultxiangxi_Interface socialresultxiangxi_interface;
    @ApiOperation(
            value = "获取人文基地信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "人文基地id：\" id \"\n\n" +
                    "基地名称：\"base_name \"\n\n" +
                    "依托单位：\"rely_unit \"\n\n" +
                    "批准时间：\"ratify_time\" \n\n" +
                    "批准部门：\"ratify_department \" \n\n" +
                    "所在地点：\" site \"\n\n" +
                    "学科门类：\"category \"\n\n" +
                    "负责人姓名：\"fuzeren_name \"\n\n" +
                    "负责人年龄：\"fuzuren_age\" \n\n" +
                    "负责人职称职务：\"fuzeren_duty \" \n\n" +
                    "负责人所在单位：\" fuzeren_unit \"\n\n" +
                    "责任人社会兼职：\"fuzeren_parttime_job \"\n\n" +
                    "负责人获得奖励情况：\"fuzeren_award \"\n\n" +
                    "团队情况(500字以内)：\"team_introduction\" \n\n" +
                    "其他介绍：\"base_intro \" \n\n" +
                    "社会效益情况：\" social_benefit \"\n\n" +
                    "联系人：\"connect_people \"\n\n" +
                    "联系电话：\"connect_number \"\n\n" +
                    "电子邮件：\"E_mail\" \n\n" +
                    "通信地址：\"mailing_address \"\n\n" +
                    "邮编：\"postcode \"\n\n" +
                    "备注：\"remark\" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "identity", value = "学校名称（所属单位organization_id）", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/socialbase", method = RequestMethod.POST)
    public Result socialbase(
            @Param("identity") int identity,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求获取人文基地列表信息的学校名称（所属单位ID）：" + identity + "，页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Socialbase> socialbaseList = new ArrayList<>(socialbase_interface.socialbase(identity, start_subscript, pagesize));
            if (socialbaseList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(socialbaseList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无人文基地列表信息或信息不足●");
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
            @ApiImplicitParam(name = "identity", value = "人文基地id(id)", required = true, dataType = "int", paramType = "int")
    })
    @RequestMapping(value = "/socialbasexiangxi", method = RequestMethod.POST)
    public Result socialbasexiangxi(
            @Param("identity") int identity
    ) {
        String logText = "●请求根据id获取人文基地详细信息（人文基地id(id)）：" + identity + "。";
        Result result = new Result();
        try {
            List<Socialbasexiangxi> socialbasexiangxiList = new ArrayList<>(socialbasexiangxi_interface.socialbasexiangxi(identity));
            if (socialbasexiangxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(socialbasexiangxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无人文基地详细信息或信息不足●");
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
            value = "获取人文类型接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "人文社科成果类型id：\" id \"\n\n" +
                    "人文社科成果类别：\"type \"\n\n" +
                    "价值：\"value \"\n\n"
    )
    @RequestMapping(value = "/socialtype", method = RequestMethod.POST)
    public Result socialtype() {
        String logText = "●请求获取人文类型信息。";
        Result result = new Result();
        try {
            List<Socialtype> socialtypeList = new ArrayList<>(socialtype_interface.getsocialtype());
            if (socialtypeList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(socialtypeList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无人文类型信息或信息不足●");
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
            value = "根据获取人文成果信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "人文成果id：\" id \"\n\n" +
                    "成果类型：\"result_type \"\n\n" +
                    "学科门类：\"category \"\n\n" +
                    "成果名称：\"result_name\" \n\n" +
                    "成果获奖情况：\"result_award \" \n\n"+
                    "成果社会效益：\" result_benefit \"\n\n" +
                    "成果引用或被采纳情况：\"result_accept \"\n\n" +
                    "应用领域：\"application_area \"\n\n" +
                    "所属单位：\"affiliated_unit\" \n\n" +
                    "出版、发表或使用单位：\"use_unit \" \n\n"+
                    "出版、发表或使用时间：\" use_time \"\n\n" +
                    "成果简介：\"result_intro \"\n\n" +
                    "完成人：\"accomplish_people \"\n\n" +
                    "联系人：\"contact_people\" \n\n" +
                    "联系电话：\"contact_number \" \n\n"+
                    "电子邮件：\" E_mail \"\n\n" +
                    "通信地址：\"mailing_address \"\n\n" +
                    "邮编：\"postcode \"\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "identity", value = "学校名（organization_id)", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/socialresult", method = RequestMethod.POST)
    public Result socialresult(
            @Param("identity") int identity,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求根据学校id获取人文成果列表：" + identity + "，页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Socialresult> socialresultList = new ArrayList<>(socialresult_interface.socialresult(identity, start_subscript, pagesize));
            if (socialresultList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(socialresultList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无人文成果列表信息或信息不足●");
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
            @ApiImplicitParam(name = "identity", value = "人文成果id(id)", required = true, dataType = "int", paramType = "int")
    })
    @RequestMapping(value = "/socialresultxiangxi", method = RequestMethod.POST)
    public Result socialresultxiangxi(
            @Param("identity") int identity
    ) {
        String logText = "●请求根据id获取人文成果详细信息（人文成果id(id)）：" + identity + "。";
        Result result = new Result();
        try {
            List<Socialresult> socialresultxiangxiList = new ArrayList<>(socialresultxiangxi_interface.socialresultxiangxi(identity));
            if (socialresultxiangxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(socialresultxiangxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无人文成果详细信息或信息不足●");
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
