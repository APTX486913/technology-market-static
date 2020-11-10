package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiangmujibie_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiangmulaiyuan_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiangmuxinxi_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiangmuxxxinxi_Interface;
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

@Api(value = "项目相关信息接口", description = "项目相关信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class XiangmuxinxiController {
    @Autowired
    private Xiangmuxinxi_Interface xiangmuxinxi_interface;
    @Autowired
    private Xiangmuxxxinxi_Interface xiangmuxxxinxi_interface;
    @Autowired
    private Xiangmulaiyuan_Interface xiangmulaiyuan_interface;
    @Autowired
    private Xiangmujibie_Interface xiangmujibie_interface;
    @ApiOperation(
            value = "获取项目信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "项目编号：\" project_number \"\n\n" +
                    "项目名称：\"project_name \"\n\n" +
                    "项目类型：\"project_type \"\n\n" +
                    "合同编号：\"contract_number\" \n\n" +
                    "负责人：\"person_in_charge \" \n\n"+
                    "开始时间：\" start_time \"\n\n" +
                    "结束时间：\"end_time \"\n\n" +
                    "合同经费：\"contract_funding \"\n\n" +
                    "项目级别：\"project_level\" \n\n" +
                    "服务行业：\"service_industry \" \n\n"+
                    "承担单位：\" undertaking_unit \"\n\n" +
                    "参加单位1：\"canjiadanwei1 \"\n\n" +
                    "参加单位2：\"canjiadanwei2 \"\n\n" +
                    "项目状态：\"project_state\" \n\n" +
                    "内容简介：\"content_abstract \" \n\n"+
                    "联系人：\" contact \"\n\n" +
                    "联系电话：\"contact_phone_number \"\n\n" +
                    "电子邮箱：\"e_mail \"\n\n" +
                    "通讯地址：\"communication_address\" \n\n" +
                    "邮编：\"postal_code \" \n\n"+
                    "经手人：\" jingshouren \"\n\n" +
                    "登记日期：\"registration_data \"\n\n" +
                    "审批标志：\"approval_mark \"\n\n" +
                    "校审核结果：\"audit_results_school\" \n\n" +
                    "厅审核结果：\"audit_results_hall \" \n\n"+
                    "备注：\" comment \"\n\n" +
                    "组织编号：\"organization_id \"\n\n" +
                    "校审核人：\"verifier_scchool \"\n\n" +
                    "厅审核人：\"verifier_hall\" \n\n" +
                    "填报单位—院：\"reporting_unit_court \" \n\n"+
                    "填报单位—校：\"reporting_unit_school \" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "identity", value = "项目（学校id：organization_id)", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/xiangmuxinxi", method = RequestMethod.POST)
    public Result xiangmuxinxi(
            @Param("identity") int identity,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求根据学校id获取项目信息：" + identity + "，页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Xiangmuxinxi> xiangmuxinxiList = new ArrayList<>(xiangmuxinxi_interface.xiangmuxinxi(identity, start_subscript, pagesize));
            if (xiangmuxinxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(xiangmuxinxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无项目信息或信息不足●");
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
            @ApiImplicitParam(name = "identity", value = "项目(projec_number)", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/xiangmuxxxinxi", method = RequestMethod.POST)
    public Result xiangmuxxxinxi(
            @Param("identity") String identity

    ) {
        String logText = "●请求根据projec_number获取项目名称：" + identity +"。";
        Result result = new Result();
        try {
            List<Xiangmuxxxinxi> xiangmuxxxinxiList = new ArrayList<>(xiangmuxxxinxi_interface.xiangmuxxxinxi(identity));
            if (xiangmuxxxinxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(xiangmuxxxinxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无项目详细信息或信息不足●");
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
            value = "获取项目来源接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "基金来源ID：\" id \"\n\n" +
                    "基金来源：\"resources \"\n\n" +
                    "价值value：\"value \"\n\n"
    )
    @RequestMapping(value = "/xiangmulaiyuan", method = RequestMethod.POST)
    public Result xiangmulaiyuan() {
        String logText ="●请求获取項目來源信息。";

        Result result = new Result();

        try {
            List<Xiangmulaiyuan> xiangmulaiyuanList = new ArrayList<>(xiangmulaiyuan_interface.getxiangmulaiyuan());
            if (xiangmulaiyuanList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(xiangmulaiyuanList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "项目来源信息或信息不足●");
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
            value = "获取项目级别接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "項目級別ID：\" id \"\n\n" +
                    "项目级别类型：\"type \"\n\n" +
                    "价值value：\"value \"\n\n"
    )
    @RequestMapping(value = "/xiangmujibie", method = RequestMethod.POST)
    public Result xiangmujibie() {
        String logText ="●请求获取項目级别信息。";

        Result result = new Result();

        try {
            List<Xiangmujibie> xiangmujibieList = new ArrayList<>(xiangmujibie_interface.getxiangmujibie());
            if (xiangmujibieList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(xiangmujibieList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无项目级别信息或信息不足●");
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
