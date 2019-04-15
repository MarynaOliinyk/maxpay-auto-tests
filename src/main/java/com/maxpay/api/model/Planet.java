package com.maxpay.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Planet {
    private String name;
    private long population;
    private List<String> films;
}
