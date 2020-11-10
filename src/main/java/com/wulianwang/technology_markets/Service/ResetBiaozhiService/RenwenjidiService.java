package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.RenwenjidiPassDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.Renwenjidi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenwenjidiService implements Renwenjidi_Interface {
    @Autowired
    private RenwenjidiPassDao renwenjidiPassDao;
    @Override
    public void renwenjidiPass(String ident ){
        renwenjidiPassDao.renwenjidiPass(ident);
    }

}
