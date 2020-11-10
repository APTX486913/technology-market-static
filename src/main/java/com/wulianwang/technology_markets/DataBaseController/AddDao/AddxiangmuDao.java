package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddxiangmuDao {
    @Insert("Call addHor_pro(#{project_number},#{ project_name},#{project_type},#{contract_number}," +
            "#{person_in_charge},#{start_time},#{end_time},#{contract_funding},#{project_level}" +
            "#{ service_industry},#{ undertaking_unit},#{canjiadanwei1},#{ canjiadanwei2}," +
            "#{ project_state},#{content_abstract },#{contact },#{ contact_phone_number}," +
            "#{ e_mail },#{communication_address},#{postal_code},#{jingnshouren}," +
            "#{ registration_data},#{approval_mark},#{ audit_results_school},#{ audit_results_hall}," +
            "#{ reporting_unit_court},#{ reporting_unit_hall})")
    void addxiangmu(@Param("project_number") String project_number, @Param("project_name")String project_name, @Param("project_type") String project_type,
                           @Param("contract_number") String contract_number, @Param("person_in_charge") String person_in_charge, @Param("start_time") String start_time,
                           @Param("end_time") String end_time, @Param("contract_funding") String contract_funding, @Param("project_level") String project_level,
                           @Param("service_industry") String service_industry, @Param(" undertaking_unit") String  undertaking_unit, @Param("canjiadanwei1") String canjiadanwei1,
                           @Param("canjiadanwei2") String canjiadanwei2, @Param("project_state") String project_state, @Param(" content_abstract") String  content_abstract,
                           @Param("contact ") String contact, @Param(" contact_phone_number") String contact_phone_number, @Param("e_mail") String e_mail,
                           @Param(" communication_address") String communication_address, @Param("postal_code") String postal_code, @Param("jingshouren") String jingshouren,
                           @Param("registration_data")String registration_data, @Param(" approval_mark") int approval_mark, @Param("audit_results_school") String audit_results_school,
                           @Param("audit_results_hall") String audit_results_hall, @Param("comment")String comment, @Param("organization_id") String organization_id,
                           @Param("verifier_scchool") String verifier_scchool, @Param("verifier_hall") String verifier_hall, @Param("reporting_unit_court") String reporting_unit_court,
                           @Param("reporting_unit_school") String reporting_unit_school
    );

}
