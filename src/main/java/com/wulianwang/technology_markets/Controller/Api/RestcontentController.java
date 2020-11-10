package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Interface.Reset_Interface.*;
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

@Api(value = "修改信息接口", description = "修改信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class RestcontentController {
    @Autowired
    private Resetappname_Interface resetappname_interface;
    @Autowired
    private ResetDeclareType_Interface resetDeclareType_interface;
    @Autowired
    private ResetDepartmentName_Interface resetDepartmentName_interface;
    @Autowired
    private ResetDesignation_Interface resetDesignation_interface;
    @Autowired
    private ResetFundResources_Interface resetFundResources_interface;
    @Autowired
    private ResetIndustryType_Interface resetIndustryType_interface;
    @Autowired
    private ResetOrganizationName_Interface resetOrganizationName_interface;
    @Autowired
    private ResetPlanResource_Interface resetPlanResource_interface;
    @Autowired
    private ResetProductStage_Interface resetProductStage_interface;
    @Autowired
    private ResetProductionStage_Interface resetProductionStage_interface;
    @Autowired
    private ResetProjectAreas_Interface resetProjectAreas_interface;
    @Autowired
    private ResetProjectTechnologySource_Interface resetProjectTechnologySource_interface;
    @Autowired
    private  ResettranformationType_Interface resettranformationType_interface;


       @ApiOperation(
            value = "修改应用领域内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "修改应用领域内容id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_name", value = "应用领域名称", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetappname", method = RequestMethod.POST)
    public Result resetappname(
            @Param("ident") String ident,
            @Param("re_name") String re_name
    ) {
        String logText = "●修改应用领域内容id" + ident + "应用领域名称" + re_name ;
        Result result = new Result();
        try {
            resetappname_interface.resetappname(ident,re_name);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }

    @ApiOperation(
            value = "修改项目申报类别表内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "项目申报类别id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_type", value = "项目申报种类", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetdeclaretype", method = RequestMethod.POST)
    public Result resetdeclaretype(
            @Param("ident") String ident,
            @Param("re_type") String re_type
    ) {
        String logText = "●项目申报类别id" + ident + "项目申报种类" + re_type ;
        Result result = new Result();
        try {
            resetDeclareType_interface.resetDeclareType(ident,re_type);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "修改地方或部门计划基金表内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "地方或部门计划基金id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_name", value = "地方或部门计划基金名称", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetdepartmentname", method = RequestMethod.POST)
    public Result resetdepartmentname(
            @Param("ident") String ident,
            @Param("re_name") String re_name
    ) {
        String logText = "●地方或部门计划基金id" + ident + "地方或部门计划基金名称" + re_name ;
        Result result = new Result();
        try {
            resetDepartmentName_interface.resetDepartmentName(ident,re_name);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }

    @ApiOperation(
            value = "修改称号表",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "称号id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_designation", value = "称号名称", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetdesignation", method = RequestMethod.POST)
    public Result resetdesignation(
            @Param("ident") String ident,
            @Param("re_designation") String re_designation
    ) {
        String logText = "●称号id" + ident + "称号名称" + re_designation ;
        Result result = new Result();
        try {
            resetDesignation_interface.resetDesignation(ident,re_designation);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "修改项目基金来源表内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "基金来源id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_resources", value = "基金来源", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetfundresources", method = RequestMethod.POST)
    public Result resetfundresources(
            @Param("ident") String ident,
            @Param("re_resources") String re_resources
    ) {
        String logText = "●基金来源id" + ident + "基金来源" + re_resources ;
        Result result = new Result();
        try {
            resetFundResources_interface.resetFundResources(ident,re_resources);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "修改行业表内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "行业id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_type", value = "行业类型", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetindustrytype", method = RequestMethod.POST)
    public Result resetindustrytype(
            @Param("ident") String ident,
            @Param("re_type") String re_type
    ) {
        String logText = "●行业id" + ident + "行业类型" + re_type ;
        Result result = new Result();
        try {
            resetIndustryType_interface.resetIndustryType(ident,re_type);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "修改组织名称",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "修改组织id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_name", value = "修改组织名称", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetorganizationname", method = RequestMethod.POST)
    public Result resetorganizationname(
            @Param("ident") String ident,
            @Param("re_name") String re_name
    ) {
        String logText = "●修改组织id" + ident + "修改组织名称" + re_name ;
        Result result = new Result();
        try {
            resetOrganizationName_interface.resetOrganizationName(ident,re_name);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "修改项目计划来源表内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "项目计划来源id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_plan_source", value = "项目计划来源", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetplanresource", method = RequestMethod.POST)
    public Result resetplanresource(
            @Param("ident") String ident,
            @Param("re_plan_source") String re_plan_source
    ) {
        String logText = "●项目计划来源id" + ident + "项目计划来源" + re_plan_source ;
        Result result = new Result();
        try {
            resetPlanResource_interface.resetPlanResource(ident,re_plan_source);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "修改产品所处阶段表内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "产品所处阶段id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_stage", value = "产品所处阶段名称", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetproductstage", method = RequestMethod.POST)
    public Result resetproductstage(
            @Param("ident") String ident,
            @Param("re_stage") String re_stage
    ) {
        String logText = "●产品所处阶段id" + ident + "产品所处阶段名称" + re_stage ;
        Result result = new Result();
        try {
            resetProductStage_interface.resetProductStage(ident,re_stage);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "修改产品生产阶段表内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "产品生产阶段id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_stage", value = "产品生产阶段", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetproductionstage", method = RequestMethod.POST)
    public Result resetproductionstage(
            @Param("ident") String ident,
            @Param("re_stage") String re_stage
    ) {
        String logText = "●产品生产阶段id" + ident + "产品生产阶段" + re_stage ;
        Result result = new Result();
        try {
            resetProductionStage_interface.resetProductionStage(ident,re_stage);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "修改项目所属领域表内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "项目所属领域id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_field", value = "所属领域", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetprojectareas", method = RequestMethod.POST)
    public Result resetprojectareas(
            @Param("ident") String ident,
            @Param("re_field") String re_field
    ) {
        String logText = "●项目所属领域id" + ident + "所属领域" + re_field ;
        Result result = new Result();
        try {
            resetProjectAreas_interface.resetProjectAreas(ident,re_field);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "修改项目技术来源表内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "项目技术来源id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "reproject_technology_sourc", value = "项目技术来源", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resetprojecttechnologysource", method = RequestMethod.POST)
    public Result resetprojecttechnologysource(
            @Param("ident") String ident,
            @Param("reproject_technology_sourc") String reproject_technology_sourc
    ) {
        String logText = "●项目技术来源id" + ident + "项目技术来源" + reproject_technology_sourc ;
        Result result = new Result();
        try {
            resetProjectTechnologySource_interface.resetProjectTechnologySource(ident,reproject_technology_sourc);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
    @ApiOperation(
            value = "修改转化服务类型表内容",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据修改；\n\n" +
                    "601：数据异常禁止修改（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "转化服务类型id", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "re_tyrp", value = "转化服务类型类别", required = true, dataType = "String", paramType = "String")

    })
    @RequestMapping(value = "/resettranformationtype", method = RequestMethod.POST)
    public Result resettranformationtype(
            @Param("ident") String ident,
            @Param("re_tyrp") String re_tyrp
    ) {
        String logText = "●转化服务类型id" + ident + "转化服务类型类别" + re_tyrp ;
        Result result = new Result();
        try {
            resettranformationType_interface.resettranformationType(ident,re_tyrp);
            result.setStatus(100);
            result.setMsg("success");
            log.info(logText + "修改成功●");
        }catch (Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }



}
