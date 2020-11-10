package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.RenwencjengguoPassDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.RenwencjengguoPass_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenwencjengguoPassService implements RenwencjengguoPass_Interface {
    @Autowired
    private RenwencjengguoPassDao renwencjengguoPassDao;
    @Override
    public void renwencjengguoPass(String ident ){
        renwencjengguoPassDao.renwencjengguoPass(ident);
    }

}
