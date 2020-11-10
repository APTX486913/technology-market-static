package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Yanshoupingjia;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.YanshoupingjiaDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Yanshoupingjia_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YanshoupingjiaService implements Yanshoupingjia_Interface {
   @Autowired
    private YanshoupingjiaDao yanshoupingjiaDao;
   @Override
    public List<Yanshoupingjia> getyanshoupingjia(){
       return yanshoupingjiaDao.getYanshoupingjia();
   }
}

