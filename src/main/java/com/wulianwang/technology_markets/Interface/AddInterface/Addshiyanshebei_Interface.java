package com.wulianwang.technology_markets.Interface.AddInterface;

import org.apache.ibatis.annotations.Param;

public interface Addshiyanshebei_Interface {
    void addshiyanshebei(String shebei_tnumber, String shebei_tname,  String keyword,
                          String production_unit,  String start_time,  String service_life,
                          String price , String introduction, int quantity,
                          String  purpose,String picture, String linkman,
                          String contact_number, String E_mail,String mailing_address,
                          String postcode,  String jing_shou_ren,  String register_date,
                         int review_sign,  String audit_result_xiao,  String audit_result_ting,
                         String remarks,String group_number, String auditor_xiao,  String auditor_ting,  String tianbao_danwei_yuan,
                          String tianbao_danwei_xiao
    );
}
