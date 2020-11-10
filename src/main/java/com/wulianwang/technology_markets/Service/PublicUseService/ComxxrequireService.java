package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Comxxrequire;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.ComxxrequireDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Comxxrequire_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComxxrequireService implements Comxxrequire_Interface {
    @Autowired
    private ComxxrequireDao comxxrequireDao;
    @Override
    public List<Comxxrequire> comxxrequire(String identity){
        return comxxrequireDao.getComxxrequire(identity);
    }
}
