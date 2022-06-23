package com.example.finalproject.infrastructure.repository;

import com.example.finalproject.application.price.PriceDto;
import com.example.finalproject.core.price.Price;
import com.example.finalproject.core.price.PriceRepository;
import com.example.finalproject.infrastructure.mybatis.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisPriceRepository implements PriceRepository {
    @Autowired
    PriceMapper priceMapper;

    @Override
    public void create(Price price) {
        priceMapper.create(price);
    }

    @Override
    public long getWeekendPrice() {
        return priceMapper.getWeekendPrice();
    }

    @Override
    public long getStandardPrice() {
        return priceMapper.getStandardPrice();
    }

    @Override
    public long getRoomPrice() {
        return priceMapper.getRoomPrice();
    }

    @Override
    public long getVipPrice() {
        return priceMapper.getVipPrice();
    }

    @Override
    public Price getTimePrice() {
        return priceMapper.getTimePrice();
    }

    @Override
    public long getAmountByName(String name) {
        return priceMapper.getAmountByName(name);
    }
}
