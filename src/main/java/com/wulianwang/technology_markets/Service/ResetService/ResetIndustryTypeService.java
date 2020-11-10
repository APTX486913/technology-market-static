package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetIndustryTypeDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetIndustryType_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetIndustryTypeService implements ResetIndustryType_Interface {
    @Autowired
    private ResetIndustryTypeDao resetIndustryTypeDao;
    @Override
    public void resetIndustryType(String ident , String re_type){
        resetIndustryTypeDao.resetIndustryType(ident ,re_type);
    }
}
