package com.wulianwang.technology_markets.DataBaseController.SearchDao;

import com.wulianwang.technology_markets.Bean.Xiangmuxinxi;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface SearchXiangmuxinxiDao {
    @Select("Call search('xiangmuxinxi',#{keywords})")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "project_number", column = "project_number", javaType = String.class),
            @Result(property = "project_name", column = "project_name", javaType = String.class),
            @Result(property = "project_type", column = "project_type", javaType = String.class),
            @Result(property = "contract_number", column = "contract_number", javaType = String.class),
            @Result(property = "person_in_charge", column = "person_in_charge", javaType = String.class),
            @Result(property = "start_time", column = "start_time", javaType = String.class),
            @Result(property = "end_time", column = "end_time", javaType = String.class),
            @Result(property = "contract_funding", column = "contract_funding", javaType = int.class),
            @Result(property = "project_level", column = "project_level", javaType = String.class),
            @Result(property = "service_industry", column = "service_industry", javaType = String.class),
            @Result(property = "undertaking_unit", column = "undertaking_unit", javaType = String.class),
            @Result(property = "canjiadanwei1", column = "canjiadanwei1", javaType = String.class),
            @Result(property = "canjiadanwei2", column = "canjiadanwei2", javaType = String.class),
            @Result(property = "project_state", column = "project_state", javaType = String.class),
            @Result(property = "content_abstract", column = "content_abstract", javaType = String.class),
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
            @Result(property = "comment", column = "comment", javaType = String.class),
            @Result(property = "organization_id", column = "organization_id", javaType = String.class),
            @Result(property = "verifier_scchool", column = "verifier_scchool", javaType = String.class),
            @Result(property = "verifier_hall", column = "verifier_hall", javaType = String.class),
            @Result(property = "reporting_unit_court", column = "reporting_unit_court", javaType = String.class),
            @Result(property = "reporting_unit_school", column = "reporting_unit_school", javaType = String.class),
    })
    List<Xiangmuxinxi> searchXiangmuxinxi(@Param("keywords") String keywords);


}
