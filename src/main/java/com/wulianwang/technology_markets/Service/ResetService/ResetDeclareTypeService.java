package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetDeclareTypeDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResetDeclareType_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetDeclareTypeService implements ResetDeclareType_Interface {
    @Autowired
    private ResetDeclareTypeDao resetDeclareTypeDao;
    @Override
    public void resetDeclareType(String ident , String re_type){
        resetDeclareTypeDao.resetDeclareType(ident ,re_type);
    }
}
