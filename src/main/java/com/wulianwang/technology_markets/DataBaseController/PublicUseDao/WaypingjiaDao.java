package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Jietipingjia;
import com.wulianwang.technology_markets.Bean.Waypingjia;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WaypingjiaDao {
    @Select("Call getEvaluate_way()")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "id", column = "ident", javaType = String.class),



            @Result(property = "type", column = "type", javaType = String.class),
            @Result(property = "value", column = "value", javaType = int.class),

    })
    List<Waypingjia> getWaypingjia();
}
