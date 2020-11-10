package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Chengguoxinxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ChengguoxinxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Chengguoxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChengguoxinxiService implements Chengguoxinxi_Interface {
    @Autowired
    private ChengguoxinxiDao chengguoxinxiDao;
    @Override
    public List<Chengguoxinxi> chengguoxinxi(int identity, int start_subscript, int pagesize){
        return chengguoxinxiDao.getChengguoxinxi(identity,start_subscript,pagesize);
    }
}
