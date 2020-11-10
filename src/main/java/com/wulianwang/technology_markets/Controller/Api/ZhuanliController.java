package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Typezhuanli_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Zhuanlixiangxi_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Zhuanlixinxi_Interface;
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

@Api(value = "专利接口", description = "专利相关信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ZhuanliController {
    @Autowired
    private Zhuanlixinxi_Interface zhuanlixinxi_interface;
    @Autowired
    private Zhuanlixiangxi_Interface zhuanlixiangxi_interface;
    @Autowired
    private Typezhuanli_Interface typezhuanli_interface;
    @ApiOperation(
            value = "根据id获取专利信息接口",
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
            @ApiImplicitParam(name = "identity", value = "专利名（organization_id)", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/zhuanlixinxi", method = RequestMethod.POST)
    public Result zhuanlixinxi(
            @Param("identity") int identity,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求根据学校id获取专利信息名称：" + identity + "，页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Zhuanlixinxi> zhuanlixinxiList = new ArrayList<>(zhuanlixinxi_interface.zhuanlixinxi(identity, start_subscript, pagesize));
            if (zhuanlixinxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(zhuanlixinxiList);
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "identity", value = "专利编号(serial_number)", required = true, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/zhuanlixiangxi", method = RequestMethod.POST)
    public Result zhuanlixiangxi(
            @Param("identity") String identity
    ) {
        String logText = "●请求获取专利详细信息(专利名称)：" + identity  + "。";
        Result result = new Result();
        try {
            List<Zhuanlixiangxi> zhuanlixiangxiList = new ArrayList<>(zhuanlixiangxi_interface.zhuanlixiangxi(identity));
            if (zhuanlixiangxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(zhuanlixiangxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无专利详细信息或信息不足●");
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
            value = "获取专利类型接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "专利类型id：\" id \"\n\n" +
                    "专利类型名称：\"patent_type_name \"\n\n" +
                    "价值：\"value \"\n\n"
    )
    @RequestMapping(value = "/typezhuanli", method = RequestMethod.POST)
    public Result typezhuanli() {
        String logText ="●请求获取专利类型。";
        Result result = new Result();
        try {
            List<Typezhuanli> typezhuanliList = new ArrayList<>(typezhuanli_interface.gettyppezhuanli());
            if (typezhuanliList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(typezhuanliList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无专利类型信息或信息不足●");
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
