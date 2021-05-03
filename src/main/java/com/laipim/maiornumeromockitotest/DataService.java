package com.laipim.maiornumeromockitotest;

import org.springframework.stereotype.Repository;

@Repository
public class DataService {
    public int[] recuperaTodosOsDados() {
        return new int[] { 5, 10, 15, 20, 25 };
    }
}