package com.dev.pradeep.SunbaseAssignment.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginDto {

    @JsonProperty("login_id")
    String loginId = "";

    @JsonProperty("password")
    String password = "";

}
