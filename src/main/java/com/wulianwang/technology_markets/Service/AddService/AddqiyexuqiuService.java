package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddqiyexuqiuDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addqiyexuqiu_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddqiyexuqiuService implements Addqiyexuqiu_Interface {
    @Autowired
    private AddqiyexuqiuDao addqiyexuqiuDao;
    @Override
    public void addqiyexuqiu( String id , String name, String context, String e_id ,
                              String date, int status, String type){
        addqiyexuqiuDao.addqiyexuqiu( id,name,context,e_id,date,status,type);
    }
}
