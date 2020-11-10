package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Zhuanlixiangxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ZhuanlixiangxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Zhuanlixiangxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZhuanlixiangxiService implements Zhuanlixiangxi_Interface {
    @Autowired
    private ZhuanlixiangxiDao zhuanlixiangxiDao;
    @Override
    public List<Zhuanlixiangxi> zhuanlixiangxi( String identity){
        return zhuanlixiangxiDao.getZhuanlixiangxi(identity);
    }
}
