package com.wulianwang.technology_markets.Service.SearchService;

import com.wulianwang.technology_markets.Bean.Chengguoxinxi;
import com.wulianwang.technology_markets.DataBaseController.SearchDao.SearchChengguoxinxiDao;
import com.wulianwang.technology_markets.Interface.SearchInterface.SearchChengguoxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchChengguoxinxiService implements SearchChengguoxinxi_Interface {
    @Autowired
    private SearchChengguoxinxiDao searchChengguoxinxiDao;
    @Override
    public List<Chengguoxinxi> searchChengguoxinxi(String keywords) {
        return searchChengguoxinxiDao.searchChengguoxinxi(keywords);
    }

}
