package com.harmyFounder.Project.controller;

import com.harmyFounder.Project.model.User;
import com.harmyFounder.Project.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/{id}")
    public User getProfile(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping("/{channelId}")
    public User changeStatus(@PathVariable("channelId") User channel, @AuthenticationPrincipal User subscriber) {

        if (subscriber.equals(channel)) {
            return channel;
        } else {
            return profileService.changeStatus(channel, subscriber);
        }
    }

}
