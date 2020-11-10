package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddzhuanlixinxiDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addzhuanlixinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddzhuanlixinxiService implements Addzhuanlixinxi_Interface {
    @Autowired
    private AddzhuanlixinxiDao addzhuanlixinxiDao;
    @Override
    public void addczhuanlixinxi(String serial_number,String name,String type,
                                 String number, String apply_number,String apply_date,
                                 String patent_person, String credential_number, String contact_person,
                                 String contact_number,  String E_mail,String communication_address,
                                 String postcode, String jing_shou_ren, String register_date,
                                 int sign,String xiao_result,  String ting_result,
                                 String remark, String organization_id, String xiao_auditor ,
                                 String ting_auditor,String tianbao_yuan, String tianbao_xiao){
        addzhuanlixinxiDao.addczhuanlixinxi( serial_number, name, type,
                 number, apply_number, apply_date,
                 patent_person,  credential_number,  contact_person,
                 contact_number,   E_mail,  communication_address,
                  postcode, jing_shou_ren, register_date, sign, xiao_result, ting_result,
                 remark, organization_id,  xiao_auditor ,
                 ting_auditor, tianbao_yuan,  tianbao_xiao);
    }
}
