package com.wulianwang.technology_markets.Service.SearchService;

import com.wulianwang.technology_markets.Bean.Shebeixinxi;
import com.wulianwang.technology_markets.DataBaseController.SearchDao.SearchShebeixinxiDao;
import com.wulianwang.technology_markets.Interface.SearchInterface.SearchShebeixinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchShebeixinxiService implements SearchShebeixinxi_Interface {
    @Autowired
    private SearchShebeixinxiDao searchShebeixinxiDao;
    @Override
    public List<Shebeixinxi> searchShebeixinxi(String keywords) {
        return searchShebeixinxiDao.searchShebeixinxi(keywords);
    }
}

