package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddchengguoxinxiDao {
    @Insert("Call addResult(#{Identification_number},#{results_type},#{results_name }" +
            "#{application_field},#{subordinate_units},#{ finish_time}" +
            "#{evaluation_way_level},#{evaluation_date},#{evaluation_institution }" +
            "#{result_id},#{result_summary},#{ wanchengren}" +
            "#{converted_or_not},#{contact},#{ contact_phone_number}" +
            "#{e_mail},#{communication_address},#{ postal_code}" +
            "#{jingshouren},#{registration_data},#{ approval_mark}" +
            "#{audit_results_school},#{audit_results_hall},#{ comment}" +
            "#{organization_id},#{verifier_school},#{ verifier_hall}" + "#{ reporting_unit_court},#{ reporting_unit_school)")
    void addchengguoxinxi(@Param("Identification_number") String Identification_number, @Param("results_type") String results_type, @Param("results_name") String results_name,
                             @Param("application_field") String application_field, @Param("subordinate_units") String subordinate_units, @Param("finish_time") String finish_time,
                             @Param("evaluation_way_level") String evaluation_way_level, @Param("evaluation_date") String evaluation_date, @Param("evaluation_institution") String evaluation_institution,
                             @Param("result_id") String result_id, @Param("result_summary") String result_summary, @Param("wanchengren") String wanchengren,
                             @Param("converted_or_not") String converted_or_not, @Param("contact") String contact, @Param("contact_phone_number") String contact_phone_number,
                             @Param("e_mail") String e_mail, @Param("communication_address") String communication_address, @Param("postal_code")String postal_code,
                             @Param("jingshouren") String jingshouren, @Param("registration_data") String registration_data, @Param("approval_mark")int approval_mark,
                             @Param("audit_results_school") String audit_results_school, @Param("audit_results_hall") String audit_results_hall, @Param("comment") String comment,
                             @Param("organization_id") String organization_id, @Param("verifier_school") String verifier_scchool, @Param("verifier_hall") String verifier_hall,
                             @Param("reporting_unit_court") String reporting_unit_court, @Param("reporting_unit_school") String reporting_unit_school);
}
