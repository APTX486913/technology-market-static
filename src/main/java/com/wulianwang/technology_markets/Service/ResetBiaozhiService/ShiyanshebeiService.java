package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.ShiyanshebeiDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.Shiyanshebei_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiyanshebeiService implements Shiyanshebei_Interface {
    @Autowired
    private ShiyanshebeiDao shiyanshebeiDao;
    @Override
    public void shiyanshebei(String ident ){
        shiyanshebeiDao.shiyanshebei(ident);
    }

}
