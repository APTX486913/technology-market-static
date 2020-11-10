package com.wulianwang.technology_markets.Service.FiltrateService;

import com.wulianwang.technology_markets.Bean.Comxxrequire;
import com.wulianwang.technology_markets.DataBaseController.FiltrateDao.FiltrategetRequirementDao;
import com.wulianwang.technology_markets.Interface.FiltrateInterface.FiltrategetRequirementInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Repository
public class FiltrategetRequirementService implements FiltrategetRequirementInterface {
    @Autowired
    FiltrategetRequirementDao filtrategetRequirementDao;
    @Override
    public List<Comxxrequire> filtrategetRequirement(String requirement_type,
                                              int start_subscript,
                                              int pagesize){
        return filtrategetRequirementDao.filtrategetRequirement(requirement_type, start_subscript, pagesize);
    };
}
