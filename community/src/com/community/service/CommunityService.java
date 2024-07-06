package com.community.service;

import module.service.AvailableService;

public class CommunityService implements AvailableService {

    public void available() {
        System.out.println("Community module.service available for use");
    }

    public static void main(String[] args) {
        new CommunityService().available();
    }
}
