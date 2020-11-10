package com.wulianwang.technology_markets.Service.AddService;

import com.wulianwang.technology_markets.DataBaseController.AddDao.AddjijinlaiyuanDao;
import com.wulianwang.technology_markets.DataBaseController.AddDao.AddjishulaiyuanDao;
import com.wulianwang.technology_markets.Interface.AddInterface.Addjijinlaiyuan_Interface;
import com.wulianwang.technology_markets.Interface.AddInterface.Addjishulaiyuan_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddjishulaiyuanService implements Addjishulaiyuan_Interface {
    @Autowired
    private AddjishulaiyuanDao addjishulaiyuanDao;
    @Override
    public  void addjishulaiyuan(String id , String project_technology_sourc, int value, String biaozhi){
        addjishulaiyuanDao.addjishulaiyuan(id,project_technology_sourc,value,biaozhi);
    }

}
