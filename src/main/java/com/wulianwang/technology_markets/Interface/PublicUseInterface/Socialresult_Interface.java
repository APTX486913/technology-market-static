package com.wulianwang.technology_markets.Interface.PublicUseInterface;

import com.wulianwang.technology_markets.Bean.Socialresult;

import java.util.List;

public interface Socialresult_Interface {
    List<Socialresult> socialresult(int identity, int start_subscript, int pagesize);

}
