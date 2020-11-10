package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddsuoshulingyuDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addsuoshulingyu_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddsuoshulingyuService implements Addsuoshulingyu_Interface {
@Autowired
    private AddsuoshulingyuDao addsuoshulingyuDao;
    @Override
    public void addsuoshulingyu(String id , String field, int value, String biaozhi){
        addsuoshulingyuDao.addsuoshulingyu(id,field,value,biaozhi);
    }
}
