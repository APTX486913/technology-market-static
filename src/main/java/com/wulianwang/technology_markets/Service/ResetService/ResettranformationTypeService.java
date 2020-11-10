package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResettranformationTypeDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.ResettranformationType_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResettranformationTypeService implements ResettranformationType_Interface {
    @Autowired
    private ResettranformationTypeDao resettranformationTypeDao;
    @Override
    public void resettranformationType(String ident , String re_tyrp){
        resettranformationTypeDao.resettranformationType(ident ,re_tyrp);
    }

}
