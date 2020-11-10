package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddshiyanshebeiDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addshiyanshebei_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddshiyanshebeiService implements Addshiyanshebei_Interface {
    @Autowired
    private AddshiyanshebeiDao addshiyanshebeiDao;
    @Override
    public void addshiyanshebei(String shebei_tnumber, String shebei_tname,  String keyword,
                                String production_unit,  String start_time,  String service_life,
                                String price , String introduction, int quantity,
                                String  purpose,String picture, String linkman,
                                String contact_number, String E_mail,String mailing_address,
                                String postcode,  String jing_shou_ren,  String register_date,
                                int review_sign,  String audit_result_xiao,  String audit_result_ting,
                                String remarks,String group_number, String auditor_xiao,  String auditor_ting,  String tianbao_danwei_yuan,
                                String tianbao_danwei_xiao){
        addshiyanshebeiDao.addshiyanshebei( shebei_tnumber, shebei_tname, keyword,
                production_unit, start_time,  service_life, price , introduction, quantity,
                purpose, picture, linkman, contact_number,  E_mail, mailing_address,
                postcode,  jing_shou_ren, register_date, review_sign, audit_result_xiao,  audit_result_ting,
                remarks, group_number, auditor_xiao, auditor_ting,  tianbao_danwei_yuan, tianbao_danwei_xiao);
    }
}
