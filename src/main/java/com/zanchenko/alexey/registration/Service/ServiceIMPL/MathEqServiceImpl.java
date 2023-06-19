package com.zanchenko.alexey.registration.Service.ServiceIMPL;

import com.zanchenko.alexey.registration.DTO.MathematicalEquationDTO;
import com.zanchenko.alexey.registration.Entity.MathematicalEquation;
import com.zanchenko.alexey.registration.Repository.MathEqRepository;
import com.zanchenko.alexey.registration.Service.MathEqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class MathEqServiceImpl implements MathEqService {

    @Autowired
    private MathEqRepository mathEqRepository;
    @Override
    public String save(MathematicalEquationDTO mathematicalEquationDTO) {

        String equation = mathematicalEquationDTO.getMathematicalequation();

        if (!isValidEquation(equation)) {
            return "Invalid equation. Please check the equation format.";
        }

        MathematicalEquation mathematicalEquation= new MathematicalEquation(
                mathematicalEquationDTO.getEq_id(),
                equation,
                mathematicalEquationDTO.getEquationroot1(),
                mathematicalEquationDTO.getEquationroot2()
        );

        mathEqRepository.save(mathematicalEquation);

        return mathematicalEquation.getMathematicalequation();

//        if (isRootOfEquation(mathematicalEquation)) {
//            mathEqRepository.save(mathematicalEquation);
//            return "Equation saved successfully.";
//        } else {
//            return "The provided roots are not valid roots of the equation.";
//        }
    }

    public boolean isValidEquation(String equation) {
        String pattern = "^[\\d.*/+-x()\\s]+$";
        return isValidParentheses(equation) && isValidExpression(equation) && equation.matches(pattern);
    }

    public boolean isValidParentheses(String equation) {
        int count = 0;
        for (char c : equation.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    public boolean isValidExpression(String equation) {
        String pattern = "[*/+-]{2}";
        return !Pattern.compile(pattern).matcher(equation).find();
    }

    @Override
    public MathematicalEquation findByEquationroot1(double root) {
        return mathEqRepository.findByEquationroot1(root);
    }


}
