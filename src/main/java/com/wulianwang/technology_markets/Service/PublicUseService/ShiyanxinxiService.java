package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Shiyanxinxi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ShiyanxinxiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Shiyanxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiyanxinxiService implements Shiyanxinxi_Interface {
    @Autowired
   private ShiyanxinxiDao shiyanxinxiDao;
    @Override
  public  List<Shiyanxinxi> shiyanxinxi(String identity){
        return  shiyanxinxiDao.getShiyanxinxi(identity);
    }
}
