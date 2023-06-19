package com.zanchenko.alexey.registration.DTO;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MathematicalEquationDTO {
    private Long eq_id;
    private String mathematicalequation;
    private double equationroot1;
    private double equationroot2;
}
