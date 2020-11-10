package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetDesignationDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetDesignation_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetDesignationService implements ResetDesignation_Interface {
    @Autowired
    private ResetDesignationDao resetDesignationDao;
    @Override
    public void resetDesignation(String ident , String re_designation){
        resetDesignationDao.resetDesignation(ident ,re_designation);
    }


}
