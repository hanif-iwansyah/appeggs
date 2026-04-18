package com.hindustries.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "grading_telur")
@Getter
@Setter
public class GradingTelur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produksi_telur_id", nullable = false)
    private ProduksiTelur produksiTelur;
    @Column(name = "grade_a")
    private int gradeA;
    @Column(name = "grade_b")
    private int gradeB;
    @Column(name = "grade_c")
    private int gradeC;
}
