package com.wulianwang.technology_markets.Interface.FiltrateInterface;

import com.wulianwang.technology_markets.Bean.Chengguoxinxi;

import java.util.List;

public interface FiltrateChengguo_Interface {
    List<Chengguoxinxi> filchengguo(String results_TypeId, int organizationId, String evaluate_levelId,int start_subscript,
                                    int pagesize);
    List<Chengguoxinxi> filtrategetResultByTS(String results_TypeId,String school,int start_subscript,
                                    int pagesize);
}
