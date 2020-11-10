package com.wulianwang.technology_markets.Interface.AddInterface;

import org.apache.ibatis.annotations.Param;

public interface Addzhuanjiaxinxi_Interface {
    void addzhuanjiaxinxi( String professor_number, String name, String gender,
                          String born_date,  String industry_1,  String industry_2,
                           String education_background,  String zhi_cheng,  String duty,
                            int level, String title,  String organization,
                          String ID_number, String commodation_address, String E_maile,
                           String jing_shou_ren,  String register_date, int sign,
                           String check_result_xiao,  String check_result_ting, String remarks,
                           String organization_number, String auditor_xiao,
                           String auditor_ting, String tianbao_yuan, String tianbao_xiao);
}
