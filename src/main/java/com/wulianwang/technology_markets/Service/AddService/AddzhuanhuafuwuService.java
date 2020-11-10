package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddzhuanhuafuwuDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addzhuanhuafuwu_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddzhuanhuafuwuService implements Addzhuanhuafuwu_Interface {
    @Autowired
    private AddzhuanhuafuwuDao addzhuanhuafuwuDao;
    @Override
    public void  addzhuanhuafuwu(
            String id ,
            String type,
            int value,
            String biaozhi){
        addzhuanhuafuwuDao.addzhuanhuafuwu(id,type,value,biaozhi);
    }
}
