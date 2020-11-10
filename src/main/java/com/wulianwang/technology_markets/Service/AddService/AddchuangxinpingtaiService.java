package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchanyehuaDao;
import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchuangxinpingtaiDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addchuangxinpingtai_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddchuangxinpingtaiService implements Addchuangxinpingtai_Interface {
    @Autowired
    private AddchuangxinpingtaiDao addchuangxinpingtaiDao;
    @Override
    public void addchuangxinpingtai( String platform_number,String address,  String person_in_charge,
                                String classification, String attached_unit, String approval_unit,
                                String establishment_time, String industry_1, String industry_2,
                                String unit_introduction, String unit_homepage, String contact,
                                String contact_phone_number, String e_mail, String postal_code,
                                String jingshouren, String registration_data, int approval_mark,
                                String audit_results_school, String audit_results_hall, String remark,
                                String organization_id, String verifier_scchool, String verifier_hall,
                                String reporting_unit_court, String reporting_unit_school){
        addchuangxinpingtaiDao.addchuangxinpingtai( platform_number, address,  person_in_charge,
                 classification,  attached_unit, approval_unit,
                establishment_time, industry_1, industry_2,
                 unit_introduction, unit_homepage,  contact,
                 contact_phone_number,  e_mail,  postal_code,
               jingshouren,  registration_data, approval_mark,
        audit_results_school,  audit_results_hall,  remark,
                 organization_id ,verifier_scchool ,verifier_hall,
                  reporting_unit_court,  reporting_unit_school);
    }
}
