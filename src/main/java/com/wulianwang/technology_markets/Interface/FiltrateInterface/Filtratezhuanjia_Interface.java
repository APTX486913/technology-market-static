package com.wulianwang.technology_markets.Interface.FiltrateInterface;

import com.wulianwang.technology_markets.Bean.Zhuanjiaxinxi;

import java.util.List;

public interface Filtratezhuanjia_Interface {
    List<Zhuanjiaxinxi> filzhuanjia(String industry_type, String sex, String organization, String tit);
}
