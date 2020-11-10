package com.wulianwang.technology_markets.Service.FiltrateService;

import com.wulianwang.technology_markets.Bean.Xiangmuxinxi;
import com.wulianwang.technology_markets.DataBaseController.FiltrateDao.FiltratexiangmuDao;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.Filtratexiangmu_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltratexiangmuService implements Filtratexiangmu_Interface {
    @Autowired
    private FiltratexiangmuDao filtratexiangmuDao;
    @Override
    public  List<Xiangmuxinxi> filxiangmu(String project_source,String project_level, String affiliated_unit){
        return filtratexiangmuDao.filtratexiangmu(project_source,project_level ,affiliated_unit);}
}
