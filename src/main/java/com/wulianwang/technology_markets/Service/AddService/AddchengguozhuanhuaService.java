package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchengguozhuanhuaDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addchengguozhuanhua_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddchengguozhuanhuaService implements Addchengguozhuanhua_Interface {
    @Autowired
    private AddchengguozhuanhuaDao addchengguozhuanhuaDao;
    @Override
    public void addchengguozhuanhua( String transformation_project_item, String transformation_service_type, String transformation_project_name,
                                     String transformation_project_application,String project_introduction, String jingshouren,
                                     int approval_mark,  String approval_result_school,  String approval_result_hall, String organization_id,
                                     String verifier_scchool, String verifier_hall, String reporting_unit_court,
                                     String reporting_unit_school,  String contact , String contact_phone){
        addchengguozhuanhuaDao.addchengguozhuanhua( transformation_project_item, transformation_service_type, transformation_project_name,
                transformation_project_application, project_introduction, jingshouren,
                approval_mark, approval_result_school,  approval_result_hall, organization_id,
                verifier_scchool, verifier_hall, reporting_unit_court,
                reporting_unit_school,  contact , contact_phone);
    }
}
