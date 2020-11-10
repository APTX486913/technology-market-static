package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetProjectAreasDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetProjectAreas_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetProjectAreasService implements ResetProjectAreas_Interface {
    @Autowired
    private ResetProjectAreasDao resetProjectAreasDao;
    @Override
    public void resetProjectAreas(String ident , String re_field){
        resetProjectAreasDao.resetProjectAreas(ident ,re_field);
    }
}
