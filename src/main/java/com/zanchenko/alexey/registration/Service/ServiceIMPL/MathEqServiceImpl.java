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


//    private boolean isRootOfEquation(MathematicalEquation equation) {
//        double root1 = equation.getEquationroot1();
//        double root2 = equation.getEquationroot2();
//        String equationString = equation.getMathematicalequation();
//        // Evaluate the equation with the provided roots
//        double result1 = evaluateEquation(equationString, root1);
//        double result2 = evaluateEquation(equationString, root2);
//        // Check if the results are close to zero (considering a tolerance)
//        double tolerance = 0.001; // Adjust the tolerance value as needed
//        return Math.abs(result1) < tolerance && Math.abs(result2) < tolerance;
//    }
//
//    private double evaluateEquation(String equation, double x) {
//        // Replace 'x' with the provided root value and evaluate the equation
//        equation = equation.replace("x", Double.toString(x));
//        // Evaluate the equation using a math expression parser or your preferred method
//        // Return the result of the evaluation
//        return evaluateExpression(equation);
//    }
//
//    // Implement your own method to evaluate the math expression
//    private double evaluateExpression(String expression) {
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("JavaScript");
//
//        if (engine == null) {
//            throw new UnsupportedOperationException("JavaScript engine is not available.");
//        }
//
//        try {
//            Object result = engine.eval(expression);
//            if (result instanceof Number) {
//                return ((Number) result).doubleValue();
//            } else {
//                throw new IllegalArgumentException("Invalid expression result.");
//            }
//        } catch (ScriptException e) {
//            throw new IllegalArgumentException("Invalid expression.", e);
//        }
//    }


}
