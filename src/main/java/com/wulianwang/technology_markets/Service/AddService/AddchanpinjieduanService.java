package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchanpinjieduanDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addchanpinjieduan_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddchanpinjieduanService implements Addchanpinjieduan_Interface {
    @Autowired
    private AddchanpinjieduanDao addchanpinjieduanDao;
    @Override
     public void addchanpinjieduan(String id , String stage, int value, String biaozhi){
        addchanpinjieduanDao.addchanpinjieduan(id ,stage,value,biaozhi);
    }
}
