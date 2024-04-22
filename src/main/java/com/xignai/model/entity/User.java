package com.xignai.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @OneToMany(targetEntity=ApiToken.class, cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "user")
    private List<ApiToken> apiTokens = new ArrayList<>();

    public void addApiToken(ApiToken apiToken){
        apiTokens.add(apiToken);
        apiToken.setUser(this);
    }
}
