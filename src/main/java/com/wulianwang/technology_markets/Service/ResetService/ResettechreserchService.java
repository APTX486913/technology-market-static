package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResettechreserchpassDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.Resettechreserchpass_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResettechreserchService implements Resettechreserchpass_Interface {
    @Autowired
    private ResettechreserchpassDao resettechreserchpassDao;
    @Override
    public void resettechreserchpass(String ident ){
        resettechreserchpassDao.resettechreserchpass(ident);
    }
}
