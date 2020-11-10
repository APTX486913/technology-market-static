package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AddchuangxinpingtaiDao {
    @Insert("Call addInnova_plat(#{platform_number},#{address},#{person_in_charge }" +
            "#{classification},#{attached_unit},#{ approval_unit}" +
            "#{establishment_time},#{industry_1},#{industry_2 }" +
            "#{unit_introduction},#{unit_homepage},#{ contact}" +
            "#{contact_phone_number},#{e_mail},#{ postal_code}" +
            "#{jingshouren},#{registration_data},#{ approval_mark}" +
            "#{audit_results_school},#{audit_results_hall},#{ remark}" +
            "#{organization_id},#{verifier_school},#{ verifier_hall}" + "#{ reporting_unit_court},#{ reporting_unit_school)")
    void addchuangxinpingtai(@Param("platform_number") String platform_number, @Param("address") String address, @Param("person_in_charge") String person_in_charge,
                             @Param("classification") String classification, @Param("attached_unit") String attached_unit, @Param("approval_unit") String approval_unit,
                             @Param("establishment_time") String establishment_time, @Param("industry_1") String industry_1, @Param("industry_2") String industry_2,
                             @Param("unit_introduction") String unit_introduction, @Param("unit_homepage") String unit_homepage, @Param("contact") String contact,
                             @Param("contact_phone_number") String contact_phone_number, @Param("e_mail") String e_mail, @Param("postal_code") String postal_code,
                             @Param("jingshouren") String jingshouren, @Param("registration_data") String registration_data, @Param("approval_mark") int approval_mark,
                             @Param("audit_results_school") String audit_results_school, @Param("audit_results_hall") String audit_results_hall, @Param("remark") String remark,
                             @Param("organization_id") String organization_id, @Param("verifier_school") String verifier_scchool, @Param("verifier_hall") String verifier_hall,
                             @Param("reporting_unit_court") String reporting_unit_court, @Param("reporting_unit_school") String reporting_unit_school);
}