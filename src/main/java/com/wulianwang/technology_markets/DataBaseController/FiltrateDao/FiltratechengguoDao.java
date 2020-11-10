package com.wulianwang.technology_markets.DataBaseController.FiltrateDao;

import com.wulianwang.technology_markets.Bean.Chengguoxinxi;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface FiltratechengguoDao {
    @Select("Call filtrategetResult(#{results_TypeId},#{organizationId},#{ evaluate_levelId},#{start_subscript},#{pagesize})")
    @Results(id = "chengguo",value = {
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "Identification_number", column = "Identification_number", javaType = String.class),
            @Result(property = "results_type", column = "results_type", javaType = String.class),
            @Result(property = "results_name", column = "results_name", javaType = String.class),
            @Result(property = "application_field", column = "appl_field", javaType = String.class),
            @Result(property = "subordinate_units", column = "sub_units", javaType = String.class),
            @Result(property = "finish_time", column = "finish_time", javaType = String.class),
            @Result(property = "evaluation_way_level", column = "eval_way_level", javaType = String.class),
            @Result(property = "evaluation_date", column = "eval_date", javaType = String.class),
            @Result(property = "evaluation_institution", column = "eval_institution", javaType = String.class),
            @Result(property = "result_id", column = "result_id", javaType = String.class),
            @Result(property = "result_summary", column = "result_summary", javaType = String.class),
            @Result(property = "wanchengren", column = "wanchengren", javaType = String.class),
            @Result(property = "converted_or_not", column = "converted_or_not", javaType = String.class),
            @Result(property = "contact", column = "contact", javaType = String.class),
            @Result(property = "contact_phone_number", column = "contact_phone_number", javaType = String.class),
            @Result(property = "e_mail", column = "e_mail", javaType = String.class),
            @Result(property = "communication_address", column = "communication_address", javaType = String.class),
            @Result(property = "postal_code", column = "postal_code", javaType = String.class),
            @Result(property = "jingshouren", column = "jingshouren", javaType = String.class),
            @Result(property = "registration_data", column = "registration_data", javaType = String.class),
            @Result(property = "approval_mark", column = "approval_mark", javaType = int.class),
            @Result(property = "audit_results_school", column = "audit_results_school", javaType = String.class),
            @Result(property = "audit_results_hall", column = "audit_results_hall", javaType = String.class),
            @Result(property = "comment", column = "comt", javaType = String.class),
            @Result(property = "organization_id", column = "organization_id", javaType = String.class),
            @Result(property = "verifier_scchool", column = "verifier_scchool", javaType = String.class),
            @Result(property = "verifier_hall", column = "verifier_hall", javaType = String.class),
            @Result(property = "reporting_unit_court", column = "reporting_unit_court", javaType = String.class),
            @Result(property = "reporting_unit_school", column = "reporting_unit_school", javaType = String.class)
    })
    List<Chengguoxinxi> filtrateChengguo(@Param("result_TypeId") String result_TypeId, @Param("organizaztionId") int organizationId, @Param("evaluate_levelId") String evaluate_levelId,
                                         @Param("start_subscript")int start_subscript,
                                         @Param("pagesize")int pagesize);
    @Select("Call filtrategetResultByTS(#{results_TypeId},#{school},#{start_subscript},#{pagesize})")
    @ResultMap("chengguo")
    List<Chengguoxinxi> filtrategetResultByTS(@Param("results_TypeId") String results_TypeId, @Param("school") String school,@Param("start_subscript")int start_subscript,
                                         @Param("pagesize")int pagesize);
}
