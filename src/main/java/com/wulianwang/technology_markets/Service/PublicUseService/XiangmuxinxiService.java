package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Xiangmuxinxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.XiangmuxinxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xiangmuxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XiangmuxinxiService implements Xiangmuxinxi_Interface {
    @Autowired
    private XiangmuxinxiDao xiangmuxinxiDao;
    @Override
    public List<Xiangmuxinxi> xiangmuxinxi(int identity, int start_subscript, int pagesize){
        return xiangmuxinxiDao.getXiangmuxinxi(identity,start_subscript,pagesize);
    }
}
