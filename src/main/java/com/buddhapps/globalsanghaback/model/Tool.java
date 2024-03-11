package com.buddhapps.globalsanghaback.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TOOL")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private Boolean available = true;

    @Column(name = "status")
    private String status; // Estado de la herramienta (nuevo, roto, viejo, para reciclar, etc.)

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner; // Relación con la entidad User

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
