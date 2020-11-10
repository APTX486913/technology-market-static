package com.wulianwang.technology_markets.Service.PublicUseService;

import com.wulianwang.technology_markets.DataBaseController.PublicUseDao.DeleteInfDao;
import com.wulianwang.technology_markets.Interface.PublicUseInterface.DeleteInf_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteInfService implements DeleteInf_Interface {
    @Autowired
    private DeleteInfDao deleteInfDao;
    @Override
    public void deleteInf(String moduleName, int identity){
        deleteInfDao.deleteInf(moduleName,identity);
    }
}
