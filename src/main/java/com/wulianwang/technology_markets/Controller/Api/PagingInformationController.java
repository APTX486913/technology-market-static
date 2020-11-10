package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Count;
import com.wulianwang.technology_markets.Bean.PagingInformation;
import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.CountItems_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Countrequire_Interface;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Countsuoshu_Interface;
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

@Api(value = "获取分页信息", description = "获取分页信息")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class PagingInformationController {
    @Autowired
    private CountItems_Interface countItems_interface;
    @Autowired
    private Countrequire_Interface countrequire_interface;
    @Autowired
    private Countsuoshu_Interface countsuoshu_interface;
    @ApiOperation(
            value = "获取各模块分页信息",
            notes = "1.返回值状态（status）\n\n" +
                    "100：信息获取成功；\n\n" +
                    "200：发送的模块参数值错误，需要前端人员检查拼写错误；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "单页条目数量（单页大小）：\"pageSize\"\n\n" +
                    "数据库总条目数：\"totalElements\"\n\n" +
                    "总页数：\"totalPages\"\n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "moduleName", value = "请求模块名称，具体参数值为：\n\n" +
                    "成果信息：chengguoxinxi\n\n" +
                    "项目信息：xiangmuxinxi\n\n" +
                    "专家信息：zhuanjiaxinxi\n\n" +
                    "专利信息：zhuanlixinxi\n\n" +
                    "设备信息：sheibeixinxi\n\n" +
                    "平台信息：pingtaixinxi\n\n"+
                    "人文社科：renwensheke\n\n" +
                    "人文基地：renwenjidi\n\n" +"企业需求：qiyexuqiu\n\n" , required = true, dataType = "String", paramType = "String"),
            @ApiImplicitParam(name = "pageSize", value = "单页条目数量", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "org_id", value = "学校organization_id", required = true, dataType = "Int", paramType = "Int")
    })
    @RequestMapping(value = "/getPagingInformation", method = RequestMethod.POST)
    public Result getPagingInformation(
            @RequestParam(value = "moduleName", required = true) String moduleName,
            @RequestParam(value = "pageSize", required = true) int pageSize,
            @RequestParam(value = "org_id", required = true) int org_id
    ) {
        String logText = "●获取" + moduleName + "模块分页信息，单页条目数量（pageSize）：" + pageSize +"学校organization_id：" + org_id +"，";

        Result result = new Result();
        PagingInformation pagingInformation = new PagingInformation();
        Count itemsNumber = null;
        int beichushu, shang, yushu; //被除数、商和余数

        try {
            switch (moduleName) {
                case "chengguoxinxi":
                case "xiangmuxinxi":
                case "zhuanjiaxinxi":
                case "zhuanlixinxi":
                case "sheibeixinxi":
                case "pingtaixinxi":
                case "renwensheke":
                case "renwenjidi":
                    itemsNumber = countItems_interface.countItems(moduleName,org_id);

                    pagingInformation.setTotalElements(itemsNumber.getCountResult());
                    pagingInformation.setPageSize(pageSize);

                    beichushu = itemsNumber.getCountResult();
                    shang = (int) beichushu / pageSize;
                    yushu = beichushu % pageSize;
                    if (yushu == 0) {
                        pagingInformation.setTotalPages(shang);
                    } else {
                        pagingInformation.setTotalPages(shang + 1);
                    }

                    result.setStatus(100);
                    result.setMsg("The paging information is ...");
                    result.setValue(pagingInformation);
                    log.info(logText + "信息获取成功●");
                    break;
                case "qiyexuqiu":
                    itemsNumber = countrequire_interface.countrequire();

                    pagingInformation.setTotalElements(itemsNumber.getCountResult());
                    pagingInformation.setPageSize(pageSize);

                    beichushu = itemsNumber.getCountResult();
                    shang = (int) beichushu / pageSize;
                    yushu = beichushu % pageSize;
                    if (yushu == 0) {
                        pagingInformation.setTotalPages(shang);
                    } else {
                        pagingInformation.setTotalPages(shang + 1);
                    }

                    result.setStatus(100);
                    result.setMsg("The paging information is ...");
                    result.setValue(pagingInformation);
                    log.info(logText + "信息获取成功●");
                    break;
                case "suoshudanwei":
                    itemsNumber = countsuoshu_interface.countsuoshu();

                    pagingInformation.setTotalElements(itemsNumber.getCountResult());
                    pagingInformation.setPageSize(pageSize);

                    beichushu = itemsNumber.getCountResult();
                    shang = (int) beichushu / pageSize;
                    yushu = beichushu % pageSize;
                    if (yushu == 0) {
                        pagingInformation.setTotalPages(shang);
                    } else {
                        pagingInformation.setTotalPages(shang + 1);
                    }

                    result.setStatus(100);
                    result.setMsg("The paging information is ...");
                    result.setValue(pagingInformation);
                    log.info(logText + "信息获取成功●");
                    break;
                default:
                    result.setStatus(200);
                    result.setMsg("Wrong!");
                    log.warn(logText + "★警告！可能有人试图从接口获取数据★");
                    break;
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
