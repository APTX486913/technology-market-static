package com.wulianwang.technology_markets.Service.ResetBiaozhiService;

import com.wulianwang.technology_markets.DataBaseController.ResetBiaozhiDao.GaoxiaokejiDao;
import com.wulianwang.technology_markets.Interface.ResetBiaozhiInterface.Gaoxiaokeji_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GaoxiaokejiService implements Gaoxiaokeji_Interface {
    @Autowired
    private GaoxiaokejiDao gaoxiaokejiDao;
    @Override
    public void gaoxiaokeji(String ident ){
        gaoxiaokejiDao.gaoxiaokeji(ident);
    }

}
