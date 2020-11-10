package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Suoshudanwei;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.SuoshudanweiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Suoshudanwei_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuoshudanweiService implements Suoshudanwei_Interface {
    @Autowired
    private SuoshudanweiDao suoshudanweiDao;

    @Override
    public List<Suoshudanwei> suoshudanwei(int getall, int start_subscript, int pagesize) {
        return suoshudanweiDao.getSuoshudanwei(getall,start_subscript,pagesize);
    }
}
