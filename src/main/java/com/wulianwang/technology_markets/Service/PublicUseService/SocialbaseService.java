package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Socialbase;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.SocialbaseDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Socialbase_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialbaseService implements Socialbase_Interface {
    @Autowired
    private SocialbaseDao socialbaseDao;
    @Override
    public List<Socialbase> socialbase(int identity, int start_subscript, int pagesize){
        return socialbaseDao.getSocialbase(identity,start_subscript,pagesize);
    }
}
