package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddxiangmuDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addxiangmu_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddxiangmuService implements Addxiangmu_Interface {
    @Autowired
    private AddxiangmuDao addxiangmuDao;
    @Override
    public void addxiangmu(String project_number,  String project_name,  String project_type,
                           String contract_number,  String person_in_charge, String start_time,
                           String end_time,  String contract_funding, String project_level,
                           String service_industry,  String  undertaking_unit,   String canjiadanwei1,
                           String canjiadanwei2, String project_state,  String  content_abstract,
                           String contact,  String contact_phone_number,  String e_mail,
                           String communication_address,  String postal_code,   String jingshouren,
                           String registration_data,   int approval_mark,  String audit_results_school,
                           String audit_results_hall, String comment, String organization_id,
                           String verifier_scchool, String verifier_hall,  String reporting_unit_court,
                           String reporting_unit_school){
        addxiangmuDao.addxiangmu( project_number,  project_name, project_type,
                  contract_number,  person_in_charge , start_time,
                 end_time, contract_funding,  project_level,
                 service_industry,  undertaking_unit, canjiadanwei1,
                 canjiadanwei2, project_state,   content_abstract,
                  contact,  contact_phone_number,  e_mail,
                 communication_address, postal_code, jingshouren,
                 registration_data, approval_mark,  audit_results_school,
                  audit_results_hall,  comment, organization_id,
                 verifier_scchool, verifier_hall, reporting_unit_court, reporting_unit_school);
    }

}
