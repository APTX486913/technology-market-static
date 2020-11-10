package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.UpdateVisitsDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.UpdateVisitsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateVisitsService implements UpdateVisitsInterface {
    @Autowired
    UpdateVisitsDao updateVisitsDao;
    @Override
    public void updateVisits(){
        updateVisitsDao.updateVisits();
    };
    @Override
    public int getVisits(){
        return updateVisitsDao.getVisits();
    };
}
