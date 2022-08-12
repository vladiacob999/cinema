package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.itschool.service.MovieService;

@Controller
public class IndexController {

    @Autowired
    private MovieService movieService;


    @RequestMapping(value = {"/index"})
    public String index() {
        return "index";
    }

}
