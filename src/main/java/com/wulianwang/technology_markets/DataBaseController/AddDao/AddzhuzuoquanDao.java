package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddzhuzuoquanDao {
    @Insert("Call addSoftware(#{copyright_number},#{ software_name},#{software_type},#{credential_number}," +
            "#{register_number},#{copyright_holder},#{power_way}" +
            "#{power_range},#{accomplish_date},#{publish_date}" +
            "#{ certificate_date},#{ linkman},#{contact_number},#{ E_mail}," +
            "#{mailing_address },#{postcode }"+
            "#{jing_shou_ren},#{register_date},#{review_sign},#{audit_result_xiao}," +
            "#{audit_result_ting},#{remarks},#{group_number},#{auditor_xiao},#{auditor_ting},#{tianbao_danwei_yuan},#{tianbao_danwei_xiao})")
    void addzhuzuoquan(@Param("copyright_number") String copyright_number, @Param("software_name")String software_name, @Param("software_type") String software_type,
                           @Param("credential_number") String credential_number, @Param("copyright_holder") String copyright_holder, @Param("power_way") String power_way,
                           @Param("power_range") String power_range, @Param("accomplish_date") String accomplish_date, @Param("publish_date") String publish_date,
                           @Param("certificate_date") String certificate_date, @Param("linkman") String linkman, @Param("contact_number") String contact_number,
                           @Param("E_mail") String E_mail, @Param("mailing_address") String mailing_address, @Param("accredit_invent") String accredit_invent,
                           @Param("accredit_practical") String accredit_practical, @Param("accredit_appearance") String accredit_appearance,
                           @Param("postcode") String postcode, @Param("jing_shou_ren") String jing_shou_ren,
                           @Param("register_date") String register_date, @Param("review_sign") int review_sign, @Param("audit_result_xiao") String audit_result_xiao,
                           @Param("audit_result_ting") String audit_result_ting, @Param("remarks") String remarks, @Param("group_number") String group_number,
                           @Param("auditor_xiao") String auditor_xiao, @Param("auditor_ting") String auditor_ting, @Param("tianbao_danwei_yuan") String tianbao_danwei_yuan,
                           @Param("tianbao_danwei_xiao") String tianbao_danwei_xiao
    );

}
