package com.wulianwang.technology_markets.Service.FiltrateService;

import com.wulianwang.technology_markets.Bean.Chengguoxinxi;
import com.wulianwang.technology_markets.Bean.Innovateplat;
import com.wulianwang.technology_markets.DataBaseController.FiltrateDao.FiltrateInnovateplatDao;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.Filtrateinnovateplat_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltrateinnovateplatService implements Filtrateinnovateplat_Interface {
    @Autowired
    private FiltrateInnovateplatDao filtrateInnovateplatDao;
    @Override
    public List<Innovateplat> filInnovateplat(String industry_type, String platform_type, int organization){
        return filtrateInnovateplatDao.filtrateInnovateplat(industry_type, platform_type, organization);
    }
}
