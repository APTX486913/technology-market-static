package com.wulianwang.technology_markets.Service.FiltrateService;

import com.wulianwang.technology_markets.Bean.Filtratezhuanli;

import com.wulianwang.technology_markets.DataBaseController.FiltrateDao.FiltratezhuanliDao;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.Filtratezhuanli_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltratezhuanliService implements Filtratezhuanli_Interface {
    @Autowired
    private FiltratezhuanliDao filtratezhuanliDao;
    @Override
    public  List<Filtratezhuanli> filzhuanli(String patent_type, String organization){
        return filtratezhuanliDao.filzhuanli(patent_type,organization);}
}
