package com.wulianwang.technology_markets.Service.FiltrateService;

import com.wulianwang.technology_markets.Bean.Chengguoxinxi;
import com.wulianwang.technology_markets.DataBaseController.FiltrateDao.FiltrateinfoDao;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.Filtrateinfo_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lhk
 * @description
 * @create 2020-10-15 19:13
 */
@Service
public class FiltrateinfoService implements Filtrateinfo_Interface {
    @Autowired
    FiltrateinfoDao filtrateinfoDao;
    @Override
    public List<Map<String,Object>> filtrateinfo(String dataFrom, String type, String school, String begin_time, String end_time,
                                                 int start_subscript,
                                                 int pagesize) {
        return filtrateinfoDao.filtrateinfo(dataFrom,type,school,begin_time,end_time,start_subscript,pagesize);
    }
}