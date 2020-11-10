package com.wulianwang.technology_markets.Interface.FiltrateInterface;

import com.wulianwang.technology_markets.Bean.*;

import java.util.List;
import java.util.Map;

/**
 * @author lhk
 * @description
 * @create 2020-10-15 19:09
 */
public interface Filtrateinfo_Interface {
    List<Map<String,Object>> filtrateinfo(String dataFrom, String type, String school, String begin_time, String end_time,
                                          int start_subscript,
                                          int pagesize);

}
