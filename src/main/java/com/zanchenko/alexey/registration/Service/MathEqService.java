package com.zanchenko.alexey.registration.Service;

import com.zanchenko.alexey.registration.DTO.MathematicalEquationDTO;
import com.zanchenko.alexey.registration.Entity.MathematicalEquation;

public interface MathEqService{
    String save(MathematicalEquationDTO mathematicalEquationDTO);

    boolean isValidEquation(String equation);

    boolean isValidParentheses(String equation);

    boolean isValidExpression(String equation);

    MathematicalEquation findByEquationroot1(double root);
}
