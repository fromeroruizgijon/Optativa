package com.example.boletin1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class enlaceControler {
    @GetMapping("enlaces")
    public String getMethodName() {
        return "enlaces";
    }
    
@GetMapping("nenlace")
public String getMethodName(@RequestParam (name = "id")String id, Model model){
    model.addAttribute("id", id);
    return "nenlace";
}

}
