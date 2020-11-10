package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.Interface.AddInterface.*;
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

@Api(value = "添加信息接口", description = "添加信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class AddController {
    @Autowired
    private Addchanpinjieduan_Interface addchanpinjieduan_interface;//产品阶段

    @ApiOperation(
            value = "添加产品所处阶段接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据添加；\n\n" +
                    "601：数据异常禁止添加（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "stage", value = "产品阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "value", value = "价值", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "biaozhi", value = "标志", required = true, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/addchanpinjieduan", method = RequestMethod.POST)
    public Result chanpinjieduan(
            @Param("id") String id,
            @Param("stage") String stage,
            @Param("value") int value,
            @Param("biaozhi") String biaozhi
    ) {
        String logText = "●向产品阶段中添加id号为" + id + "阶段名称为" + stage + "价值是" + value + "标志为" + biaozhi + "的新阶段";
        Result result = new Result();
        try {
            addchanpinjieduan_interface.addchanpinjieduan(id,stage,value,biaozhi);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "添加成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @Autowired
    private Addchanyehua_Interface addchanyehua_interface;//产业化

    @ApiOperation(
            value = "添加产业化信息",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据添加；\n\n" +
                    "601：数据异常禁止添加（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "project_number", value = "项目编号", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "project_name", value = "项目名称", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "tianbao_danwei", value = "填报单位", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "conversion_time", value = "转化时间", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "project_manager", value = "项目负责人", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "gender", value = "性别", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "technology_title", value = "技术职称", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "education_background", value = "学历", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "contact_number", value = "联系电话", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "landline_phone", value = "座机电话", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "field", value = "所属领域", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "plan_source", value = "项目来源1", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "technology_source", value = "项目来源2", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "accredit_invent", value = "授权专利发明", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "accredit_practical", value = "授权专利实用新型", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "accredit_appearance", value = "授权专利外观设计", required = true, dataType = "String", paramType  = "String"),
            @ApiImplicitParam(name = "check_department", value = "鉴定验收部门", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "acceptance_time", value = "鉴定验收时间", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "awards", value = "获奖情况", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "stage", value = "项目产品所处阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "introduction", value = "产品简介用途主要技术指标", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "explain", value = "是否体现经济特色资源优势情况说明", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "market_analysis", value = "时长需求销售情况市场前景市场竞争力分析", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "product_comparison", value = "关键技术创新点同类产品技术比较", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "benefit_forecast", value = "效益情况及今后预测", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "jing_shou_ren", value = "经手人", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "register_date", value = "登记日期", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "review_sign", value = "审批标志", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "audit_result_xiao", value = "校审核结果", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "audit_result_ting", value = "厅审核结果", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "remarks", value = "备注", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "group_number", value = "组织编号", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "auditor_xiao", value = "校审核人", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "auditor_ting", value = "厅审核人", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "tianbao_danwei_yuan", value = "填报单位院", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "tianbao_danwei_xiao", value = "填报单位校", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "biaozhi", value = "标志", required = true, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/addchanyehua", method = RequestMethod.POST)
    public Result chengguoxinxi(
            @Param("project_number") String projectnumber, @Param("project_name")String projectname, @Param("tianbao_danwei") String tianbaodanwei,
            @Param("conversion_time") String conversion_time, @Param("project_manager") String project_manager, @Param("gender") String gender,
            @Param("age") int age, @Param("technology_title") String technologytitle, @Param("education_background") String educationbackground,
            @Param("landline_phone") String landline_phone, @Param("contact_number") String contact_number, @Param("field") String field,
            @Param("plan_source") String plan_source, @Param("technology_source") String technology_source, @Param("accredit_invent") String accredit_invent,
            @Param("accredit_practical") String accredit_practical, @Param("accredit_appearance") String accredit_appearance, @Param("check_department") String check_department,
            @Param("acceptance_time") String acceptance_time, @Param("awards") String awards, @Param("stage") String stage,
            @Param("introduction")String introduction, @Param("explain") String explain, @Param("market_analysis") String market_analysis,
            @Param("product_comparison") String product_comparison, @Param("benefit_forecast")String benefit_forecast, @Param("jing_shou_ren") String jing_shou_ren,
            @Param("register_date") String register_date, @Param("review_sign") int review_sign, @Param("audit_result_xiao") String audit_result_xiao,
            @Param("audit_result_ting") String audit_result_ting, @Param("remarks") String remarks, @Param("group_number") String group_number,
            @Param("auditor_xiao") String auditor_xiao, @Param("auditor_ting") String auditor_ting, @Param("tianbao_danwei_yuan") String tianbao_danwei_yuan,
            @Param("tianbao_danwei_xiao") String tianbao_danwei_xiao,@Param("biaozhi") String biaozhi
    ) {
        String logText = "●向产品阶段中添加项目编号为" + projectnumber + "的双十科技成果产业化信息";
        Result result = new Result();
        try {
           addchanyehua_interface.addChanyehuaxinxi( projectnumber, projectname, tianbaodanwei, conversion_time,project_manager,gender, age,technologytitle,educationbackground,
                   landline_phone,contact_number,field, plan_source, technology_source, accredit_invent, accredit_practical, accredit_appearance, check_department,
                      acceptance_time, awards, stage, introduction, explain, market_analysis,
                     product_comparison, benefit_forecast, jing_shou_ren, register_date, review_sign, audit_result_xiao,
                     audit_result_ting, remarks, group_number, auditor_xiao, auditor_ting, tianbao_danwei_yuan, tianbao_danwei_xiao,biaozhi);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "添加成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }

    @Autowired
    private Addchengguoxinxi_Interface addchengguoxinxi_interface;//产品阶段

    @ApiOperation(
            value = "添加成果信息信息",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据添加；\n\n" +
                    "601：数据异常禁止添加（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Identification_number", value = "项目编号", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "results_type", value = "产品阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "results_name", value = "价值", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "application_field", value = "标志", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "subordinate_units", value = "id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "finish_time", value = "产品阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "evaluation_way_level", value = "价值", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "technology_title", value = "标志", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "evaluation_date", value = "id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "evaluation_institution", value = "产品阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "result_id", value = "价值", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "result_summary", value = "标志", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "wanchengren", value = "id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "converted_or_not", value = "产品阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "contact", value = "价值", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "contact_phone_number", value = "标志", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "e_mail", value = "id", required = true, dataType = "String", paramType  = "String"),
            @ApiImplicitParam(name = "communication_address", value = "产品阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "postal_code", value = "价值", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "jingshouren", value = "标志", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "", value = "id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "introduction", value = "产品阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "explain", value = "价值", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "market_analysis", value = "标志", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "product_comparison", value = "id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "benefit_forecast", value = "产品阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "jing_shou_ren", value = "价值", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "register_date", value = "标志", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "review_sign", value = "id", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "audit_result_xiao", value = "产品阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "audit_result_ting", value = "价值", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "remarks", value = "标志", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "group_number", value = "id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "auditor_xiao", value = "产品阶段", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "auditor_ting", value = "价值", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "tianbao_danwei_yuan", value = "标志", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "tianbao_danwei_xiao", value = "标志", required = true, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/addchengguoxinxi", method = RequestMethod.POST)
    public Result chengguoxinxi(
            @Param("Identification_number") String Identification_number, @Param("results_type") String results_type, @Param("results_name") String results_name,
            @Param("application_field") String application_field, @Param("subordinate_units") String subordinate_units, @Param("finish_time") String finish_time,
            @Param("evaluation_way_level") String evaluation_way_level, @Param("evaluation_date") String evaluation_date, @Param("evaluation_institution") String evaluation_institution,
            @Param("result_id") String result_id, @Param("result_summary") String result_summary, @Param("wanchengren") String wanchengren,
            @Param("converted_or_not") String converted_or_not, @Param("contact") String contact, @Param("contact_phone_number") String contact_phone_number,
            @Param("e_mail") String e_mail, @Param("communication_address") String communication_address, @Param("postal_code")String postal_code,
            @Param("jingshouren") String jingshouren, @Param("registration_data") String registration_data, @Param("approval_mark")int approval_mark,
            @Param("audit_results_school") String audit_results_school, @Param("audit_results_hall") String audit_results_hall, @Param("comment") String comment,
            @Param("organization_id") String organization_id, @Param("verifier_school") String verifier_scchool, @Param("verifier_hall") String verifier_hall,
            @Param("reporting_unit_court") String reporting_unit_court, @Param("reporting_unit_school") String reporting_unit_school
    ) {
        String logText = "●向产品阶段中添加id号";
        Result result = new Result();
        try {
            addchengguoxinxi_interface.addchengguoxinxi( Identification_number, results_type, results_name,
                     application_field, subordinate_units, finish_time,
                     evaluation_way_level, evaluation_date, evaluation_institution,
                     result_id,  result_summary, wanchengren,
                     converted_or_not, contact, contact_phone_number,
                     e_mail,  communication_address, postal_code,
                     jingshouren,  registration_data, approval_mark,
             audit_results_school, audit_results_hall, comment,
                     organization_id, verifier_scchool, verifier_hall,
                     reporting_unit_court,reporting_unit_school);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "添加成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }


}
