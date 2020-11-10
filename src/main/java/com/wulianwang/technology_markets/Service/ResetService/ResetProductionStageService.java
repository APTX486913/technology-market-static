package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetProductionStageDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetProductionStage_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetProductionStageService implements ResetProductionStage_Interface {
    @Autowired
    private ResetProductionStageDao resetProductionStageDao;
    @Override
    public void resetProductionStage(String ident , String re_stage){
        resetProductionStageDao.resetProductionStage(ident ,re_stage);
    }
}
