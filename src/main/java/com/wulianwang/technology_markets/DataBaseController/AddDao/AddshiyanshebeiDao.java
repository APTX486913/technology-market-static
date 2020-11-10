package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddshiyanshebeiDao {
    @Insert("Call addExper(#{shebei_number},#{ shebei_name},#{keyword},#{production_unit}," +
            "#{start_time},#{service_life},#{price},#{ introduction},#{ quantity}" +
            "#{ purpose},#{ picture},#{ linkman},#{ contact_number}," +
            "#{ E_mail},#{ mailing_address},#{ postcode},#{ jing_shou_ren}," +
            "#{register_date},#{review_sign},#{audit_result_xiao},#{audit_result_ting}," +
            "#{remarks},#{ group_number},#{ auditor_xiao},#{ auditor_ting}," +
             "#{tianbao_danwei_yuan},#{tianbao_danwei_xiao})")
    void addshiyanshebei(@Param("shebei_number") String shebei_tnumber, @Param("shebei_name")String shebei_tname, @Param("keyword") String keyword,
                           @Param("production_unit") String production_unit, @Param("pstart_time") String start_time, @Param("service_life") String service_life,
                           @Param("price") String price , @Param("introduction") String introduction, @Param("quantity") int quantity,
                           @Param(" purpose") String  purpose, @Param("picture") String picture, @Param("linkman") String linkman,
                           @Param(" contact_number") String contact_number, @Param("E_mail") String E_mail, @Param("mailing_address") String mailing_address,
                           @Param("postcode") String postcode, @Param("jing_shou_ren") String jing_shou_ren, @Param("register_date") String register_date,
                           @Param("review_sign") int review_sign, @Param("audit_result_xiao") String audit_result_xiao, @Param("audit_result_xiao") String audit_result_ting,
                            @Param("remarks") String remarks, @Param("group_number") String group_number,
                           @Param("auditor_xiao") String auditor_xiao, @Param("auditor_ting") String auditor_ting, @Param("tianbao_danwei_yuan") String tianbao_danwei_yuan,
                           @Param("tianbao_danwei_xiao") String tianbao_danwei_xiao
    );
}
