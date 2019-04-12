package com.island.monster.mapper;

import com.island.monster.bean.VisitorStorehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VisitorStorehouseMapper {

    int insertSelective(VisitorStorehouse visitorStorehouse);

    int updateByPrimaryKeySelective(VisitorStorehouse visitorStorehouse);

    List<VisitorStorehouse> getByConditions(VisitorStorehouse visitorStorehouse);

    VisitorStorehouse selectByPrimaryKey(Integer id);
}
