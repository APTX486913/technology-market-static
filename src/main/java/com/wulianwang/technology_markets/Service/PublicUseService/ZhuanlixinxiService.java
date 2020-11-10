package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Zhuanlixinxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ZhuanlixinxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Zhuanlixinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZhuanlixinxiService implements Zhuanlixinxi_Interface {
    @Autowired
    private ZhuanlixinxiDao zhuanlixinxiDao;
    @Override
    public List<Zhuanlixinxi> zhuanlixinxi(int identity, int start_subscript, int pagesize){
        return zhuanlixinxiDao.getZhuanlixinxi(identity,start_subscript,pagesize);
    }


}
