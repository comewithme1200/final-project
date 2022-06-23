package com.example.finalproject.application.price;

import com.example.finalproject.application.room.RoomInfo;
import com.example.finalproject.core.premiere.Premiere;
import com.example.finalproject.core.premiere.PremiereRepository;
import com.example.finalproject.core.price.Price;
import com.example.finalproject.core.price.PriceRepository;
import com.example.finalproject.core.rooms.RoomRepository;
import com.example.finalproject.core.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    @Autowired
    PriceRepository priceRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    PremiereRepository premiereRepository;

    public Price create(PriceCreateParam priceCreateParam) {
        Price newPrice = new Price(priceCreateParam.getName(), priceCreateParam.getDetail(),
                priceCreateParam.getAmount());

        priceRepository.create(newPrice);
        return newPrice;
    }

    public GetResponse getPrice(String premiere_id, String room_id, User user) {
        Premiere premiereFullInfo = premiereRepository.getPremiereById(premiere_id);
        RoomInfo roomInfo = roomRepository.findRoomById(room_id);
        long timeAmount = 0;
        long weekendAmount = 0;
        long roomAmount = 0;
        Price timePrice = priceRepository.getTimePrice();
        String[] time = timePrice.getDetail().split("-");
        if (premiereFullInfo.getStart_time().getHours() >= Integer.parseInt(time[0]) && premiereFullInfo.getStart_time().getHours() <= Integer.parseInt(time[1])) {
            timeAmount = timePrice.getAmount();
        }
        if (premiereFullInfo.getStart_time().getDay() == 6 || premiereFullInfo.getStart_time().getDay() == 7) {
            weekendAmount = priceRepository.getWeekendPrice();
        }
        if (roomInfo.getRoom_type().equals("Golden")) {
            roomAmount = priceRepository.getRoomPrice();
        }
        long levelBonus = priceRepository.getAmountByName(user.getLevel());
        long standardPrice =
                (priceRepository.getStandardPrice() + timeAmount + roomAmount + weekendAmount);
        long vipPrice = (priceRepository.getVipPrice() + timeAmount + roomAmount + weekendAmount);
        long resultStandard = standardPrice - (standardPrice * (levelBonus/100));
        long resultVip = vipPrice - (vipPrice * (levelBonus/100));
        return new GetResponse(resultStandard, resultVip);
    }
}
