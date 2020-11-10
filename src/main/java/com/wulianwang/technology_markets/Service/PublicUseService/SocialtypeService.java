package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Socialtype;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.SocialtypeDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Socialtype_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialtypeService implements Socialtype_Interface {
    @Autowired
    private SocialtypeDao socialtypeDao;
    @Override
    public List<Socialtype> getsocialtype() {
        return socialtypeDao.getSocialtype();
    }

}
