package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Download;
import com.wulianwang.technology_markets.Bean.Tongzhiliebiao;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TongzhiliebiaoDao {
    @Select("Call getNotification(#{start_subscript},#{pagesize})")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "id", column = "ident", javaType = String.class),
            @Result(property = "headline", column = "headline", javaType = String.class),
            @Result(property = "content", column = "content", javaType = String.class),
            @Result(property = "release_time", column = "release_time", javaType = String.class),

    })
    List<Tongzhiliebiao> getTongzhiliebiao(@Param("start_subscript") int start_subscript, @Param("pagesize") int pagesize);

}
