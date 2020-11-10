package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Xuqiuleixing;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.XuqiuleixingDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Xuqiuleixing_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XuqiuleixingService implements Xuqiuleixing_Interface {
    @Autowired
    private XuqiuleixingDao xuqiuleixingDao;
    @Override
    public List<Xuqiuleixing> getxuqiuleixing(){
        return xuqiuleixingDao.getXuqiuleixing();
    }
}
