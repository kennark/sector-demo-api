package com.example.demoapi.api.controller;

import com.example.demoapi.api.dto.UserEntryRequest;
import com.example.demoapi.data.entity.Sector;
import com.example.demoapi.data.entity.UserEntry;
import com.example.demoapi.data.repository.SectorRepository;
import com.example.demoapi.service.interfaces.UserEntryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
public class ApiController {
    private SectorRepository sectorRepository;
    private UserEntryService userEntryService;

    @GetMapping("sectors")
    public List<Sector> GetSectors() {
        return sectorRepository.findAllByParentIsNull();
    }

    @PostMapping("userData")
    public UserEntry PostUserData(@RequestBody UserEntryRequest entry) {
        return userEntryService.saveUserEntry(entry);
    }

    @GetMapping("userData/{id}")
    public Optional<UserEntry> GetUserData(@PathVariable Long id) {
        return userEntryService.getUserEntry(id);
    }

    @PatchMapping("userData")
    public UserEntry PatchUserData(@RequestBody UserEntryRequest entry) {
        return userEntryService.updateUserEntry(entry);
    }
}
