package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Socialresult;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.SocialresultDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Socialresult_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialresultService implements Socialresult_Interface {
    @Autowired
    private SocialresultDao socialresultDao;
    @Override
    public List<Socialresult> socialresult(int identity, int start_subscript, int pagesize) {
        return socialresultDao.getsocialresult(identity,start_subscript,pagesize);
    }
}
