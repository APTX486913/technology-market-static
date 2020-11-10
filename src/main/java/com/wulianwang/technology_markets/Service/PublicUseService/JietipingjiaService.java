package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Jietipingjia;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.JietipingjiaDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Jietipingjia_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JietipingjiaService implements Jietipingjia_Interface {
    @Autowired
    private JietipingjiaDao jietipingjiaDao;
    @Override
    public List<Jietipingjia> getjietipingjia(){
        return jietipingjiaDao.getJietipingjia();

    }
}
