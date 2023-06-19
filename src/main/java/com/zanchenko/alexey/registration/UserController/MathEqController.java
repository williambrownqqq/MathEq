package com.zanchenko.alexey.registration.UserController;

import com.zanchenko.alexey.registration.DTO.MathematicalEquationDTO;
import com.zanchenko.alexey.registration.Service.MathEqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/matheq")
public class MathEqController {

    @Autowired
    private MathEqService mathEqService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody MathematicalEquationDTO mathematicalEquationDTO){
        String id = mathEqService.save(mathematicalEquationDTO);
        return id;
    }


}
