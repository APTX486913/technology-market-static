package com.wulianwang.technology_markets.DataBaseController.AddDao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface AddgaoxiaozhuanhuaDao {
    @Insert("Call addAchtran_rech(#{project_number},#{ project_name},#{reporting_unit},#{transformation_time}," +
            "#{declare_project_type},#{person_in_charge},#{sex},#{age},#{technical_titles }" +
            "#{ education_background},#{ contactphone_numeber},#{ landline_numeber},#{ field}," +
            "#{project_source1 },#{project_source2 },#{invention},#{ utility_model}," +
            "#{appearance_design},#{authorized_department},#{authorized_time},#{award_satutaion}," +
            "#{ project_phase},#{ project_introduction},#{ conomicresources_instruction},#{market_situation }," +
            "#{key_technology_comparison},#{economic_benefits},#{total_planned_investment},#{have_invested}," +
            "#{enterprise_investment},#{ institutions_loans},#{ school_investment},#{goverment_support },#{ other_funds},#{ funds_applied_amount},#{project_date_start}" +
            "#{project_date_end},#{fund_instructions},#{ project_plan_target},#{jingshouren },#{ registration_date},#{ approval_mark},#{ audit_results_school},#{ audit_results_hall}," +
            "#{ remark },#{ organization_id},#{ verifier_scchool},#{ verifier_hall}" +
            "#{ reporting_unit_court },#{ reporting_unit_school})")
    void addgaoxiaozhuanhua(@Param("project_number") String projectnumber,@Param("project_name")String projectname, @Param("reporting_unit") String reporting_unit,
                           @Param("transformation_time") String transformation_time,@Param("declare_project_type") String declare_project_type, @Param("person_in_charge") String person_in_charge,
                           @Param("sex") String sex,@Param("age") int age,@Param("technical_titles") String technical_titles, @Param("education_background") String education_background,
                           @Param("contactphone_numeber") String contactphone_numeber,@Param("landline_numeber") String landline_numeber, @Param("field") String field,
                           @Param("project_source1 ") String project_source1,@Param("project_source2") String project_source2, @Param("invention") String invention,
                           @Param(" utility_model") String  utility_model,@Param("appearance_design") String appearance_design, @Param("authorized_department") String authorized_department,
                           @Param("authorized_time") String authorized_time,@Param("award_satutaion") String award_satutaion, @Param(" project_phase") String  project_phase,
                           @Param("project_introduction")String project_introduction,@Param("conomicresources_instruction") String conomicresources_instruction, @Param("market_situation") String market_situation,
                           @Param("key_technology_comparison") String key_technology_comparison,@Param("economic_benefits")String economic_benefits, @Param("total_planned_investment") String total_planned_investment,
                           @Param("have_invested") String have_invested,@Param("enterprise_investment") String enterprise_investment , @Param("institutions_loans") String institutions_loans,
                           @Param("school_investment") String school_investment,@Param("goverment_support") String goverment_support, @Param("other_funds") String other_funds,
                           @Param("funds_applied_amount") String funds_applied_amount,@Param("project_date_start") String project_date_start, @Param("project_date_end") String project_date_end,
                           @Param("fund_instructions") String fund_instructions,@Param("project_plan_target") String project_plan_target, @Param("jingshouren") String jingshouren,
                           @Param(" registration_date") String  registration_date,@Param("approval_mark") int approval_mark, @Param("audit_results_school") String audit_results_school,
                           @Param("audit_results_hall") String udit_results_hall,@Param("remark ") String remark , @Param("organization_id") String organization_id,
                           @Param("verifier_scchool ") String verifier_scchool, @Param("verifier_hall") String verifier_hall, @Param("reporting_unit_court") String reporting_unit_court,@Param("reporting_unit_school")String reporting_unit_school
    );
}
