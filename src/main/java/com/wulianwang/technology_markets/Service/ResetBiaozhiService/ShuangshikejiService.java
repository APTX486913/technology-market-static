package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.ShuangshikejiDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.Shuangshikeji_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShuangshikejiService implements Shuangshikeji_Interface {
    @Autowired
    private ShuangshikejiDao shuangshikejiDao;
    @Override
    public void shuangshikeji(String ident ){
        shuangshikejiDao.shuangshikeji(ident);
    }
}
