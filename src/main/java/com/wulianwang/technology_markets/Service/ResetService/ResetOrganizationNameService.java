package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetOrganizationNameDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetOrganizationName_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetOrganizationNameService implements ResetOrganizationName_Interface {
    @Autowired
    private ResetOrganizationNameDao resetOrganizationNameDao;
    @Override
    public void resetOrganizationName(String ident , String re_name){
        resetOrganizationNameDao.resetOrganizationName(ident ,re_name);
    }
}
