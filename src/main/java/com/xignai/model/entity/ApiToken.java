package com.xignai.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xignai.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="api_tokens")
public class ApiToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ApiKey;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    private Date validTill;
    @Enumerated(EnumType.STRING)
    private Status status;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_used")
    private Date lastUsed;

    @JsonIgnore
    @ManyToOne(targetEntity=User.class, fetch = FetchType.LAZY)
    @JoinColumn(name="userId")//Optional
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiToken )) return false;
        return id != null && id.equals(((ApiToken) o).getId());
    }
    @Override
    public int hashCode() {
        return 31;
    }
}
