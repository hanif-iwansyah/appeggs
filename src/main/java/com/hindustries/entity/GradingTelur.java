package com.hindustries.entity;

import com.hindustries.util.Constant;
import com.hindustries.util.ResourceLabel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "grading_telur")
@ResourceLabel(Constant.GRADING_TELUR)
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
