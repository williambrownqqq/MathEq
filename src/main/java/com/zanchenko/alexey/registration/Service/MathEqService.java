package com.zanchenko.alexey.registration.Service;

import com.zanchenko.alexey.registration.DTO.MathematicalEquationDTO;

public interface MathEqService {
    String save(MathematicalEquationDTO mathematicalEquationDTO);

    boolean isValidEquation(String equation);

    boolean isValidParentheses(String equation);

    boolean isValidExpression(String equation);
}
