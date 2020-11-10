package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Socialbasexiangxi;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SocialbasexiangxiDao {
    @Select("Call getSocial_baseByid(#{identity})")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "id", column = "ident", javaType = int.class),
            @Result(property = "base_name", column = "base_name", javaType = String.class),
            @Result(property = "ratify_time", column = "ratify_time", javaType = String.class),
            @Result(property = "rely_unit", column = "rely_unit", javaType = String.class),
            @Result(property = "ratify_department", column = "ratify_department", javaType = String.class),
            @Result(property = "site", column = "site", javaType = String.class),
            @Result(property = "category", column = "category", javaType = String.class),
            @Result(property = "fuzeren_name", column = "fuzeren_name", javaType = String.class),
            @Result(property = "fuzuren_age", column = "fuzuren_age", javaType = int.class),
            @Result(property = "fuzeren_duty", column = "fuzeren_duty", javaType = String.class),
            @Result(property = "fuzeren_unit", column = "fuzeren_unit", javaType = String.class),
            @Result(property = "fuzeren_parttime_job", column = "fuzeren_parttime_job", javaType = String.class),
            @Result(property = "fuzeren_award", column = "fuzeren_award", javaType = String.class),
            @Result(property = "team_introduction", column = "team_introduction", javaType = String.class),
            @Result(property = "base_intro", column = "base_intro", javaType = String.class),
            @Result(property = "social_benefit", column = "social_benefit", javaType = String.class),
            @Result(property = "connect_people", column = "connect_people", javaType = String.class),
            @Result(property = "connect_number", column = "connect_number", javaType = String.class),
            @Result(property = "E_mail", column = "E_mail", javaType = String.class),
            @Result(property = "mailing_address", column = "mailing_address", javaType = String.class),
            @Result(property = "postcode", column = "postcode", javaType = String.class),
            @Result(property = "remark", column = "remark", javaType = String.class)
    })
    List<Socialbasexiangxi> getSocialbasexiangxi(@Param("identity") int identity);


}
