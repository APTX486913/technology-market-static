package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Waypingjia;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.WaypingjiaDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Waypingjia_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaypingjiaService implements Waypingjia_Interface {
    @Autowired
    private WaypingjiaDao waypingjiaDao;
    @Override
    public List<Waypingjia> getwaypingjia(){
        return waypingjiaDao.getWaypingjia();
    }
}
