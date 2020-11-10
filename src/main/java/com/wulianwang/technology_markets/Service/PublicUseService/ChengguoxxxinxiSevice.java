package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Chengguoxxxinxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ChengguoxxxinxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Chengguoxxxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChengguoxxxinxiSevice implements Chengguoxxxinxi_Interface {
    @Autowired
    private ChengguoxxxinxiDao chengguoxxxinxiDao;
    @Override
    public List<Chengguoxxxinxi> chengguoxxxinxi(String identity){
        return chengguoxxxinxiDao.getChengguoxxxinxi(identity);
    }
}
