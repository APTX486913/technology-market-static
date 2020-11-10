package com.wulianwang.technology_markets.Interface.PublicUseInterface;

import com.wulianwang.technology_markets.Bean.Download;

import java.util.List;

public interface Download_Interface {
    List<Download> download (int start_subscript, int pagesize);

}
