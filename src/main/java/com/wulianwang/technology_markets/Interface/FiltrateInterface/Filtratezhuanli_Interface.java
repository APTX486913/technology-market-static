package com.wulianwang.technology_markets.Interface.FiltrateInterface;

import com.wulianwang.technology_markets.Bean.Filtratezhuanli;
import com.wulianwang.technology_markets.Bean.Zhuanlixiangxi;

import java.util.List;

public interface Filtratezhuanli_Interface {
    List<Filtratezhuanli> filzhuanli(String patent_type, String organization);
}
