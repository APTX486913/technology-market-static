package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Xiaohangyetype;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface XiaohangyetypeDao {
    @Select("Call getIndustry(#{industry_big})")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "id", column = "ident", javaType = String.class),


            @Result(property = "type", column = "type", javaType = String.class),
            @Result(property = "value", column = "value", javaType = int.class)
    })
    List<Xiaohangyetype> getXiaohangyetype(@Param("industry_big") String industry_big);
}
