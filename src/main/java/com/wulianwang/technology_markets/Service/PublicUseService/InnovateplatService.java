package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Innovateplat;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.InnovateplatDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Innovateplat_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InnovateplatService implements Innovateplat_Interface {
    @Autowired
    private InnovateplatDao innovateplatDao;
    @Override
    public List<Innovateplat> innovateplat(int identity, int start_subscript, int pagesize){
        return  innovateplatDao.getInnovateplat(identity,start_subscript,pagesize);
    }


}
