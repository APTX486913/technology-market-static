package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Sexhuoqu;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.SexhuoquDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Sexhuoqu_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexhuoquService implements Sexhuoqu_Interface {
    @Autowired
    private SexhuoquDao sexhuoquDao;
    @Override
    public List<Sexhuoqu> getsexhuoqu(){
        return sexhuoquDao.getSexhuoqu();
    }
}
