package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Zhuanjiaxinxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ZhuanjiaxinxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Zhuanjiaxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZhuanjiaxinxiService implements Zhuanjiaxinxi_Interface {
    @Autowired
    private ZhuanjiaxinxiDao zhuanjiaxinxiDao;

    @Override
    public List<Zhuanjiaxinxi> zhuanjiaxinxi(int identity, int start_subscript, int pagesize) {
        return zhuanjiaxinxiDao.getZhuanjiaxinxi(identity,start_subscript,pagesize);
    }
}
