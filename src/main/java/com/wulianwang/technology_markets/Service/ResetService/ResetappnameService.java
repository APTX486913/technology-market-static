package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetappnameDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.Resetappname_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetappnameService implements Resetappname_Interface {
    @Autowired
    private ResetappnameDao resetappnameDao;
    @Override
    public void resetappname(String ident , String re_name){
        resetappnameDao.resetappname(ident ,re_name);
    }

}
