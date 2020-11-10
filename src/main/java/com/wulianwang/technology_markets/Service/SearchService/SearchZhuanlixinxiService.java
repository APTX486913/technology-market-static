package com.wulianwang.technology_markets.Service.SearchService;

import com.wulianwang.technology_markets.Bean.Zhuanlixinxi;
import com.wulianwang.technology_markets.DataBaseController.SearchDao.SearchZhuanlixinxiDao;
import com.wulianwang.technology_markets.Interface.SearchInterface.SearchZhuanlixinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchZhuanlixinxiService implements SearchZhuanlixinxi_Interface {
    @Autowired
    private SearchZhuanlixinxiDao searchZhuanlixinxiDao;
    @Override
    public List<Zhuanlixinxi> searchZhuanlixinxi(String keywords) {
        return searchZhuanlixinxiDao.searchZhuanlixinxi(keywords);
    }


}

