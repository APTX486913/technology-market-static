package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddshengchanjieduanDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addshengchanjieduan_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddshengchanjieduanService implements Addshengchanjieduan_Interface {
@Autowired
    private AddshengchanjieduanDao addshengchanjieduanDao;
@Override
    public void addshengchanjieduan(
        String id ,
        String stage,
        int value,
        String biaozhi){
    addshengchanjieduanDao.addshengchanjieduan(id,stage,value,biaozhi);
}
}
