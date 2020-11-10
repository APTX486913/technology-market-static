package com.wulianwang.technology_markets.Interface.AddInterface;

import org.apache.ibatis.annotations.Param;

public interface Addchengguozhuanhua_Interface {
    void addchengguozhuanhua( String transformation_project_item, String transformation_service_type, String transformation_project_name,
                              String transformation_project_application,String project_introduction, String jingshouren,
                              int approval_mark,  String approval_result_school,  String approval_result_hall, String organization_id, String verifier_scchool,
                               String verifier_hall, String reporting_unit_court,  String reporting_unit_school,  String contact , String contact_phone);
}
