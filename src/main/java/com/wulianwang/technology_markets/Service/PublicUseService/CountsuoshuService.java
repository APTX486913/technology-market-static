package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Count;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.CountsuoshuDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Countsuoshu_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountsuoshuService implements Countsuoshu_Interface {
    @Autowired
    private CountsuoshuDao countsuoshuDao;
    @Override
    public Count countsuoshu(){return countsuoshuDao.countsuoshu();}
}
