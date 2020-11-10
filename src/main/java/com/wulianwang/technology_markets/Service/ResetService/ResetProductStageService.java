package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetProductStageDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetProductStage_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetProductStageService implements ResetProductStage_Interface {
    @Autowired
    private ResetProductStageDao resetProductStageDao;
    @Override
    public void resetProductStage(String ident , String re_stage){
        resetProductStageDao.resetProductStage(ident ,re_stage);
    }
}
