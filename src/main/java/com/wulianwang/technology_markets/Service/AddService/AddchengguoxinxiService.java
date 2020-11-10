package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchanyehuaDao;
import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchengguoxinxiDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addchengguoxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddchengguoxinxiService implements Addchengguoxinxi_Interface {
    @Autowired
    private AddchengguoxinxiDao addchengguoxinxiDao;
    @Override
    public void addchengguoxinxi( String Identification_number, String results_type, String results_name,
                                  String application_field, String subordinate_units, String finish_time,
                                  String evaluation_way_level, String evaluation_date, String evaluation_institution,
                                  String result_id,  String result_summary, String wanchengren,
                                  String converted_or_not, String contact, String contact_phone_number,
                                  String e_mail, String communication_address, String postal_code,
                                  String jingshouren, String registration_data, int approval_mark,
                                  String audit_results_school, String audit_results_hall, String comment,
                                  String organization_id, String verifier_scchool, String verifier_hall,
                                  String reporting_unit_court, String reporting_unit_school){
        addchengguoxinxiDao.addchengguoxinxi( Identification_number,  results_type,  results_name,
                 application_field, subordinate_units, finish_time,
                 evaluation_way_level,  evaluation_date, evaluation_institution,
                  result_id,  result_summary, wanchengren,
                 converted_or_not,  contact,  contact_phone_number,
                 e_mail,   communication_address, postal_code,
                 jingshouren, registration_data, approval_mark,
         audit_results_school, audit_results_hall, comment,
                organization_id, verifier_scchool, verifier_hall,
                 reporting_unit_court, reporting_unit_school);
    }
}
