package com.wulianwang.technology_markets.Service.SearchService;

import com.wulianwang.technology_markets.Bean.Innovateplat;
import com.wulianwang.technology_markets.DataBaseController.SearchDao.SearchInnovateplatDao;
import com.wulianwang.technology_markets.Interface.SearchInterface.SearchInnovateplat_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchInnovateplatService implements SearchInnovateplat_Interface {
    @Autowired
    private SearchInnovateplatDao searchInnovateplatDao;
    @Override
    public List<Innovateplat> searchInnovateplat(String keywords) {
        return searchInnovateplatDao.searchInnovateplat(keywords);
    }
}
