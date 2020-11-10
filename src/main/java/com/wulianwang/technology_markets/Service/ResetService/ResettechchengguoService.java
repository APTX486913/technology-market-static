package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.ResettechchengguopassDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.Resettechchengguopass_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResettechchengguoService implements Resettechchengguopass_Interface {
    @Autowired
    private ResettechchengguopassDao resettechchengguopassDao;
    @Override
    public void resettechchengguopass(String ident ){
        resettechchengguopassDao.resettechchengguopass(ident);
    }
}
