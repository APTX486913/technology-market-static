package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Pingtaisort;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.PingtaisortDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Pingtaisort_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PingtaisortService implements Pingtaisort_Interface {
    @Autowired
    private PingtaisortDao pingtaisortDao;
    @Override
    public List<Pingtaisort> getpingtaisort(){
        return  pingtaisortDao.getPingtaisort();
    }

}
