package com.example.demoapi.service.interfaces;

import com.example.demoapi.api.dto.UserEntryRequest;
import com.example.demoapi.data.entity.UserEntry;

import java.util.Optional;


public interface UserEntryService {

    UserEntry saveUserEntry(UserEntryRequest entry);

    UserEntry updateUserEntry(UserEntryRequest entry);

    Optional<UserEntry> getUserEntry(Long id);
}
