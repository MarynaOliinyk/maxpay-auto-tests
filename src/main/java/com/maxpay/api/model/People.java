package com.maxpay.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class People {
    private String name;
    @JsonProperty("homeworld")
    private String homeWorld;
}
