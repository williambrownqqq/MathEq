package com.zanchenko.alexey.registration.Controller;

import com.zanchenko.alexey.registration.DTO.MathematicalEquationDTO;
import com.zanchenko.alexey.registration.Entity.MathematicalEquation;
import com.zanchenko.alexey.registration.Service.MathEqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/search")
    public List<MathematicalEquation> search(@RequestParam("query") double query) {
        List<MathematicalEquation> equations = mathEqService.findAllByEquationroot1(query);
        if (equations != null) {
            return equations;
        } else {
            System.out.println("empty");
            return null; // Or return an appropriate response
        }
    }
}
