package ro.itschool.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.itschool.entity.Movie;
import ro.itschool.service.MovieService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.logging.Logger;

@Controller
public class MovieController {





    @Autowired
    private MovieService movieService;


    //afisam lista de filme
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listMovies", movieService.getAllMovies());
        return "index";
    }


    //new movie page
    @GetMapping("/addNewMovie")
    public String addNewMovie(Model model) {
        Movie movie= new Movie();
        model.addAttribute("movie", movie);
        return "new-movie";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@ModelAttribute("movie") Movie movie){
        //save movie to database
        movieService.saveMovie(movie);
        return "redirect:/";
    }




}

