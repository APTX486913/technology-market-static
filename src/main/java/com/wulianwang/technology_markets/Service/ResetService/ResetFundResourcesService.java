package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetFundResourcesDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetFundResources_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetFundResourcesService implements ResetFundResources_Interface {
    @Autowired
    private ResetFundResourcesDao resetFundResourcesDao;
    @Override
    public void resetFundResources(String ident , String re_resources){
        resetFundResourcesDao.resetFundResources(ident ,re_resources);
    }

}
