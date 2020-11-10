package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.FiltrateChengguo_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Chengguoleixing_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Chengguoxinxi_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Chengguoxxxinxi_Interface;
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

@Api(value = "成果信息接口", description = "成果相关信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ChengguoxinxiController {
    @Autowired
    private Chengguoxinxi_Interface chengguoxinxi_interface;
    @Autowired
    private Chengguoxxxinxi_Interface chengguoxxxinxi_interface;
    @Autowired
    private Chengguoleixing_Interface chengguoleixing_interface;

    @ApiOperation(
            value = "获取成果信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "鉴定项目编号：\" Identification_number \"\n\n" +
                    "成果类型：\"results_type \"\n\n" +
                    "成果名称：\"results_name \"\n\n" +
                    "应用领域：\"application_field\" \n\n" +
                    "所属单位：\"subordinate_units \" \n\n" +
                    "完成时间：\" finish_time \"\n\n" +
                    "评价方式—水平：\"evaluation_way_level \"\n\n" +
                    "评价日期：\"evaluation_date \"\n\n" +
                    "评价机构：\"evaluation_institution\" \n\n" +
                    "成果登记号：\"result_id \" \n\n" +
                    "成果简介：\" result_summary \"\n\n" +
                    "完成人：\"wanchengren \"\n\n" +
                    "是否已转化：\"converted_or_not \"\n\n" +
                    "联系人：\"contact\" \n\n" +
                    "联系电话：\"contact_phone_number \" \n\n" +
                    "电子邮箱：\" e_mail \"\n\n" +
                    "通信地址：\"communication_address \"\n\n" +
                    "邮编：\"postal_code \"\n\n" +
                    "经手人：\"jingshouren\" \n\n" +
                    "登记日期：\"registration_data \"\n\n" +
                    "审批标志：\"approval_mark \"\n\n" +
                    "校审核结果：\"audit_results_school\" \n\n" +
                    "厅审核结果：\"audit_results_hall \" \n\n" +
                    "备注：\" comment \"\n\n" +
                    "组织编号：\"organization_id \"\n\n" +
                    "校审核人：\"verifier_scchool \"\n\n" +
                    "厅审核人：\"verifier_hall\" \n\n" +
                    "填报单位—院：\"reporting_unit_court \" \n\n" +
                    "填报单位—校：\"reporting_unit_school \" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "identity", value = "学校名称（所属单位organization_id）", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/chengguoxinxi", method = RequestMethod.POST)
    public Result chengguoxinxi(
            @Param("identity") int identity,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求获取成果信息学校名称（所属单位ID）：" + identity + "，页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Chengguoxinxi> chengguoxinxiList = new ArrayList<>(chengguoxinxi_interface.chengguoxinxi(identity, start_subscript, pagesize));
            if (chengguoxinxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(chengguoxinxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无成果信息或数据不足●");
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
    FiltrateChengguo_Interface filtrateChengguo_interface;
    @ApiOperation(
            value = "分类获取成果信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "鉴定项目编号：\" Identification_number \"\n\n" +
                    "成果类型：\"results_type \"\n\n" +
                    "成果名称：\"results_name \"\n\n" +
                    "应用领域：\"application_field\" \n\n" +
                    "所属单位：\"subordinate_units \" \n\n" +
                    "完成时间：\" finish_time \"\n\n" +
                    "评价方式—水平：\"evaluation_way_level \"\n\n" +
                    "评价日期：\"evaluation_date \"\n\n" +
                    "评价机构：\"evaluation_institution\" \n\n" +
                    "成果登记号：\"result_id \" \n\n" +
                    "成果简介：\" result_summary \"\n\n" +
                    "完成人：\"wanchengren \"\n\n" +
                    "是否已转化：\"converted_or_not \"\n\n" +
                    "联系人：\"contact\" \n\n" +
                    "联系电话：\"contact_phone_number \" \n\n" +
                    "电子邮箱：\" e_mail \"\n\n" +
                    "通信地址：\"communication_address \"\n\n" +
                    "邮编：\"postal_code \"\n\n" +
                    "经手人：\"jingshouren\" \n\n" +
                    "登记日期：\"registration_data \"\n\n" +
                    "审批标志：\"approval_mark \"\n\n" +
                    "校审核结果：\"audit_results_school\" \n\n" +
                    "厅审核结果：\"audit_results_hall \" \n\n" +
                    "备注：\" comment \"\n\n" +
                    "组织编号：\"organization_id \"\n\n" +
                    "校审核人：\"verifier_scchool \"\n\n" +
                    "厅审核人：\"verifier_hall\" \n\n" +
                    "填报单位—院：\"reporting_unit_court \" \n\n" +
                    "填报单位—校：\"reporting_unit_school \" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "result_TypeId", value = "成果类型id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/filtrateChengguo", method = RequestMethod.POST)
    public Result filtrateChengguo(
            @Param("result_TypeId") String result_TypeId,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求分类获取成果信息。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Chengguoxinxi> chengguoxinxiList = new ArrayList<>(filtrateChengguo_interface.filchengguo(result_TypeId, 0, "0",start_subscript,pagesize));
            if (chengguoxinxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(chengguoxinxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无成果信息或数据不足●");
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
            value = "根据高校和类型获取成果信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "鉴定项目编号：\" Identification_number \"\n\n" +
                    "成果类型：\"results_type \"\n\n" +
                    "成果名称：\"results_name \"\n\n" +
                    "应用领域：\"application_field\" \n\n" +
                    "所属单位：\"subordinate_units \" \n\n" +
                    "完成时间：\" finish_time \"\n\n" +
                    "评价方式—水平：\"evaluation_way_level \"\n\n" +
                    "评价日期：\"evaluation_date \"\n\n" +
                    "评价机构：\"evaluation_institution\" \n\n" +
                    "成果登记号：\"result_id \" \n\n" +
                    "成果简介：\" result_summary \"\n\n" +
                    "完成人：\"wanchengren \"\n\n" +
                    "是否已转化：\"converted_or_not \"\n\n" +
                    "联系人：\"contact\" \n\n" +
                    "联系电话：\"contact_phone_number \" \n\n" +
                    "电子邮箱：\" e_mail \"\n\n" +
                    "通信地址：\"communication_address \"\n\n" +
                    "邮编：\"postal_code \"\n\n" +
                    "经手人：\"jingshouren\" \n\n" +
                    "登记日期：\"registration_data \"\n\n" +
                    "审批标志：\"approval_mark \"\n\n" +
                    "校审核结果：\"audit_results_school\" \n\n" +
                    "厅审核结果：\"audit_results_hall \" \n\n" +
                    "备注：\" comment \"\n\n" +
                    "组织编号：\"organization_id \"\n\n" +
                    "校审核人：\"verifier_scchool \"\n\n" +
                    "厅审核人：\"verifier_hall\" \n\n" +
                    "填报单位—院：\"reporting_unit_court \" \n\n" +
                    "填报单位—校：\"reporting_unit_school \" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "results_TypeId", value = "成果类型id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "school", value = "高校名称", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/filtrategetResultByTS", method = RequestMethod.POST)
    public Result filtrategetResultByTS(
            @Param("results_TypeId") String results_TypeId,
            @Param("school") String school,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求分类获取成果信息。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Chengguoxinxi> chengguoxinxiList = new ArrayList<>(filtrateChengguo_interface.filtrategetResultByTS(results_TypeId, school, start_subscript,pagesize));
            if (chengguoxinxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(chengguoxinxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无成果信息或数据不足●");
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
            @ApiImplicitParam(name = "identity", value = "鉴定项目编码(Identification_number)", required = true, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/chengguoxxxinxi", method = RequestMethod.POST)
    public Result chengguoxxxinxi(
            @Param("identity") String identity
    ) {
        String logText = "●请求获取详细成果信息（鉴定项目编码）：" + identity + "。";
        Result result = new Result();
        try {
            List<Chengguoxxxinxi> chengguoxxxinxiList = new ArrayList<>(chengguoxxxinxi_interface.chengguoxxxinxi(identity));
            if (chengguoxxxinxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(chengguoxxxinxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无成果信息或数据不足●");
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
            value = "获取成果类型信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "成果类型ID：\" id \"\n\n" +
                    "成果类型：\"results_type \"\n\n" +
                    "价值：\"value \"\n\n"
    )
    @RequestMapping(value = "/chengguoleixing", method = RequestMethod.POST)
    public Result chengguoleixing() {
        String logText = "●请求获取成果类型。";
        Result result = new Result();
        try {
            List<Chengguoleixing> chengguoleixingList = new ArrayList<>(chengguoleixing_interface.getchengguoleixing());
            if (chengguoleixingList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(chengguoleixingList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无成果类型数据或数据不足●");
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
