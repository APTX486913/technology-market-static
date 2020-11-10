package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Jiandingpingjia;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.JiandingpingjiaDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Jiandingpingjia_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiandingpingjiaService implements Jiandingpingjia_Interface {
    @Autowired
    private JiandingpingjiaDao jiandingpingjiaDao;
    @Override
    public List<Jiandingpingjia> getjiandingpingjia(){
        return jiandingpingjiaDao.getJiandingpingjia();
    }

}
