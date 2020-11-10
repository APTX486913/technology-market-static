package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Interface.Reset_Interface.RecomposePassword_Interface;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetAdminPermission_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "修改密码修改权限接口", description = "管理员修改密码权限")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ResetPasswordPermissionController {
    @Autowired
    private RecomposePassword_Interface recomposePassword_interface;
    @Autowired
    private ResetAdminPermission_Interface resetAdminPermission_interface;
    @ApiOperation(
            value = "管理员修改密码",
            notes = "1.返回值状态（status）\n\n" +
                    "100：修改成功；\n\n" +
                    "602：数据库或接口出现数据错误（此情况一般不会发生，若发生绝大多数情况为开发遗留bug）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "用户或管理员ID", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", required = true, dataType = "String", paramType = "String"),
    })
    @RequestMapping(value = "/recomposePassword", method = RequestMethod.POST)
    public Result recomposePassword(
            @RequestParam(value = "ident") int ident,
            @RequestParam(value = "newPwd", required = true) String newPwd
    ) {
        String logText = "●ID为：" + ident;
        Result result = new Result();


        int statusNum = recomposePassword_interface.recomposePassword(ident, newPwd);
        if (statusNum == 100) { //成功修改
            result.setStatus(100);
            result.setMsg("succeed");
            log.info(logText + "用户密码修改成功●");
        } else {
            result.setStatus(602);
            result.setMsg("Error.");
            log.error(logText + "★数据错误，修改密码失败，请联系开发人员修改bug。★");
        }
        return result;
    }
    @ApiOperation(
            value = "最高管理员修改其他管理员权限分级",
            notes = "1.返回值状态（status）\n\n" +
                    "100：权限修改成功；\n\n" +
                    "200：管理员授权码不正确；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "400：管理员无权限（不是最高管理员）；\n\n" +
                    "500：权限传入参数错误；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ident", value = "需修改的管理员ID", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "reperson_type_id", value = "修改的新权限分级", required = true, dataType = "Int", paramType = "Int")
    })
    @RequestMapping(value = "/resetAdminPermission", method = RequestMethod.POST)
    public Result resetAdminPermission(
            @RequestParam(value = "ident", required = true) int ident,
            @RequestParam(value = "reperson_type_id", required = true) int reperson_type_id
    ) {
        String logText = "管理员请求将管理员ID为：" + ident + "的管理员权限分级改为：" + reperson_type_id + "，";
        Result result = new Result();
        try {
             resetAdminPermission_interface.resetAdminPermission(ident, reperson_type_id);
             result.setStatus(100);
             result.setMsg("success");
             log.info(logText + "权限修改成功●");
        }catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error(logText + "★操作出现异常！★");
        }
        return result;
    }
}