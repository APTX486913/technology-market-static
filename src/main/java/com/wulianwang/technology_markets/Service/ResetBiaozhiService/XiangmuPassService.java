package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.XiangmuPassDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.XiangmuPass_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XiangmuPassService implements XiangmuPass_Interface {
    @Autowired
    private XiangmuPassDao xiangmuPassDao;
    @Override
    public void xiangmuPass(String ident ){
        xiangmuPassDao.xiangmuPass(ident);
    }



}
