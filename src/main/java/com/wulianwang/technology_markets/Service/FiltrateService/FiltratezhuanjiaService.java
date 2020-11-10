package com.wulianwang.technology_markets.Service.FiltrateService;

import com.wulianwang.technology_markets.Bean.Zhuanjiaxinxi;
import com.wulianwang.technology_markets.DataBaseController.FiltrateDao.FiltratezhuanjiaDao;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.Filtratezhuanjia_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltratezhuanjiaService implements Filtratezhuanjia_Interface {
    @Autowired
    private FiltratezhuanjiaDao filtratezhuanjiaDao;
    @Override
    public  List<Zhuanjiaxinxi> filzhuanjia(String industry_type,String sex,  String organization,String tit){
        return filtratezhuanjiaDao.filtratezhuanjia(industry_type,sex,organization,tit);}

}
