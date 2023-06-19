package com.zanchenko.alexey.registration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mathematicalequation")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MathematicalEquation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "eq_id", nullable = false)
    private Long eq_id;
    @Column(name = "mathematicalequation")
    private String mathematicalequation;
    @Column(name = "equationroot1")
    private double equationroot1;
    @Column(name = "equationroot2")
    private double equationroot2;
}
