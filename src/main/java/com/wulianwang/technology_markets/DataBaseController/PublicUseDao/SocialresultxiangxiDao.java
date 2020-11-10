package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Socialresult;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SocialresultxiangxiDao {
    @Select("Call getSocial_resultByid(#{identity})")
    @Results({
            @Result(property = "id", column = "ident", javaType = int.class),
            @Result(property = "result_type", column = "result_type", javaType = String.class),
            @Result(property = "category", column = "category", javaType = String.class),
            @Result(property = "result_name", column = "result_name", javaType = String.class),
            @Result(property = "result_award", column = "result_award", javaType = String.class),
            @Result(property = "result_benefit", column = "result_benefit", javaType = String.class),
            @Result(property = " result_accept", column = " result_accept", javaType = String.class),
            @Result(property = "application_area", column = "application_area", javaType = String.class),
            @Result(property = "affiliated_unit", column = "affiliated_unit", javaType = String.class),
            @Result(property = "use_unit", column = "use_unit", javaType = String.class),
            @Result(property = "use_time", column = "use_time", javaType = String.class),
            @Result(property = "result_intro", column = "result_intro", javaType = String.class),
            @Result(property = "accomplish_people", column = "accomplish_people", javaType = String.class),
            @Result(property = "contact_people", column = "contact_people", javaType = String.class),
            @Result(property = "contact_number", column = "contact_number", javaType = String.class),
            @Result(property = "E_mail", column = "E_mail", javaType = String.class),
            @Result(property = "mailing_address", column = "mailing_address", javaType = String.class),
            @Result(property = "postcode", column = "postcode", javaType = String.class)
    })
    List<Socialresult> getsocialresultxiangxi(@Param("identity") int identity);


}
