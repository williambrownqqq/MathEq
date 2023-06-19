package com.zanchenko.alexey.registration.Service;

import com.zanchenko.alexey.registration.DTO.MathematicalEquationDTO;
import com.zanchenko.alexey.registration.Entity.MathematicalEquation;

import java.util.List;

public interface MathEqService{
    String save(MathematicalEquationDTO mathematicalEquationDTO);

    boolean isValidEquation(String equation);

    boolean isValidParentheses(String equation);

    boolean isValidExpression(String equation);

    List<MathematicalEquation> findAllByEquationroot1(double root);
}
