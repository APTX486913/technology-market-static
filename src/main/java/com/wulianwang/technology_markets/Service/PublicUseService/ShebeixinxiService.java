package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Shebeixinxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ShebeixinxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Shebeixinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShebeixinxiService implements Shebeixinxi_Interface {
    @Autowired
    private ShebeixinxiDao shebeixinxiDao;
    @Override
    public List<Shebeixinxi> shebeixinxi(int identity, int start_subscript, int pagesize){
        return shebeixinxiDao.getShebeixinxi(identity,start_subscript,pagesize);
    }
}
