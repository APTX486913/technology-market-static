package com.wulianwang.technology_markets.Controller.Api;

import com.wulianwang.technology_markets.Bean.*;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.TongzhineirongDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.*;
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

@Api(value = "公共服务接口", description = "公共服务接口")
@Slf4j
@RestController
@RequestMapping(value = "/api")
public class PublicUseController {
    @Autowired
    private Suoshudanwei_Interface suoshudanwei_interface;
    @Autowired
    private Download_Interface download_interface;
    @Autowired
    private  Downloadfile_Interface downloadfile_interface;
    @Autowired
    private  Tongzhiliebiao_Interface tongzhiliebiao_interface;
    @Autowired
    private Tongzhineirong_Interface tongzhineirong_interface;
    @Autowired
    private UpdateVisitsInterface updateVisitsInterface;
    @ApiOperation(
            value = "更新访问量接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据更新成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @RequestMapping(value = "/updateVisits", method = RequestMethod.POST)
    public Result updateVisits(
    ) {
        Result result = new Result();
        try {
            updateVisitsInterface.updateVisits();
            result.setStatus(100);
            result.setMsg("success");
            log.info("更新成功●");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("★操作出现异常！★");
        }
        return result;
    }

    @ApiOperation(
            value = "获取访问量接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
    )
    @RequestMapping(value = "/getVisits", method = RequestMethod.POST)
    public Result getVisits(
    ) {
        Result result = new Result();
        try {
            int visits = updateVisitsInterface.getVisits();
            result.setStatus(100);
            result.setMsg("success");
            result.setValue(visits);
            log.info("获取成功●");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(601);
            result.setMsg("Error!");
            log.error("★操作出现异常！★");
        }
        return result;
    }


    @ApiOperation(
            value = "获取所属单位信息接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "所属单位ID：\" identity \"\n\n" +
                    "高校名称：\"name \"\n\n" +
                    "所属机构ID：\"organization_id \"\n\n" +
                    "机构级别：\"level\" \n\n" +
                    "机构类别：\"type \" \n\n"+
                    "学校图片：\"photo \" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "getall", value = "是否获取全部单位信息（获取全部：1；分页获取：0）", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/suoshudanwei", method = RequestMethod.POST)
    public Result suoshudanwei(
            @Param("getall") int getall,
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求获取所属单位信息，是否获取全部：" + getall + "，页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Suoshudanwei> suoshudanweiList = new ArrayList<>(suoshudanwei_interface.suoshudanwei(getall, start_subscript, pagesize));
            if (suoshudanweiList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(suoshudanweiList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无所属单位信息或信息不足●");
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
            value = "获取下载内容列表接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "下载内容列表ID：\" id\"\n\n" +
                    "下载内容标题：\"download_title \"\n\n" +
                    "下载内容内容：\"download_content \"\n\n" +
                    "下载内容链接：\"download_link\" \n\n" +
                    "下载内容发布时间：\"release_time \" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public Result download(
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求获取下载内容列表页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Download> downloadList = new ArrayList<>(download_interface.download(start_subscript, pagesize));
            if (downloadList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(downloadList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无下载内容列表信息或信息不足●");
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
            @ApiImplicitParam(name = "file_id", value = "文件ID（下载内容列表id)", required = true, dataType = "int", paramType = "int"),
    })
    @RequestMapping(value = "/downloadfile", method = RequestMethod.POST)
    public Result downloadfile(

            @Param("file_id") int file_id
    ) {
        String logText = "●请求获取ID：" + file_id + "。";
        Result result = new Result();
        try {
            List<Downloadfile> downloadfileList = new ArrayList<>(downloadfile_interface.downloadfile(file_id));
            if (downloadfileList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(downloadfileList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无下载文件信息或信息不足●");
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
            value = "获取通知列表接口",
            notes = "1.返回值状态（status）\n\n" +
                    "100：数据获取成功；\n\n" +
                    "200：未找到数据；\n\n" +
                    "300：理论上不可能，如果出现请及时联系后台人员；\n\n" +
                    "601：数据异常（可能为数据库错误或用户输入类型错误）\n\n"
                    + "2.返回值value数组：\n\n" +
                    "通知ID：\" id\"\n\n" +
                    "通知标题：\"headline \"\n\n" +
                    "通知内容：\"content \"\n\n" +
                    "通知发布时间：\"release_time \" \n\n"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Int", paramType = "Int"),
            @ApiImplicitParam(name = "pagesize", value = "获取数据条目数", required = true, dataType = "Int", paramType = "Int"),
    })
    @RequestMapping(value = "/tongzhiliebiao", method = RequestMethod.POST)
    public Result tongzhiliebiao(
            @Param("page") int page,
            @Param("pagesize") int pagesize
    ) {
        String logText = "●请求获取通知列表页码为：" + page + " 获取数据条目数：" + pagesize + "。";
        Result result = new Result();

        //将页码page转换为起始下标start_subscript
        int start_subscript = (page - 1) * pagesize;

        try {
            List<Tongzhiliebiao> tongzhiliebiaoList = new ArrayList<>(tongzhiliebiao_interface.tongzhiliebiao(start_subscript, pagesize));
            if (tongzhiliebiaoList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(tongzhiliebiaoList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无通知列表信息或信息不足●");
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
            @ApiImplicitParam(name = "notification_id", value = "获取通知ID(id)", required = true, dataType = "String", paramType = "String"),
    })
    @RequestMapping(value = "/tongzhineirong", method = RequestMethod.POST)
    public Result tongzhineirong(

            @Param("notification_id") String notification_id
    ) {
        String logText = "●请求获取通知ID(id)：" + notification_id + "。";
        Result result = new Result();
        try {
            List<Tongzhiliebiao> tongzhineirongList = new ArrayList<>(tongzhineirong_interface.tongzhineirong(notification_id));
            if (tongzhineirongList.size() > 0) {
                result.setStatus(100);
                result.setMsg("success");
                result.setValue(tongzhineirongList);
                log.info(logText + "获取成功●");
            } else {
                result.setStatus(200);
                result.setMsg("Not found");
                log.info(logText + "无通知内容信息或信息不足●");
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
