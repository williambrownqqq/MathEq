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
    public MathematicalEquation search(@RequestParam("query") double query) {
        // Implement your search logic here
        // For example, you can query the database or perform any other search operation
        // Return the search results as a list of SearchResult objects
        MathematicalEquation equation = mathEqService.findByEquationroot1(query);
        return equation;
    }
}
