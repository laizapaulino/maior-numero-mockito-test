package com.laipim.maiornumeromockitotest;

import org.springframework.stereotype.Service;

@Service
public class BusinessService {
    private DataService dataService;

    public BusinessService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int encontraOMaior() {
        int[] data = dataService.recuperaTodosOsDados();
        int greatest = Integer.MIN_VALUE;

        for (int value : data) {
            if (value > greatest) {
                greatest = value;
            }
        }
        return greatest;
    }
}