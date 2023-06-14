package com.harmyFounder.Project.service;

import com.harmyFounder.Project.model.User;
import com.harmyFounder.Project.repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileService {

    @Autowired
    private UserDetailRepo userDetailRepo;

    public User changeStatus(User channel, User subscriber) {
        Set<User> subscribers = channel.getSubscribers();
        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        } else {
            subscribers.add(subscriber);
        }
        return userDetailRepo.save(channel);
    }

}
