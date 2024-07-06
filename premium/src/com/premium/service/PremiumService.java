package com.premium.service;

import module.service.AvailableService;

public class PremiumService implements AvailableService {

    public void available() {
        System.out.println("Premium module.service available for use");
    }

    public static void main(String[] args) {
        new PremiumService().available();
    }
}
