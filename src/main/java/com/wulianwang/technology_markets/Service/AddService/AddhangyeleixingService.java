package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchengguozhuanhuaDao;
import com.wulianwang.technology_markets.DataBaseController.AddDao.AddhangyeleixingDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addhangyeleixing_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddhangyeleixingService implements Addhangyeleixing_Interface {
    @Autowired
    private AddhangyeleixingDao addhangyeleixingDao;
    @Override
    public void addhangyeleixing(
            String id ,
            String type,
            int value,
            String biaozhi){
        addhangyeleixingDao.addhangyeleixing(id,type,value,biaozhi);
    }
}
