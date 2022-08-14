package ro.itschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import ro.itschool.entity.Movie;
import ro.itschool.repository.MovieRepository;
import ro.itschool.service.MovieService;
import ro.itschool.util.FileUploadUtil;

import java.io.*;

@Controller
public class MovieController {


    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepository movieRepository;

    //afisam lista de filme
    @GetMapping("/index")
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
    public RedirectView saveMovie(@ModelAttribute("movie") Movie movie,
                                  @RequestParam("image") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        movie.setPhotos(fileName);

//        save movie to database
//        movieService.saveMovie(movie);
       Movie saveMovie = movieService.saveMovie(movie);

        String uploadDir = "movie-photos/" + saveMovie.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return new RedirectView("/", true);
    }


    @GetMapping("/movie/{id}")
    public String movie(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieRepository.findById(id).get());
        return "movie";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") Long id){
        movieRepository.deleteById(id);
        return "redirect:/index";
    }



}

