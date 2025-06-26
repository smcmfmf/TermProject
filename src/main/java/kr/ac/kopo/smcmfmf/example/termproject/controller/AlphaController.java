package kr.ac.kopo.smcmfmf.example.termproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlphaController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String requestMethod() {
        return "alpha";
    }

    @GetMapping("/alpha1")
    public String alpha1() {
        return "alpha1";
    }

    @GetMapping("/alpha2")
    public String alpha2() {
        return "alpha2";
    }

    @GetMapping("/alpha3")
    public String alpha3() {
        return "alpha3";
    }

    @GetMapping("/alpha4")
    public String alpha4() { return "alpha4"; }

    @PostMapping("/alpha4")
    public String showAlpha4(@RequestParam String car, @RequestParam String color, @RequestParam String why, @RequestParam String date,
            Model model) {
        model.addAttribute("car", car);
        model.addAttribute("color", color);
        model.addAttribute("why", why);
        model.addAttribute("date", date);
        return "alpha4";
    }

    @GetMapping("/alpha5")
    public String alpha5() {
        return "alpha5";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
