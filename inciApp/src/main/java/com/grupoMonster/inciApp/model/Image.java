package com.grupoMonster.inciApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "images")
@ToString(exclude = "incidente")
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "URL", nullable = false)
    private String imageUrl;

    @Column(name="ID_CLOUDINARY", nullable = false)
    private String cloudinaryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_incidente", nullable = false)
    private Incidente incidente;

    public Image(String name, String imageUrl, String cloudinaryId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.cloudinaryId = cloudinaryId;
    }
}
