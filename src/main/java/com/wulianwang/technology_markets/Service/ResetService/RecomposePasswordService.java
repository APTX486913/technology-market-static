package com.wulianwang.technology_markets.Service.ResetService;

import com.wulianwang.technology_markets.DataBaseController.ResetDao.RecomposePasswordDao;
import com.wulianwang.technology_markets.Interface.Reset_Interface.RecomposePassword_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecomposePasswordService implements RecomposePassword_Interface {
    @Autowired
    private RecomposePasswordDao recomposePasswordDao;

    @Override
    public int recomposePassword(int ident, String pwd) {
        return recomposePasswordDao.recomposePassword(ident, pwd);
    }
}
