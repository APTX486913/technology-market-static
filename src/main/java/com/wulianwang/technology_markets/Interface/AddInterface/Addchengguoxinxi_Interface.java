package com.wulianwang.technology_markets.Interface.AddInterface;

import org.apache.ibatis.annotations.Param;

public interface Addchengguoxinxi_Interface {
    void addchengguoxinxi(  String Identification_number, String results_type, String results_name,
                          String application_field, String subordinate_units, String finish_time,
                          String evaluation_way_level, String evaluation_date, String evaluation_institution,
                            String result_id,  String result_summary, String wanchengren,
                           String converted_or_not, String contact, String contact_phone_number,
                           String e_mail, String communication_address, String postal_code,
                           String jingshouren, String registration_data, int approval_mark,
                           String audit_results_school, String audit_results_hall, String comment,
                           String organization_id, String verifier_scchool, String verifier_hall,
                           String reporting_unit_court, String reporting_unit_school);
}
