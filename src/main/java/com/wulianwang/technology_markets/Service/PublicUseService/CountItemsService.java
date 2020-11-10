package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.Bean.Count;
import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.CountItemsDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.CountItems_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountItemsService implements CountItems_Interface {
    @Autowired
    private CountItemsDao countItemsDao;
    @Override
    public Count countItems(String moduleName,int org_id) {
        return countItemsDao.countItems(moduleName,org_id);
    }


}
