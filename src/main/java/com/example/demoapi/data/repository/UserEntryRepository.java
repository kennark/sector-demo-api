package com.example.demoapi.data.repository;

import com.example.demoapi.data.entity.UserEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntryRepository extends JpaRepository<UserEntry, Long> {
}
