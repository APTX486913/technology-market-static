package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Chengguoxinxi;
import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Bean.Shebeixinxi;
import com.wulianwang.technology_markets.Bean.Shiyanxinxi;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Shebeixinxi_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Shiyanxinxi_Interface;
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

@Api(value = "实验相关信息接口", description = "实验相关信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ShiyanxinxiController {
    @Autowired
    private Shiyanxinxi_Interface shiyanxinxi_interface;
    @Autowired
    private Shebeixinxi_Interface shebeixinxi_interface;
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
            @ApiImplicitParam(name = "identity", value = "设备编号(shebei_number)", required = true, dataType = "String", paramType = "String")
})
    @RequestMapping(value = "/shiyanxinxi", method = RequestMethod.POST)
    public Result shiyanxinxi(
            @Param("idetity") String identity

    ) {
        String logText = "●请求根据id获取实验信息，是否获取全部.";
        Result result = new Result();


        try {
            List<Shiyanxinxi> shiyanxinxiList = new ArrayList<>(shiyanxinxi_interface.shiyanxinxi(identity));
            if (shiyanxinxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(shiyanxinxiList);
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "identity", value = "设备名称（所属单位organization_id）", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/shebeixinxi", method = RequestMethod.POST)
    public Result shebeixinxi(
            @Param("identity") int identity,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求根据学校id获取设备信息（所属单位organization_id）：" + identity + "，页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Shebeixinxi> shebeixinxiList = new ArrayList<>(shebeixinxi_interface.shebeixinxi(identity, start_subscript, pagesize));
            if (shebeixinxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(shebeixinxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无设备信息或信息不足●");
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

