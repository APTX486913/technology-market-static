package com.wulianwang.technology_markets.DataBaseController.ResetDao;

import org.apache.ibatis.annotations.*;

@Mapper
public interface RecomposePasswordDao {
    @Select("CALL recomposePassword(#{ident},#{pwd});")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(column = "statusNum", javaType = int.class)
    })

    int recomposePassword(@Param("ident") int ident, @Param("pwd") String pwd);
}
