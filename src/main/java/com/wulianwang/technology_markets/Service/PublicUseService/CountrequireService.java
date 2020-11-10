package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Count;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.CountrequireDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Countrequire_Interface;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountrequireService implements Countrequire_Interface {
    @Autowired
    private CountrequireDao countrequireDao;
    @Override
    public Count countrequire(){return countrequireDao.countrequire();}
}
