package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Comrequire;
import com.wulianwang.technology_markets.Bean.Comxxrequire;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ComxxrequireDao {
    @Select("Call getCompany_requirementById(#{identity})")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "id", column = "identity", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "content", column = "content", javaType = String.class),
            @Result(property = "e_id", column = "e_id", javaType = String.class),
            @Result(property = "date", column = "date", javaType = String.class),
            @Result(property = "status", column = "status", javaType = int.class),
            @Result(property = "type", column = "type", javaType = String.class)
    })
    List<Comxxrequire> getComxxrequire(@Param("identity") String identity);
}
