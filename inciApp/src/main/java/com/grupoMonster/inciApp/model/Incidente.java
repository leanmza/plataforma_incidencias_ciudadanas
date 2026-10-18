package com.grupoMonster.inciApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "incidentes")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;

    @ManyToOne
    @JoinColumn(name="id_departamento")
    private Departamento departamento;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name="id_tipo")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne
    private Prioridad prioridad;

    @OneToMany(mappedBy = "incidente",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();
}
