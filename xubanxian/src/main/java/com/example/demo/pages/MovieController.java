package com.example.demo.pages;

import com.example.demo.domain.Movie;
import com.example.demo.repertories.mapper.MovieMapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/signel")
public class MovieController {

    @Autowired
    MovieMapper movieMapper;

    @RequestMapping("/info")
    public String info(ModelMap map, HttpServletRequest request) {

        String moviename = request.getParameter("id");
        System.out.println(moviename);
        Movie movie = movieMapper.selectByname(request.getParameter("id"));
        map.addAttribute("moviepictureaddress", movie.getPictureaddress());
        map.addAttribute("moviename", movie.getMoviename());
        map.addAttribute("aiqiyi", movie.getAiqiyi());
        map.addAttribute("tengxun", movie.getTengxun());
        map.addAttribute("youku", movie.getYouku());
        map.addAttribute("info", movie.getInfo());

        return "single";
    }

    @RequestMapping("/search")
    public String search(ModelMap map, HttpServletRequest request) {

        String search = request.getParameter("search");
        if (movieMapper.selectByname(search) == null) {
            return "error";

        } else {

            Movie movie = movieMapper.selectByname(request.getParameter("search"));
            map.addAttribute("moviepictureaddress", movie.getPictureaddress());
            map.addAttribute("moviename", movie.getMoviename());
            map.addAttribute("aiqiyi", movie.getAiqiyi());
            map.addAttribute("tengxun", movie.getTengxun());
            map.addAttribute("youku", movie.getYouku());
            map.addAttribute("info", movie.getInfo());
            return "single";

        }


    }


}
