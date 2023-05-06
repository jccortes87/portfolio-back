package com.project.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditEntity implements Serializable {


    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Column
    private LocalDateTime createdDate;
    @Column
    private String createdBy;
    @Column
    private LocalDateTime updatedDate;
    @Column
    private String updatedBy;


}
