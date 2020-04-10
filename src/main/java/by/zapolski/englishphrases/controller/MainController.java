package by.zapolski.englishphrases.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("check")
    public String main(){
        return "check-word";
    }
}
