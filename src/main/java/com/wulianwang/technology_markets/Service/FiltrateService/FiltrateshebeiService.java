package com.wulianwang.technology_markets.Service.FiltrateService;

import com.wulianwang.technology_markets.Bean.Shebeixinxi;
import com.wulianwang.technology_markets.DataBaseController.FiltrateDao.FiltrateshebeiDao;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.Filtrateshebei_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltrateshebeiService implements Filtrateshebei_Interface {
    @Autowired
    private FiltrateshebeiDao filtrateshebeiDao;
    @Override
    public List<Shebeixinxi> filshebei(int organization){
        return filtrateshebeiDao.filtrateshebei(organization);
    }

}
