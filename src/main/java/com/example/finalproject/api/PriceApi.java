package com.example.finalproject.api;

import com.example.finalproject.application.price.GetResponse;
import com.example.finalproject.application.price.PriceCreateParam;
import com.example.finalproject.application.price.PriceService;
import com.example.finalproject.core.price.Price;
import com.example.finalproject.core.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
public class PriceApi {
    @Autowired
    PriceService priceService;

    @PostMapping("/create")
    public Price createPrice(@RequestBody PriceCreateParam priceCreateParam) {
        return priceService.create(priceCreateParam);
    }

    @GetMapping()
    public GetResponse getPrice(@RequestParam String premiere_id, @RequestParam String room_id,
                                @AuthenticationPrincipal User user) {
        return priceService.getPrice(premiere_id, room_id, user);
    }
}
