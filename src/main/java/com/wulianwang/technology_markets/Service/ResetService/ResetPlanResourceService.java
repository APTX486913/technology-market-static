package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetPlanResourceDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetPlanResource_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPlanResourceService implements ResetPlanResource_Interface {
    @Autowired
    private ResetPlanResourceDao resetPlanResourceDao;
    @Override
    public void resetPlanResource(String ident , String re_plan_source){
        resetPlanResourceDao.resetPlanResource(ident ,re_plan_source);
    }
}
