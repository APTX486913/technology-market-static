package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.*;
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
import java.util.Map;

@Api(value = "列表筛选接口", description = "列表筛选接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class FiltrateController {
//    @Autowired
//    private FiltrateChengguo_Interface filtratechengguo_interface;
//    @ApiOperation(
//            value = "获取成果信息接口",
//            notes = "1.返回值状态（status）\n\n" +
//                    "100：数据获取成功；\n\n" +
//                    "200：未找到数据；\n\n" +
//                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
//                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
//                    + "2.返回值value数组：\n\n" +
//                    "鉴定项目编号：\" Identification_number \"\n\n" +
//                    "成果类型：\"results_type \"\n\n" +
//                    "成果名称：\"results_name \"\n\n" +
//                    "应用领域：\"application_field\" \n\n" +
//                    "所属单位：\"subordinate_units \" \n\n" +
//                    "完成时间：\" finish_time \"\n\n" +
//                    "评价方式—水平：\"evaluation_way_level \"\n\n" +
//                    "评价日期：\"evaluation_date \"\n\n" +
//                    "评价机构：\"evaluation_institution\" \n\n" +
//                    "成果登记号：\"result_id \" \n\n" +
//                    "成果简介：\" result_summary \"\n\n" +
//                    "完成人：\"wanchengren \"\n\n" +
//                    "是否已转化：\"converted_or_not \"\n\n" +
//                    "联系人：\"contact\" \n\n" +
//                    "联系电话：\"contact_phone_number \" \n\n" +
//                    "电子邮箱：\" e_mail \"\n\n" +
//                    "通信地址：\"communication_address \"\n\n" +
//                    "邮编：\"postal_code \"\n\n" +
//                    "经手人：\"jingshouren\" \n\n" +
//                    "登记日期：\"registration_data \"\n\n" +
//                    "审批标志：\"approval_mark \"\n\n" +
//                    "校审核结果：\"audit_results_school\" \n\n" +
//                    "厅审核结果：\"audit_results_hall \" \n\n" +
//                    "备注：\" comment \"\n\n" +
//                    "组织编号：\"organization_id \"\n\n" +
//                    "校审核人：\"verifier_scchool \"\n\n" +
//                    "厅审核人：\"verifier_hall\" \n\n" +
//                    "填报单位—院：\"reporting_unit_court \" \n\n" +
//                    "填报单位—校：\"reporting_unit_school \" \n\n"
//    )
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "result_TypeId", value = "成果类型", required = true, dataType = "String", paramType = "String"),
//            @ApiImplicitParam(name = "organizationID", value = "组织编号", required = true, dataType = "Int", paramType = "Int"),
//            @ApiImplicitParam(name = "evaluate_levelId", value = "评价水平", required = true, dataType = "  String", paramType = "String")
//    })
//    @RequestMapping(value = "/filchengguo", method = RequestMethod.POST)
//    public Result chengguoxinxi(
//            @Param("result_TypeId") String result_TypeId ,
//            @Param("organizaztionId") int organizationId,
//            @Param("evaluate_levelId") String evaluate_levelId
//    ) { String logText = "●根据条件获取成果信息";
//        Result result = new Result();
//
//
//        try {
//            List<Chengguoxinxi> filchengguoList = new ArrayList<>(filtratechengguo_interface.filchengguo(result_TypeId,organizationId,evaluate_levelId));
//            if (filchengguoList.size() > 0) {
//                result.setStatus(100);
//                result.setMsg("success");
//                result.setValue(filchengguoList);
//                log.info(logText + "获取成功●");
//            } else {
//                result.setStatus(200);
//                result.setMsg("Not found");
//                log.info(logText + "无成果信息或信息不足●");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.setStatus(601);
//            result.setMsg("Error!");
//            log.error(logText + "★操作出现异常！★");
//        }
//        return result;
//    }
    @Autowired
    private Filtratexiangmu_Interface filtratexiangmu_interface;
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
            @ApiImplicitParam(name = "project_source", value = "项目来源", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "project_level", value = "项目级别", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "affiliated_unit", value ="所属单位", required = true, dataType = "String", paramType = "String"),
    })
    @RequestMapping(value = "/filxiangmu", method = RequestMethod.POST)
    public Result shiyanxinxi(
            @Param("project_source")String project_source,
            @Param("project_level") String project_level,
            @Param("affiliated_unit")String affiliated_unit

    ) {
        String logText = "●根据条件获得项目信息";
        Result result = new Result();
        try {
            List<Xiangmuxinxi>filxiangmuList = new ArrayList<>(filtratexiangmu_interface.filxiangmu(project_source,project_level,affiliated_unit));
            if (filxiangmuList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(filxiangmuList);
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
    @Autowired
    private Filtratezhuanjia_Interface filtratezhuanjia_interface;
    @ApiOperation(
            value = "根据id获取专家信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "专家编号：\" professor_number \"\n\n" +
                    "专家姓名：\"name \"\n\n" +
                    "性别：\"gender \"\n\n" +
                    "出生日期：\"born_date\" \n\n" +
                    "行业1：\"industry_1 \" \n\n"+
                    "行业2：\" industry_2 \"\n\n" +
                    "专家学历：\"education_background \"\n\n" +
                    "专家职称：\"zhi_cheng \"\n\n" +
                    "专家职务：\"duty\" \n\n" +
                    "级别：\"level \" \n\n"+
                    "称号：\" title \"\n\n" +
                    "单位：\"organization \"\n\n" +
                    "身份证号：\"ID_number \"\n\n" +
                    "通信地址：\"commodation_address\" \n\n" +
                    "电子邮件：\"E_maile \" \n\n"+
                    "常用电话：\" phone_number \"\n\n" +
                    "专家简介：\"intro \"\n\n" +
                    "照片：\"photograph \"\n\n" +
                    "经手人：\"jing_shou_ren\" \n\n" +
                    "登记日期：\"register_date \" \n\n"+
                    "审批标志：\" sign \"\n\n" +
                    "学校审核结果：\"check_result_xiao \"\n\n" +
                    "厅审核结果：\"check_result_ting \"\n\n" +
                    "备注：\"remarks\" \n\n"+
                    "组织编号：\"organization_number \" \n\n"+
                    "校审核人：\" auditor_xiao \"\n\n" +
                    "厅审核人：\"auditor_ting \"\n\n" +
                    "填报单位_院：\"tianbao_yuan \"\n\n" +
                    "填报单位_校：\"tianbao_xiao\" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "industry_type", value = "行业类型", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "sex", value = "性别", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "organization", value = "所属单位", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "tit" ,value = "职业", required = true, dataType = "String", paramType = "String"),
    })
    @RequestMapping(value = "/filzhuanjia", method = RequestMethod.POST)
    public Result zhuanjiaxinxi(
            @Param("industry_type") String industry_type,
            @Param("sex")String sex,
            @Param("organization") String organization,
            @Param("tit")String tit
    ){
        String logText = "●按条件获取专家信息";
        Result result = new Result();
        try {
            List<Zhuanjiaxinxi> filzhuanjiaList = new ArrayList<>(filtratezhuanjia_interface.filzhuanjia(industry_type, sex,organization ,tit));
            if (filzhuanjiaList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(filzhuanjiaList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无专家信息或信息不足●");
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
    private Filtratezhuanli_Interface filtratezhuanli_interface;
    @ApiOperation(
            value = "获取专利信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "专利编号：\" serial_number \"\n\n" +
                    "专利名称：\"name \"\n\n" +
                    "专利类型：\"type \"\n\n" +
                    "专利号：\"number\" \n\n" +
                    "申请号：\"apply_number \" \n\n"+
                    "申请日期：\" apply_date \"\n\n" +
                    "专利权人：\"patent_person \"\n\n" +
                    "证书号：\"credential_number \"\n\n" +
                    "联系人：\"contact_person\" \n\n" +
                    "联系电话：\"contact_number \" \n\n"+
                    "电子邮件：\" E_mail \"\n\n" +
                    "通信地址：\"communication_address \"\n\n" +
                    "邮编：\"postcode \"\n\n" +
                    "经手人：\"jing_shou_ren\" \n\n" +
                    "登记日期：\"register_date \" \n\n"+
                    "审批标志：\" sign \"\n\n" +
                    "校审批结果：\"xiao_result \"\n\n" +
                    "厅审批结果：\"ting_result \"\n\n" +
                    "备注：\"remark\" \n\n" +
                    "组织编号：\"organization_id \" \n\n"+
                    "校审核人：\" xiao_auditor \"\n\n" +
                    "厅审核人：\"ting_auditor \"\n\n" +
                    "填报单位_院：\"tianbao_yuan \"\n\n" +
                    "填报单位_校：\"tianbao_xiao\" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "patent_type", value = "专利类型", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "organization", value = "学校编号", required = true, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/filzhuanli", method = RequestMethod.POST)
    public Result zhuanlixinxi(
            @Param("patent_type")String patent_type,
            @Param("organization")String organization
    ) {
        String logText = "●筛选专利信息";
        Result result = new Result();
        try {
            List<Filtratezhuanli> filzhuanliList = new ArrayList<>(filtratezhuanli_interface.filzhuanli(patent_type,organization));
            if (filzhuanliList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(filzhuanliList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无专利信息或信息不足●");
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
    private Filtrateshebei_Interface filtrateshebei_interface;
    @ApiOperation(
            value = "获取实验相关信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "设备编号：\" shebei_number \"\n\n" +
                    "设备名称：\"shebei_name \"\n\n" +
                    "关键字：\"keyword \"\n\n" +
                    "生产单位：\"production_unit\" \n\n" +
                    "启用日期：\"start_time \" \n\n"+
                    "使用寿命：\" service_life \"\n\n" +
                    "设备价格：\"price \"\n\n" +
                    "设备简介：\"introduction \"\n\n" +
                    "设备数量：\"quantity\" \n\n" +
                    "设备用途：\"purpose \" \n\n"+
                    "照片：\" picture \"\n\n" +
                    "联系人：\"linkman \"\n\n" +
                    "联系电话：\"contact_number \"\n\n" +
                    "电子邮箱：\"E_mail\" \n\n" +
                    "通信地址：\"mailing_address \" \n\n"+
                    "邮编：\" postcode \"\n\n" +
                    "经手人：\"jing_shou_ren \"\n\n" +
                    "登记日期：\"register_date \"\n\n" +
                    "审批标志：\"review_sign\" \n\n" +
                    "校审核结果：\" audit_result_xiao \"\n\n" +
                    "厅审核结果：\"audit_result_ting \"\n\n" +
                    "备注：\"remarks \"\n\n" +
                    "组织编号：\"group_number\" \n\n" +
                    "校审核人：\"auditor_xiao\" \n\n" +
                    "厅审核人：\"auditor_ting\" \n\n" +
                    "填报单位_院：\"tianbao_danwei_yuan\" \n\n" +
                    "填报单位_校：\"tianbao_danwei_xiao\" \n\n"

    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "organization", value = "填报单位校编号", required = true, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/filshebei", method = RequestMethod.POST)
    public Result shiyanxinxi(
            @Param("organization") int organization
    ) {
        String logText = "●请求根据id获取实验信息，是否获取全部.";
        Result result = new Result();
        try {
            List<Shebeixinxi> filshebeiList = new ArrayList<>(filtrateshebei_interface.filshebei(organization));
            if (filshebeiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(filshebeiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无实验信息或信息不足●");
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
    private Filtrateinnovateplat_Interface filtrateinnovateplat_interface;

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
            @ApiImplicitParam(name = "industry_type", value = "行业类型", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = " platform_type", value = "平台类型", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "organization", value = "所属单位", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/filinnovateoplat", method = RequestMethod.POST)
    public Result innovateplat(
            @Param("industry_type") String industry_type,
            @Param("platform_type") String platform_type,
            @Param("organization") int organization
    ) {
        String logText = "●筛选创新平台信息";
        Result result = new Result();

        try {
            List<Innovateplat> filinnovateplatList = new ArrayList<>(filtrateinnovateplat_interface.filInnovateplat(industry_type,platform_type,organization));
            if (filinnovateplatList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(filinnovateplatList);
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
    @Autowired
    private Filtrateinfo_Interface filtrateinfo_interface;
    @ApiOperation(
            value = "搜索信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：搜索成功；\n\n" +
                    "200：数据未找到；\n\n" +
                    "601：数据异常；\n\n" +
                    "2.返回值value数组：\n\n" +
                    "dataFrom的值分别是：\n\n" +
                    "RD对应成果展示：\n\n" +
                    "CR对应企业需求：\n\n" +
                    "PR对应专家信息：\n\n" +
                    "PA对应专利信息：\n\n" +
                    "EF对应实验设备：\n\n" +
                    "INP对应创新平台：\n\n" +
                    "HPL对应项目信息：\n\n" +
                    "HS对应人文社科：\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dataFrom", value = "数据来源", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "type", value = "类型", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "school", value = "学校", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "begin_time", value = "开始时间", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "end_time", value = "结束时间", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int")
    }
    )
    @RequestMapping(value = "/filtrateinfo", method = RequestMethod.POST)
    public Result filtrateinfo(@Param("dataFrom") String dataFrom, @Param("type") String type, @Param("school") String school, @Param("begin_time") String begin_time, @Param("end_time") String end_time,
                               @Param("page") int page,
                               @Param("pagesize") int pagesize){
        Result result = new Result();
        String logText = "●搜索信息,";
        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;
        try {
            List<Map<String,Object>> filtrateinfoList = new ArrayList(filtrateinfo_interface.filtrateinfo(dataFrom, type, school, begin_time, end_time,start_subscript,pagesize));
            if(filtrateinfoList.size() > 0){
                result.setMsg("Success");
                result.setStatus(100);
                result.setValue(filtrateinfoList);
                log.info(logText+"搜索成功");
            }else{
                result.setMsg("Not Found");
                result.setStatus(200);
                log.info(logText+"无信息或信息不足");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("Error");
            result.setStatus(601);
            log.info(logText+"★操作出现异常！★");
        }

        return result;
    }
}
