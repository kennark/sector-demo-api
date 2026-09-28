package com.example.demoapi.service;

import com.example.demoapi.api.dto.UserEntryRequest;
import com.example.demoapi.data.entity.Sector;
import com.example.demoapi.data.entity.UserEntry;
import com.example.demoapi.data.repository.SectorRepository;
import com.example.demoapi.data.repository.UserEntryRepository;
import com.example.demoapi.service.interfaces.UserEntryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserEntryServiceImpl implements UserEntryService {

    private UserEntryRepository entryRepository;
    private SectorRepository sectorRepository;

    @Override
    public UserEntry saveUserEntry(UserEntryRequest entry) {
        if (validateUserEntry(entry)) {
            UserEntry dataToSave = new UserEntry();
            dataToSave.setName(entry.getName());
            dataToSave.setAgreeTerms(entry.isAgreeTerms());
            dataToSave.setSectors(sectorRepository.findAllById(entry.getSectorIds()));

            UserEntry data = entryRepository.saveAndFlush(dataToSave);
            removeChildSectors(data);
            return data;
        }

        throw new IllegalArgumentException("Please fill all fields.");
    }

    @Override
    public Optional<UserEntry> getUserEntry(Long id) {
        Optional<UserEntry> entryOrNull = entryRepository.findById(id);
        entryOrNull.ifPresent(this::removeChildSectors);
        return entryOrNull;
    }

    /**
     * Validates that all user entry fields are filled.
     *
     * @param entry Entry to check
     * @return True if all fields are filled, false otherwise
     */
    private boolean validateUserEntry(UserEntryRequest entry) {
        return !entry.getName().isEmpty() && !entry.getSectorIds().isEmpty() && entry.isAgreeTerms();
    }

    /**
     * Remove child sectors from the user entry sectors
     */
    private void removeChildSectors(UserEntry entry) {
        entry.getSectors().forEach((Sector sector) -> sector.setChildren(Collections.emptyList()));
    }
}
