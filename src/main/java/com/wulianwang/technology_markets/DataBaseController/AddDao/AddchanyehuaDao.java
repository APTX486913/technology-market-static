package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddchanyehuaDao {
    @Insert("Call addAchindu(#{project_number},#{ project_name},#{tianbao_danwei},#{conversion_time}," +
            "#{project_manager},#{gender},#{age},#{technology_title},#{education_background}" +
            "#{ landline_phone},#{ field},#{plan_source},#{ technology_source}," +
            "#{accredit_invent },#{accredit_practical },#{accredit_appearance},#{ check_department}," +
            "#{acceptance_time},#{awards},#{stage},#{introduction}," +"#{ explain},#{market_analysis },#{product_comparison},#{benefit_forecast}," +
            "#{jing_shou_ren},#{register_date},#{review_sign},#{audit_result_xiao}," +
            "#{audit_result_ting},#{remarks},#{group_number},#{auditor_xiao},#{auditor_ting},#{tianbao_danwei_yuan},#{tianbao_danwei_xiao}，#{biaozhi})")
    void addChanyehuaxinxi(@Param("project_number") String projectnumber, @Param("project_name")String projectname, @Param("tianbao_danwei") String tianbaodanwei,
                           @Param("conversion_time") String conversion_time, @Param("project_manager") String project_manager, @Param("gender") String gender,
                           @Param("age") int age, @Param("technology_title") String technologytitle, @Param("education_background") String educationbackground,
                           @Param("landline_phone") String landline_phone, @Param("contact_number") String contact_number, @Param("field") String field,
                           @Param("plan_source") String plan_source, @Param("technology_source") String technology_source, @Param("accredit_invent") String accredit_invent,
                           @Param("accredit_practical") String accredit_practical, @Param("accredit_appearance") String accredit_appearance, @Param("check_department") String check_department,
                           @Param("acceptance_time") String acceptance_time, @Param("awards") String awards, @Param("stage") String stage,
                           @Param("introduction")String introduction, @Param("explain") String explain, @Param("market_analysis") String market_analysis,
                           @Param("product_comparison") String product_comparison, @Param("benefit_forecast")String benefit_forecast, @Param("jing_shou_ren") String jing_shou_ren,
                           @Param("register_date") String register_date, @Param("review_sign") int review_sign, @Param("audit_result_xiao") String audit_result_xiao,
                           @Param("audit_result_ting") String audit_result_ting, @Param("remarks") String remarks, @Param("group_number") String group_number,
                           @Param("auditor_xiao") String auditor_xiao, @Param("auditor_ting") String auditor_ting, @Param("tianbao_danwei_yuan") String tianbao_danwei_yuan,
                           @Param("tianbao_danwei_xiao") String tianbao_danwei_xiao,@Param("biaozhi") String biaozhi
    );


}
