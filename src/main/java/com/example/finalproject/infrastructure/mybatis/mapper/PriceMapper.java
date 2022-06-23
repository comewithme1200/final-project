package com.example.finalproject.infrastructure.mybatis.mapper;

import com.example.finalproject.core.price.Price;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PriceMapper {
    void create(@Param("price") Price price);

    long getWeekendPrice();

    long getStandardPrice();

    long getRoomPrice();

    long getVipPrice();

    Price getTimePrice();

    long getAmountByName(@Param("name") String name);
}
