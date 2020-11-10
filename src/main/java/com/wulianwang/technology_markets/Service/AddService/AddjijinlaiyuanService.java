package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchenghaoDao;
import com.wulianwang.technology_markets.DataBaseController.AddDao.AddjijinlaiyuanDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addjijinlaiyuan_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddjijinlaiyuanService implements Addjijinlaiyuan_Interface {
    @Autowired
    private AddjijinlaiyuanDao addjijinlaiyuanDao;
    @Override
    public  void  addjijinlaiyuan(
            String id ,
            String resources,
            int value,
            String biaozhi){
        addjijinlaiyuanDao.addjijinlaiyuan(id,resources,value,biaozhi);
    }

}
