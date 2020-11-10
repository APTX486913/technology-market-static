package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Innovateplat;
import com.wulianwang.technology_markets.Bean.Innovatexiangxi;
import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Innovateplat_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Innovatexiangxi_Interface;
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

@Api(value = "创新平台接口", description = "创新平台信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class InnovateplatController {
    @Autowired
    private Innovateplat_Interface innovateplat_interface;
    @Autowired
    private Innovatexiangxi_Interface innovatexiangxi_interface;

    @ApiOperation(
            value = "获取创新平台信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "平台编号：\" platform_number \"\n\n" +
                    "名称：\"name \"\n\n" +
                    "地址：\"address \"\n\n" +
                    "负责人：\"person_in_charge\" \n\n" +
                    "平台分类：\"platform_classification \" \n\n"+
                    "挂靠单位：\" attached_unit \"\n\n" +
                    "批准单位：\"approval_unit \"\n\n" +
                    "批准成立时间：\"establishment_time \"\n\n" +
                    "行业1：\"industry_1\" \n\n" +
                    "行业2：\"industry_2 \" \n\n"+
                    "单位简介：\" unit_introduction \"\n\n" +
                    "单位主页：\"unit_homepage \"\n\n" +
                    "联系人：\"contact \"\n\n" +
                    "联系电话：\"contact_phone_number \" \n\n"+
                    "电子邮箱：\" e_mail \"\n\n" +
                    "邮编：\"postal_code \"\n\n" +
                    "经手人：\"jingshouren\" \n\n" +
                    "登记日期：\"registration_data \"\n\n" +
                    "审批标志：\"approval_mark \"\n\n" +
                    "校审核结果：\"audit_results_school\" \n\n" +
                    "厅审核结果：\"audit_results_hall \" \n\n"+
                    "备注：\" remark \"\n\n" +
                    "组织编号：\"organization_id \"\n\n" +
                    "校审核人：\"verifier_scchool \"\n\n" +
                    "厅审核人：\"verifier_hall\" \n\n" +
                    "填报单位—院：\"reporting_unit_court \" \n\n"+
                    "填报单位—校：\"reporting_unit_school \" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "identity", value = "平台名称（organization_id）", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/innovateplat", method = RequestMethod.POST)
    public Result innovateplat(
            @Param("identity") int identity,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求获取创新平台信息（所属单位ID）：" + identity + "，页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Innovateplat> innovateplatList = new ArrayList<>(innovateplat_interface.innovateplat(identity, start_subscript, pagesize));
            if (innovateplatList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(innovateplatList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无创新平台信息或信息不足●");
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
            @ApiImplicitParam(name = "identity", value = "平台编号(platform_number)", required = true, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/innovatexiangxi", method = RequestMethod.POST)
    public Result innovatexiangxi(
            @Param("identity") String identity
    ) {
        String logText = "●请求获取创新平台详细信息（平台编号platform_number）：" + identity + "。";
        Result result = new Result();
        try {
            List<Innovatexiangxi> innovatexiangxiList = new ArrayList<>(innovatexiangxi_interface.innovatexiangxi(identity));
            if (innovatexiangxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(innovatexiangxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无创新平台详细信息或信息不足●");
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
