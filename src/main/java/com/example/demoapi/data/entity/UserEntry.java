package com.example.demoapi.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class UserEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "entry_sectors",
            joinColumns = @JoinColumn(name = "entry_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "sector_id", referencedColumnName = "id"))
    private List<Sector> sectors;

    private boolean agreeTerms;

}
