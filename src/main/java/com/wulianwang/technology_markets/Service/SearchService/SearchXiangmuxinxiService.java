package com.wulianwang.technology_markets.Service.SearchService;

import com.wulianwang.technology_markets.Bean.Xiangmuxinxi;
import com.wulianwang.technology_markets.DataBaseController.SearchDao.SearchXiangmuxinxiDao;
import com.wulianwang.technology_markets.Interface.SearchInterface.SearchXiangmuxinxi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchXiangmuxinxiService implements SearchXiangmuxinxi_Interface {
    @Autowired
    private SearchXiangmuxinxiDao searchXiangmuxinxiDao;

    @Override
    public List<Xiangmuxinxi> searchXiangmuxinxi(String keywords){
        return searchXiangmuxinxiDao.searchXiangmuxinxi(keywords);}
}

