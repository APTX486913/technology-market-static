package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.ChengguoxinxiPassDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.ChengguoxinxiPass_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChengguoxinxiPassService implements ChengguoxinxiPass_Interface {
    @Autowired
    private ChengguoxinxiPassDao chengguoxinxiPassDao;
    @Override
    public void chengguoxinxiPass(String ident ){
        chengguoxinxiPassDao.chengguoxinxiPass(ident);
    }

}
