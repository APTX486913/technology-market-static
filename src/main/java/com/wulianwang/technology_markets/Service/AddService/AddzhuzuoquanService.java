package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddzhuzuoquanDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addzhuzuoquan_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddzhuzuoquanService implements Addzhuzuoquan_Interface {
    @Autowired
    private AddzhuzuoquanDao addzhuzuoquanDao;
    @Override
    public void  addzhuzuoquan( String copyright_number, String software_name, String software_type,
                                String credential_number, String copyright_holder, String power_way,
                                String power_range, String accomplish_date, String publish_date,
                                String certificate_date, String linkman, String contact_number,
                                String E_mail, String mailing_address, String accredit_invent,
                                String accredit_practical, String accredit_appearance,
                                String postcode, String jing_shou_ren,
                                String register_date, int review_sign, String audit_result_xiao,
                                String audit_result_ting, String remarks, String group_number,
                                String auditor_xiao, String auditor_ting, String tianbao_danwei_yuan, String tianbao_danwei_xiao){
        addzhuzuoquanDao.addzhuzuoquan( copyright_number, software_name,  software_type,
                 credential_number, copyright_holder, power_way,
                 power_range , accomplish_date ,publish_date,
                 certificate_date,   linkman,   contact_number,
                E_mail,  mailing_address,  accredit_invent,
                 accredit_practical,  accredit_appearance,
                 postcode, jing_shou_ren,
                 register_date,  review_sign,  audit_result_xiao,
                 audit_result_ting, remarks, group_number,
                 auditor_xiao,  auditor_ting,  tianbao_danwei_yuan, tianbao_danwei_xiao);
    }
}
