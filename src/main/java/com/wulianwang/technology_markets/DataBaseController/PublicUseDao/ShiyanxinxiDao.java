package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Shiyanxinxi;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ShiyanxinxiDao {
    @Select("Call getExperimentalById(#{identity})")
    @Results({
            @Result(property = "shebei_number", column = "shebei_number", javaType = String.class),
            @Result(property = "shebei_name", column = "shebei_name", javaType = String.class),
            @Result(property = "keyword", column = "keyword", javaType = String.class),
            @Result(property = "production_unit", column = "production_unit", javaType = String.class),
            @Result(property = "start_time", column = "start_time", javaType = String.class),
            @Result(property = "service_life", column = "service_life", javaType = int.class),
            @Result(property = "price", column = "price", javaType = int.class),
            @Result(property = "introduction", column = "introduction", javaType = String.class),
            @Result(property = "quantity", column = "quantity", javaType = int.class),
            @Result(property = "purpose", column = "purpose", javaType = String.class),
            @Result(property = "picture", column = "picture", javaType = String.class),
            @Result(property = "linkman", column = "linkman", javaType = String.class),
            @Result(property = "contact_number", column = "contact_number", javaType = String.class),
            @Result(property = "E_mail", column = "E_mail", javaType = String.class),
            @Result(property = "mailing_address", column = "mailing_address", javaType = String.class),
            @Result(property = "postcode", column = "postcode", javaType = String.class),
            @Result(property = "jing_shou_ren", column = "jing_shou_ren", javaType = String.class),
            @Result(property = "register_date", column = "register_date", javaType = String.class),

            @Result(property = "review_sign", column = "review_sign", javaType = String.class),
            @Result(property = "audit_result_xiao", column = "audit_result_xiao", javaType = String.class),
            @Result(property = "audit_result_ting", column = "audit_result_ting", javaType = String.class),
            @Result(property = "remarks", column = "remarks", javaType = String.class),
            @Result(property = "group_number", column = "group_number", javaType = String.class),
            @Result(property = "auditor_xiao", column = "auditor_xiao", javaType = String.class),
            @Result(property = "auditor_ting", column = "auditor_ting", javaType = String.class),
            @Result(property = "tianbao_danwei_yuan", column = "tianbao_danwei_yuan", javaType = String.class),
            @Result(property = "tianbao_danwei_xiao", column = "tianbao_danwei_xiao", javaType = String.class),
    })
    List<Shiyanxinxi> getShiyanxinxi(@Param("identity") String identity);
}
