package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddxiangmulaiyuanDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addxiangmulaiyuan_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddxiangmulaiyuanService implements Addxiangmulaiyuan_Interface {
    @Autowired
    private AddxiangmulaiyuanDao addxiangmulaiyuanDao;
    @Override
    public void addxiangmulaiyuan( String id ,
                                   String plan_source,
                                   int value,
                                   String biaozhi){
        addxiangmulaiyuanDao.addxiangmulaiyuan(id,plan_source,value,biaozhi);
    }
}
