package com.xignai.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="assets")
public class Asset {
    private String id;

    private String name;

    private String uploadedOn;

    private String owner;
}
