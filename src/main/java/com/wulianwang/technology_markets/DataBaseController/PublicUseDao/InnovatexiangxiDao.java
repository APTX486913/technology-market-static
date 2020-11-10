package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Innovatexiangxi;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InnovatexiangxiDao {
    @Select("Call getInnovation_platormById(#{identity})")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "platform_number", column = "platform_number", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "address", column = "address", javaType = String.class),
            @Result(property = "person_in_charge", column = "person_in_charge", javaType = String.class),
            @Result(property = "platform_classification", column = "platform_classification", javaType = String.class),
            @Result(property = "attached_unit", column = "attached_unit", javaType = String.class),
            @Result(property = "approval_unit", column = "approval_unit", javaType = String.class),
            @Result(property = "establishment_time", column = "establishment_time", javaType = String.class),
            @Result(property = "industry_1", column = "industry_1", javaType = String.class),
            @Result(property = "industry_2", column = "industry_2", javaType = String.class),
            @Result(property = "unit_introduction", column = "unit_introduction", javaType = String.class),
            @Result(property = "unit_homepage", column = "unit_homepage", javaType = String.class),
            @Result(property = "contact", column = "contact", javaType = String.class),
            @Result(property = "contact_phone_number", column = "contact_phone_number", javaType = String.class),
            @Result(property = "e_mail", column = "e_mail", javaType = String.class),
            @Result(property = "postal_code", column = "postal_code", javaType = String.class),
            @Result(property = "jingshouren", column = "jingshouren", javaType = String.class),
            @Result(property = "registration_data", column = "registration_data", javaType = String.class),
            @Result(property = "approval_mark", column = "approval_mark", javaType = int.class),
            @Result(property = "audit_results_school", column = "audit_results_school", javaType = String.class),
            @Result(property = "audit_results_hall", column = "audit_results_hall", javaType = String.class),
            @Result(property = "remark", column = "remark", javaType = String.class),
            @Result(property = "organization_id", column = "organization_id", javaType = String.class),
            @Result(property = "verifier_scchool", column = "verifier_scchool", javaType = String.class),
            @Result(property = "verifier_hall", column = "verifier_hall", javaType = String.class),
            @Result(property = "reporting_unit_court", column = "reporting_unit_court", javaType = String.class),
            @Result(property = "reporting_unit_school", column = "reporting_unit_school", javaType = String.class),
    })
    List<Innovatexiangxi> getInnovatexiangxi(@Param("identity") String identity);
}
