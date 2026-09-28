package com.example.demoapi.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserEntryRequest {
    private String name;
    private List<Long> sectorIds;
    private boolean agreeTerms;
}
