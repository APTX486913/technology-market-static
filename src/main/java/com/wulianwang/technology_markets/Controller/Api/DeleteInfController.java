package com.wulianwang.technology_markets.Controller.Api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "删除信息接口", description = "管理网站单条信息删除接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class DeleteInfController {
    @Autowired
    private DeleteInf_Interface deleteInf_interface;

    @ApiOperation(
            value = "管理网站单条信息删除接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：信息删除成功；\n\n" +
                    "400：传入的模块名错误，可能存在非本系统调用后台接口，维护人员应注意此种情况；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "moduleName", value = "模块名\n\n" +
                    "应用领域信息：applicationarea\n\n" +
                    "申报类别：declaretype\n\n" +
                    "计划基金表：departmentfund\n\n" +
                    "称号表：chenghao\n\n" +
                    "基金来源:jijinlaiyuan\n\n" +
                    "行业表：hangye\n\n" +
                    "产品阶段：chanpinjieduan\n\n" +
                    "生产阶段：shengchanjieduan\n\n" +
                    "所属领域：suoshulingyu\n\n" +
                    "技术来源：jishulaiyuan\n\n" +
                    "转化服务类型：zhuanhuafuwu\n\n", required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "informationId", value = "需要删除信息的ID", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/deleteInf", method = RequestMethod.POST)
    public Result deleteInf(
            @RequestParam(value = "moduleName") String moduleName,
            @RequestParam(value = "informationId") int informationId
    ) {
        String logText = "●管理员ID为请求删除" + moduleName + "模块，信息ID为：" + informationId + " 的信息条目，";
        Result result = new Result();
        try {

                switch (moduleName) {
                    case "applicationarea":
                    case "declaretype":
                    case "departmentfund":
                    case "chenghao":
                    case "jijinlaiyuan":
                    case "hangye":
                    case "chanpinjieduan":
                    case "shengchanjieduan":
                    case "suoahulingyu":
                    case "jishulaiyuan":
                    case "zhuanhuafuwu":
                        deleteInf_interface.deleteInf(moduleName, informationId);
                        result.setStatus(100);
                        result.setMsg("Success");
                        log.info(logText + "删除操作成功。●");
                    default:
                        result.setStatus(400);
                        result.setMsg("Wrong！");
                        log.warn(logText + "★传入的模块名错误，可能存在非本系统调用后台接口，系统维护人员应注意此种情况！★");
                        break;
                }
            }
        catch(Exception e){
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
}



