package com.dev.pradeep.SunbaseAssignment.Services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheService {

    Map<String, String> cachedTokens;

    public CacheService(){
        this.cachedTokens = new HashMap<>();
    }

    public boolean isTokenAvailable(String loginId){
        return this.cachedTokens.get(loginId) != null;
    }

    public void addToken(String loginId, String token){
        this.cachedTokens.put(loginId, token);
    }
}
