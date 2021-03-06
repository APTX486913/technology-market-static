package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Zhuanjiaxiangxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ZhuanjiaxiangxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Zhuanjiaxiangxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZhuanjiaxiangxiService implements Zhuanjiaxiangxi_Interface {
    @Autowired
    private ZhuanjiaxiangxiDao zhuanjiaxiangxiDao;
    @Override
    public List<Zhuanjiaxiangxi> zhuanjiaxiangxi(String identity)
    {return zhuanjiaxiangxiDao.getZhuanjiaxiangxi(identity); }
}
