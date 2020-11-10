package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchanyehuaDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addchanyehua_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddchanyehuaService implements Addchanyehua_Interface {
    @Autowired
    private AddchanyehuaDao addchanyehuaDao;
    @Override
    public void addChanyehuaxinxi( String projectnumber, String projectname,  String tianbaodanwei,
                            String conversion_time,  String project_manager, String gender,
                            int age, String technologytitle, String educationbackground,
                            String landline_phone,  String contact_number,  String field,
                            String plan_source,  String technology_source, String accredit_invent,
                            String accredit_practical,  String accredit_appearance, String check_department,
                            String acceptance_time, String awards,String stage, String introduction,
                            String explain, String market_analysis, String product_comparison,
                            String benefit_forecast, String jing_shou_ren, String register_date,
                            int review_sign, String audit_result_xiao, String audit_result_ting,
                            String remarks,  String group_number, String auditor_xiao,
                            String auditor_ting, String tianbao_danwei_yuan, String tianbao_danwei_xiao,String biaozhi){
        addchanyehuaDao.addChanyehuaxinxi( projectnumber, projectname, tianbaodanwei, conversion_time, project_manager, gender,
         age,  technologytitle,  educationbackground, landline_phone,contact_number, field, plan_source, technology_source, accredit_invent,
                 accredit_practical, accredit_appearance, check_department,
                 acceptance_time, awards,stage, introduction,
                 explain,   market_analysis,  product_comparison,
                 benefit_forecast,  jing_shou_ren, register_date,
         review_sign,  audit_result_xiao,  audit_result_ting,
                remarks,  group_number, auditor_xiao,
                 auditor_ting, tianbao_danwei_yuan,  tianbao_danwei_xiao, biaozhi);

    }
}
