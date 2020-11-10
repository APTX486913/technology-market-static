package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddshenbaoleibieDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addshenbaoleibie_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddshenbaoleibieService implements Addshenbaoleibie_Interface {
    @Autowired
    private AddshenbaoleibieDao addshenbaoleibieDao;
    @Override
    public void addshenbaoleibie( String id ,
                                  String type,
                                  int value,
                                  String biaozhi){
        addshenbaoleibieDao.addshenbaoleibie(id,type,value,biaozhi);
    }
}
