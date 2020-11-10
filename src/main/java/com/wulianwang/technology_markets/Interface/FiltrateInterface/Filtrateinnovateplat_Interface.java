package com.wulianwang.technology_markets.Interface.FiltrateInterface;

import com.wulianwang.technology_markets.Bean.Innovateplat;
import java.util.List;

public interface Filtrateinnovateplat_Interface {
    List<Innovateplat> filInnovateplat(String industry_type, String platform_type, int organization);
}
