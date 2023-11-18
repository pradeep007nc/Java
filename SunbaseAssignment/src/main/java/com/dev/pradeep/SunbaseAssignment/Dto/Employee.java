package com.dev.pradeep.SunbaseAssignment.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.*;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @JsonProperty("uuid")
    public String uuid;

    @JsonProperty("first_name")
    String firstName;

    @JsonProperty("last_name")
    String lastName;

    @JsonProperty("street")
    String street;

    @JsonProperty("address")
    String address;

    @JsonProperty("city")
    String city;

    @JsonProperty("state")
    String state;

    @JsonProperty("email")
    String email;

    @JsonProperty("phone")
    String phone;

    public String generateUUID(){
        return String.valueOf(UUID.randomUUID());
    }
}
