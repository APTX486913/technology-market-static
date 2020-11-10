package com.wulianwang.technology_markets.Interface.FiltrateInterface;

import com.wulianwang.technology_markets.Bean.Comxxrequire;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface FiltrategetRequirementInterface {
    List<Comxxrequire> filtrategetRequirement(String requirement_type,
                                              int start_subscript,
                                              int pagesize);
}
