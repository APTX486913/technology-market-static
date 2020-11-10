package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.ChengguozhuanhuaDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.Chengguozhuanhua_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChengguozhuanhuaService implements Chengguozhuanhua_Interface {
    @Autowired
    private ChengguozhuanhuaDao chengguozhuanhuaDao;
    @Override
    public void chengguozhuanhua(String ident ){
        chengguozhuanhuaDao.chengguozhuanhua(ident);
    }

}
