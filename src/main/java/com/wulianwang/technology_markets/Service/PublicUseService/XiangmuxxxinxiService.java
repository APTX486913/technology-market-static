package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Xiangmuxxxinxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.XiangmuxxxinxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiangmuxxxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XiangmuxxxinxiService implements Xiangmuxxxinxi_Interface {
    @Autowired
    private XiangmuxxxinxiDao xiangmuxxxinxiDao;
    @Override
    public List<Xiangmuxxxinxi> xiangmuxxxinxi(String identity){
        return xiangmuxxxinxiDao.getXiangmuxxxinxi(identity);
    }


}
