package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Count;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CountItemsDao {
    @Select("Call CountItems(#{moduleName},#{org_id})")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "countResult", column = "count", javaType = int.class)
    })
    Count countItems(@Param("moduleName") String moduleName,@Param("org_id") int org_id);


}
