package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Tongzhiliebiao;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.TongzhineirongDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Tongzhineirong_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TongzhineirongService implements Tongzhineirong_Interface {
    @Autowired
    private TongzhineirongDao tongzhineirongDao;
    @Override
    public List<Tongzhiliebiao> tongzhineirong(String notification_id){
        return tongzhineirongDao.getTongzhineirong(notification_id);
    }
}
