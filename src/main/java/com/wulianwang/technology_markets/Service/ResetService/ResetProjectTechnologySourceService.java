package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetProjectTechnologySourceDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetProjectTechnologySource_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetProjectTechnologySourceService implements ResetProjectTechnologySource_Interface {
    @Autowired
    private ResetProjectTechnologySourceDao resetProjectTechnologySourceDao;
    @Override
    public void resetProjectTechnologySource(String ident , String reproject_technology_sourc){
        resetProjectTechnologySourceDao.resetProjectTechnologySource(ident ,reproject_technology_sourc);
    }

}
