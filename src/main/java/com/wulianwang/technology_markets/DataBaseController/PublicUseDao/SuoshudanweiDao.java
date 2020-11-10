package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Suoshudanwei;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SuoshudanweiDao {
    @Select("Call getOrganization(#{getall},#{start_subscript},#{pagesize})")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "identity", column = "ident", javaType = int.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "organization_id", column = "org_id", javaType = int.class),
            @Result(property = "level", column = "lel", javaType = int.class),
            @Result(property = "type", column = "type", javaType = int.class),
            @Result(property = "photo", column = "photo", javaType = String.class)
    })
    List<Suoshudanwei> getSuoshudanwei(@Param("getall") int getall, @Param("start_subscript") int start_subscript, @Param("pagesize") int pagesize);
}
