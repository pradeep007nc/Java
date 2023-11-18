package com.dev.pradeep.SunbaseAssignment.Services;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    String loginId;
    @Getter
    String token;


    public boolean isTokenAvailable(){
        return this.token != null;
    }

    public void addToken(String loginId, String token){
        this.token = token;
        this.loginId = loginId;
    }

}
