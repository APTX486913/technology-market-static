package com.wulianwang.technology_markets.DataBaseController.PublicUseDao;

import com.wulianwang.technology_markets.Bean.Pingtaisort;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PingtaisortDao {
    @Select("Call getPlatform_classification()")
    @Results({
            //property内容为抽象层类的成员变量名，column内容为对应数据库表的字段名
            @Result(property = "id", column = "ident", javaType = String.class),


            @Result(property = "sorts", column = "sorts", javaType = String.class),
            @Result(property = "value", column = "value", javaType = int.class)
    })
    List<Pingtaisort> getPingtaisort();
}
