package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchengguozhuanhuaDao;
import com.wulianwang.technology_markets.DataBaseController.AddDao.AddgaoxiaozhuanhuaDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addgaoxiaozhuanhua_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddgaoxiaozhuanhuaService implements Addgaoxiaozhuanhua_Interface {
    @Autowired
    private AddgaoxiaozhuanhuaDao addgaoxiaozhuanhuaDao;
    @Override
    public void addgaoxiaozhuanhua(String projectnumber, String projectname, String reporting_unit, String transformation_time, String declare_project_type,  String person_in_charge,
                              String sex, int age,  String technical_titles,  String education_background, String contactphone_numeber,  String landline_numeber,  String field,
                              String project_source1,  String project_source2, String invention, String  utility_model, String appearance_design,  String authorized_department,
                              String authorized_time,  String award_satutaion,  String  project_phase, String project_introduction,  String conomicresources_instruction,
                              String market_situation, String key_technology_comparison, String economic_benefits,  String total_planned_investment,
                              String have_invested, String enterprise_investment , String institutions_loans, String school_investment,String goverment_support,
                              String other_funds, String funds_applied_amount,String project_date_start,  String project_date_end, String fund_instructions,
                              String project_plan_target, String jingshouren, String  registration_date, int approval_mark, String audit_results_school,
                              String udit_results_hall, String remark , String organization_id, String verifier_scchool,  String verifier_hall, String reporting_unit_court, String reporting_unit_school
    ){
        addgaoxiaozhuanhuaDao.addgaoxiaozhuanhua( projectnumber, projectname,  reporting_unit,  transformation_time, declare_project_type,  person_in_charge,
                  sex, age,  technical_titles, education_background,  contactphone_numeber,  landline_numeber,  field,
                  project_source1,  project_source2, invention,  utility_model, appearance_design,  authorized_department,
                 authorized_time, award_satutaion,  project_phase, project_introduction, conomicresources_instruction,
                  market_situation,  key_technology_comparison, economic_benefits,  total_planned_investment,
                 have_invested, enterprise_investment ,  institutions_loans, school_investment, goverment_support,
                other_funds, funds_applied_amount, project_date_start, project_date_end, fund_instructions,
                 project_plan_target, jingshouren, registration_date, approval_mark,  audit_results_school,
                 udit_results_hall,  remark , organization_id, verifier_scchool, verifier_hall, reporting_unit_court,  reporting_unit_school);
    }
}
