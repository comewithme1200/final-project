package com.example.finalproject.api;

import com.example.finalproject.api.exception.InvalidAuthenticationException;
import com.example.finalproject.application.statistical.CinemaTurnOver;
import com.example.finalproject.application.statistical.MovieTurnOver;
import com.example.finalproject.application.statistical.StatisticalService;
import com.example.finalproject.core.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistical")
public class StatisticalApi {

    @Autowired
    StatisticalService statisticalService;

    @GetMapping("/movieturnover")
    public List<MovieTurnOver> getMovieTurnover(@AuthenticationPrincipal User user) throws InvalidAuthenticationException {
        if (!user.getRole().equals("ad")) {
            throw new InvalidAuthenticationException();
        }
        return statisticalService.getMovieTurnover();
    }

    @GetMapping("/cinematurnover")
    public List<CinemaTurnOver> getCinemaTurnover(@AuthenticationPrincipal User user) throws InvalidAuthenticationException {
        if (!user.getRole().equals("ad")) {
            throw new InvalidAuthenticationException();
        }
        return statisticalService.getCinemaTurnover();
    }

    @GetMapping("/turnover")
    public Long getTurnover(@AuthenticationPrincipal User user) throws InvalidAuthenticationException {
        if (!user.getRole().equals("ad")) {
            throw new InvalidAuthenticationException();
        }
        return statisticalService.getTurnover();
    }
}
