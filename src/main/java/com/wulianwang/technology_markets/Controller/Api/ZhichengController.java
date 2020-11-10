package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.Result;
import com.wulianwang.technology_markets.Bean.Zhicheng;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Zhicheng_Interface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "职称接口", description = "职称信息接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class ZhichengController {
    @Autowired
    private Zhicheng_Interface zhicheng_interface;
    @ApiOperation(
            value = "获取职称信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "职称id：\" id \"\n\n" +
                    "职称类型：\"type \"\n\n" +
                    "价值(1or0)：\"value \"\n\n"
    )
    @RequestMapping(value = "/zhicheng", method = RequestMethod.POST)
    public Result zhicheng() {
        String logText ="●请求获取职称信息。";
        Result result = new Result();
        try {
            List<Zhicheng> zhichengList = new ArrayList<>(zhicheng_interface.zhicheng());
            if (zhichengList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(zhichengList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无职称信息或信息不足●");
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

