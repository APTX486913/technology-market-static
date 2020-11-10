package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.QiyexuqiuDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.Qiyexuqiu_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QiyexuqiuService implements Qiyexuqiu_Interface {
    @Autowired
    private QiyexuqiuDao qiyexuqiuDao;
    @Override
    public void qiyexuqiu(String ident ){
        qiyexuqiuDao.qiyexuqiu(ident);
    }

}
