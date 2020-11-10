package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Tongzhiliebiao;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.TongzhiliebiaoDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.Tongzhiliebiao_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TongzhiliebiaoService implements Tongzhiliebiao_Interface {
    @Autowired
    private TongzhiliebiaoDao tongzhiliebiaoDao;
    @Override
    public List<Tongzhiliebiao> tongzhiliebiao(int start_subscript, int pagesize ){
        return tongzhiliebiaoDao.getTongzhiliebiao(start_subscript,pagesize);
    }
}
