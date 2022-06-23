package com.example.finalproject.core.price;

public interface PriceRepository {
    void create(Price price);

    long getWeekendPrice();

    long getStandardPrice();

    long getRoomPrice();

    long getVipPrice();

    Price getTimePrice();

    long getAmountByName(String name);
}
