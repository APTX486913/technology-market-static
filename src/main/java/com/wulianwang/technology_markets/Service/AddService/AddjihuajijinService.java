package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchenghaoDao;
import com.wulianwang.technology_markets.DataBaseController.AddDao.AddjihuajijinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddjihuajijinService implements AddjihuajijinDao {
    @Autowired
    private AddjihuajijinDao addjihuajijinDao;
    @Override
    public void addjihuajijin(String id , String name, int value, String biaozhi){
        addjihuajijinDao.addjihuajijin(id ,name,value,biaozhi);
    }
}
