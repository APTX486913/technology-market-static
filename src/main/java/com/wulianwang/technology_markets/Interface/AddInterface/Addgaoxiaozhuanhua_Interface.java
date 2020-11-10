package com.wulianwang.technology_markets.Interface.AddInterface;

import org.apache.ibatis.annotations.Param;

public interface Addgaoxiaozhuanhua_Interface {
    void addgaoxiaozhuanhua(String projectnumber, String projectname, String reporting_unit, String transformation_time, String declare_project_type,  String person_in_charge,
                            String sex, int age,  String technical_titles,  String education_background, String contactphone_numeber,  String landline_numeber,  String field,
                           String project_source1,  String project_source2, String invention, String  utility_model, String appearance_design,  String authorized_department,
                            String authorized_time,  String award_satutaion,  String  project_phase, String project_introduction,  String conomicresources_instruction,
                           String market_situation, String key_technology_comparison, String economic_benefits,  String total_planned_investment,
                            String have_invested, String enterprise_investment , String institutions_loans, String school_investment,String goverment_support,
                           String other_funds, String funds_applied_amount,String project_date_start,  String project_date_end, String fund_instructions,
                           String project_plan_target, String jingshouren, String  registration_date, int approval_mark, String audit_results_school,
                            String udit_results_hall, String remark , String organization_id, String verifier_scchool,  String verifier_hall, String reporting_unit_court, String reporting_unit_school
    );
}
