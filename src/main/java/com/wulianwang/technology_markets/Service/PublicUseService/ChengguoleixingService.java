package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Chengguoleixing;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ChengguoleixingDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Chengguoleixing_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChengguoleixingService implements Chengguoleixing_Interface {
    @Autowired
    private ChengguoleixingDao chengguoleixingDao;


    @Override
    public List<Chengguoleixing> getchengguoleixing() {
        return chengguoleixingDao.getChengguoleixing();
    }
}
