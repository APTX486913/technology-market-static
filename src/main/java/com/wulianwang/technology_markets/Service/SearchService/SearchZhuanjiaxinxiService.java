package com.wulianwang.technology_markets.Service.SearchService;

import com.wulianwang.technology_markets.Bean.Zhuanjiaxinxi;
import com.wulianwang.technology_markets.DataBaseController.SearchDao.SearchZhuanjiaxinxiDao;
import com.wulianwang.technology_markets.Interface.SearchInterface.SearchZhuanjiaxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchZhuanjiaxinxiService implements SearchZhuanjiaxinxi_Interface {
    @Autowired
    private SearchZhuanjiaxinxiDao searchZhuanjiaxinxiDao;
    @Override
    public List<Zhuanjiaxinxi> searchZhuanjiaxinxi(String keywords) {
        return searchZhuanjiaxinxiDao.searchZhuanjiaxinxi(keywords);
    }
}

