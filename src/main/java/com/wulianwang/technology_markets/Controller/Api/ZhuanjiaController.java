package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Bean.Zhuanjiaxiangxi;
import com.wulianwang.technology_markets.Bean.Zhuanjiaxinxi;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Zhuanjiaxiangxi_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Zhuanjiaxinxi_Interface;
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

@Api(value = "专家信息接口", description = "专家信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ZhuanjiaController {
    @Autowired
    private Zhuanjiaxinxi_Interface zhuanjiaxinxi_interface;
    @Autowired
    private Zhuanjiaxiangxi_Interface zhuanjiaxiangxi_interface;

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
            @ApiImplicitParam(name = "identity", value = "专家名（organization_id)", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/zhuanjiaxinxi", method = RequestMethod.POST)
    public Result zhuanjiaxinxi(
            @Param("identity") int identity,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求获取专家信息名称：" + identity + "，页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Zhuanjiaxinxi> zhuanjiaxinxiList = new ArrayList<>(zhuanjiaxinxi_interface.zhuanjiaxinxi(identity, start_subscript, pagesize));
            if (zhuanjiaxinxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(zhuanjiaxinxiList);
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

    @ApiImplicitParams({
            @ApiImplicitParam(name = "identity", value = "专家编号(professor_number)", required = true, dataType = "String", paramType = "String")
    })
    @RequestMapping(value = "/zhuanjiaxiangxi", method = RequestMethod.POST)
    public Result zhuanjiaxiangxi(
            @Param("identity") String identity
    ) {
        String logText = "●请求获取专家详细信息(专家编号)：" + identity  + "。";
        Result result = new Result();
        try {
            List<Zhuanjiaxiangxi> zhuanjiaxiangxiList = new ArrayList<>(zhuanjiaxiangxi_interface.zhuanjiaxiangxi(identity));
            if (zhuanjiaxiangxiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(zhuanjiaxiangxiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无专家详细信息或信息不足●");
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
