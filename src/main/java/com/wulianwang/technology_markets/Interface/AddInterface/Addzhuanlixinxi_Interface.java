package com.wulianwang.technology_markets.Interface.AddInterface;

import org.apache.ibatis.annotations.Param;

public interface Addzhuanlixinxi_Interface {
    void addczhuanlixinxi(String serial_number,String name,String type,
                          String number, String apply_number,String apply_date,
                          String patent_person, String credential_number, String contact_person,
                          String contact_number,  String E_mail,String communication_address,
                          String postcode, String jing_shou_ren, String register_date,
                           int sign,String xiao_result,  String ting_result,
                          String remark, String organization_id, String xiao_auditor ,
                          String ting_auditor,String tianbao_yuan, String tianbao_xiao);
}
