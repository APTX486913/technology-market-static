package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddzhuanjiaxinxiDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addzhuanjiaxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddzhuanjiaxinxiService implements Addzhuanjiaxinxi_Interface {
    @Autowired
    private AddzhuanjiaxinxiDao addzhuanjiaxinxiDao;
    @Override
    public void addzhuanjiaxinxi( String professor_number, String name, String gender,
                                  String born_date,  String industry_1,  String industry_2,
                                  String education_background,  String zhi_cheng,  String duty,
                                  int level, String title,  String organization,
                                  String ID_number, String commodation_address, String E_maile,
                                  String jing_shou_ren,  String register_date, int sign,
                                  String check_result_xiao,  String check_result_ting, String remarks,
                                  String organization_number, String auditor_xiao,
                                  String auditor_ting, String tianbao_yuan, String tianbao_xiao){
       addzhuanjiaxinxiDao.addzhuanjiaxinxi( professor_number, name, gender,
                born_date, industry_1, industry_2,
                education_background, zhi_cheng, duty,
                level, title, organization, ID_number, commodation_address, E_maile,
                 jing_shou_ren, register_date, sign,
                check_result_xiao, check_result_ting, remarks,
                 organization_number, auditor_xiao,
                 auditor_ting, tianbao_yuan, tianbao_xiao);
    }
}
