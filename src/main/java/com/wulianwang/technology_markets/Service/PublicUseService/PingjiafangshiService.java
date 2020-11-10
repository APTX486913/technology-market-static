package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Pingjiafangshi;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.PingjiafangshiDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Pingjiafangshi_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PingjiafangshiService implements Pingjiafangshi_Interface {
    @Autowired
    private PingjiafangshiDao pingjiafangshiDao;

    @Override
    public List<Pingjiafangshi> getpingjiafangshi() {
        return pingjiafangshiDao.getPingjiafangshi();
    }



}
