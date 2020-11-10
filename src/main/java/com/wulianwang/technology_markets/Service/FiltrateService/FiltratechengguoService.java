package com.wulianwang.technology_markets.Service.FiltrateService;

import com.wulianwang.technology_markets.Bean.Chengguoxinxi;
import com.wulianwang.technology_markets.DataBaseController.FiltrateDao.FiltratechengguoDao;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.FiltrateChengguo_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiltratechengguoService implements FiltrateChengguo_Interface {
    @Autowired
    FiltratechengguoDao filtratechengguoDao;
    @Override
    public List<Chengguoxinxi> filchengguo(String results_TypeId,int organizationId , String evaluate_levelId,int start_subscript,
                                           int pagesize){
        return filtratechengguoDao.filtrateChengguo(results_TypeId,organizationId ,evaluate_levelId,start_subscript,pagesize);
    }
    @Override
    public List<Chengguoxinxi> filtrategetResultByTS(String results_TypeId, String school,int start_subscript,
                                           int pagesize){
        return filtratechengguoDao.filtrategetResultByTS(results_TypeId, school, start_subscript, pagesize);
    }
}
