package com.example.demoapi.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Sector parent;

    @OneToMany(mappedBy = "parent")
    @OrderBy("name ASC")
    private List<Sector> children = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "sectors")
    private List<UserEntry> dataEntries;
}
