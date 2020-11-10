package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Comrequire;
import com.wulianwang.technology_markets.Bean.Suoshudanwei;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface ComrequireDao {
    @Select("Call getCompany_requirement(#{start_subscript},#{pagesize})")
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
    List<Comrequire> getComrequire(@Param("start_subscript") int start_subscript, @Param("pagesize") int pagesize);


}
