package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResetchengguotransDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.Resetchengguotrans_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetchengguotransService  implements Resetchengguotrans_Interface {
    @Autowired
    private ResetchengguotransDao resetchengguotransDao;
    @Override
    public void resetchengguotrans(String ident ){
        resetchengguotransDao.resetchengguotrans(ident);
    }
}
