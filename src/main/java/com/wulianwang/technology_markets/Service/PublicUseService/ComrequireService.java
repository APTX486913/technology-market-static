package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Comrequire;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ComrequireDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Comrequire_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComrequireService implements Comrequire_Interface{
    @Autowired
    private ComrequireDao comrequireDao;
    @Override
    public List<Comrequire> comrequire (int start_subscript,int pagesize ){
        return comrequireDao.getComrequire(start_subscript,pagesize);
    }
}
