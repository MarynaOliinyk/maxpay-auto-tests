package com.maxpay.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Film {
    private String title;
    private List<String> characters;
    private List<String> planets;
}