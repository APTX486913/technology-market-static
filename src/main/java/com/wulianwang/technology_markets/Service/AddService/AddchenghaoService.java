package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchanpinjieduanDao;
import com.wulianwang.technology_markets.DataBaseController.AddDao.AddchenghaoDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addchenghao_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddchenghaoService implements Addchenghao_Interface {
    @Autowired
    private AddchenghaoDao addchenghaoDao;
    @Override
    public void addchenghao(String id , String designation, int value, String biaozhi){
        addchenghaoDao.addchenghao(id ,designation,value,biaozhi);
    }
}
