/**
 * 页面跳转控制类
 */
package com.example.demo.pages;

import com.example.demo.domain.*;
import com.example.demo.repertories.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;


@Controller
@RequestMapping("/pages")
public class PagesController {
    @Autowired
    Movie1Mapper movie1Mapper;

    @Autowired
    Movie2Mapper movie2Mapper;
    @Autowired
    Movie3Mapper movie3Mapper;

    //首页
    @RequestMapping("/index")
    public String index(ModelMap map) {

        //显示广告内容（movie1）内容在页面上
        Movie1 movie11 = movie1Mapper.selectById(1);
        Movie1 movie12 = movie1Mapper.selectById(2);
        Movie1 movie13 = movie1Mapper.selectById(3);
        Movie1 movie14 = movie1Mapper.selectById(4);
        Movie1 movie15 = movie1Mapper.selectById(5);
        Movie1 movie16 = movie1Mapper.selectById(6);

        map.addAttribute("movie1pictureaddress1", movie11.getPictureaddress());
        map.addAttribute("movie1name1", movie11.getName());
        map.addAttribute("movie1info1", movie11.getInfo());
        map.addAttribute("movie1href1", movie11.getHref());

        map.addAttribute("movie1pictureaddress2", movie12.getPictureaddress());
        map.addAttribute("movie1name2", movie12.getName());
        map.addAttribute("movie1info2", movie12.getInfo());
        map.addAttribute("movie1href2", movie12.getHref());
        map.addAttribute("info", movie12.getInfo());

        map.addAttribute("movie1pictureaddress3", movie13.getPictureaddress());
        map.addAttribute("movie1name3", movie13.getName());
        map.addAttribute("movie1info3", movie13.getInfo());
        map.addAttribute("movie1href3", movie13.getHref());

        map.addAttribute("movie1pictureaddress4", movie14.getPictureaddress());
        map.addAttribute("movie1name4", movie14.getName());
        map.addAttribute("movie1info4", movie14.getInfo());
        map.addAttribute("movie1href4", movie14.getHref());

        map.addAttribute("movie1pictureaddress5", movie15.getPictureaddress());
        map.addAttribute("movie1name5", movie15.getName());
        map.addAttribute("movie1info5", movie15.getInfo());
        map.addAttribute("movie1href5", movie15.getHref());

        map.addAttribute("movie1pictureaddress6", movie16.getPictureaddress());
        map.addAttribute("movie1name6", movie16.getName());
        map.addAttribute("movie1info6", movie16.getInfo());
        map.addAttribute("movie1href6", movie16.getHref());

        //movie2展示页面
        Movie2 movie21 = movie2Mapper.selectById(1);
        Movie2 movie22 = movie2Mapper.selectById(2);
        Movie2 movie23 = movie2Mapper.selectById(3);
        Movie2 movie24 = movie2Mapper.selectById(4);
        Movie2 movie25 = movie2Mapper.selectById(5);
        Movie2 movie26 = movie2Mapper.selectById(6);
        Movie2 movie27 = movie2Mapper.selectById(7);
        Movie2 movie28 = movie2Mapper.selectById(8);
        Movie2 movie29 = movie2Mapper.selectById(9);

        map.addAttribute("movie2pictureaddress1", movie21.getPictureaddress());
        map.addAttribute("movie2name1", movie21.getName());
        map.addAttribute("movie2years1", movie21.getYears());

        map.addAttribute("movie2pictureaddress2", movie22.getPictureaddress());
        map.addAttribute("movie2name2", movie22.getName());
        map.addAttribute("movie2years2", movie22.getYears());

        map.addAttribute("movie2pictureaddress3", movie23.getPictureaddress());
        map.addAttribute("movie2name3", movie23.getName());
        map.addAttribute("movie2years3", movie23.getYears());


        map.addAttribute("movie2pictureaddress4", movie24.getPictureaddress());
        map.addAttribute("movie2name4", movie24.getName());
        map.addAttribute("movie2years4", movie24.getYears());

        map.addAttribute("movie2pictureaddress5", movie25.getPictureaddress());
        map.addAttribute("movie2name5", movie25.getName());
        map.addAttribute("movie2years5", movie25.getYears());

        map.addAttribute("movie2pictureaddress6", movie26.getPictureaddress());
        map.addAttribute("movie2name6", movie26.getName());
        map.addAttribute("movie2years6", movie26.getYears());

        map.addAttribute("movie2pictureaddress7", movie27.getPictureaddress());
        map.addAttribute("movie2name7", movie27.getName());
        map.addAttribute("movie2years7", movie27.getYears());

        map.addAttribute("movie2pictureaddress8", movie28.getPictureaddress());
        map.addAttribute("movie2name8", movie28.getName());
        map.addAttribute("movie2years8", movie28.getYears());

        map.addAttribute("movie2pictureaddress9", movie29.getPictureaddress());
        map.addAttribute("movie2name9", movie29.getName());
        map.addAttribute("movie2years9", movie29.getYears());

        //热门电影展示

        Movie3 movie31 = movie3Mapper.selectById(1);
        Movie3 movie32 = movie3Mapper.selectById(2);
        Movie3 movie33 = movie3Mapper.selectById(3);
        Movie3 movie34 = movie3Mapper.selectById(4);
        Movie3 movie35 = movie3Mapper.selectById(5);
        Movie3 movie36 = movie3Mapper.selectById(6);
        Movie3 movie37 = movie3Mapper.selectById(7);
        Movie3 movie38 = movie3Mapper.selectById(8);
        Movie3 movie39 = movie3Mapper.selectById(9);
        Movie3 movie310 = movie3Mapper.selectById(10);
        Movie3 movie311 = movie3Mapper.selectById(11);
        Movie3 movie312 = movie3Mapper.selectById(12);


        map.addAttribute("moviename1", movie31.getName());
        map.addAttribute("moviepictureaddress1", movie31.getPictureaddress());
        map.addAttribute("movieyears1", movie31.getYears());

        map.addAttribute("moviename2", movie32.getName());
        map.addAttribute("moviepictureaddress2", movie32.getPictureaddress());
        map.addAttribute("movieyears2", movie32.getYears());

        map.addAttribute("moviename3", movie33.getName());
        map.addAttribute("moviepictureaddress3", movie33.getPictureaddress());
        map.addAttribute("movieyears3", movie33.getYears());

        map.addAttribute("moviename4", movie34.getName());
        map.addAttribute("moviepictureaddress4", movie34.getPictureaddress());
        map.addAttribute("movieyears4", movie34.getYears());

        map.addAttribute("moviename5", movie35.getName());
        map.addAttribute("moviepictureaddress5", movie35.getPictureaddress());
        map.addAttribute("movieyears5", movie35.getYears());

        map.addAttribute("moviename6", movie36.getName());
        map.addAttribute("moviepictureaddress6", movie36.getPictureaddress());
        map.addAttribute("movieyears6", movie36.getYears());

        map.addAttribute("moviename", movie31.getName());
        map.addAttribute("moviepictureaddress1", movie31.getPictureaddress());
        map.addAttribute("movieyears1", movie31.getYears());

        map.addAttribute("moviename7", movie37.getName());
        map.addAttribute("moviepictureaddress7", movie37.getPictureaddress());
        map.addAttribute("movieyears7", movie37.getYears());

        map.addAttribute("moviename8", movie38.getName());
        map.addAttribute("moviepictureaddress8", movie38.getPictureaddress());
        map.addAttribute("movieyears8", movie38.getYears());


        map.addAttribute("moviename9", movie39.getName());
        map.addAttribute("moviepictureaddress9", movie39.getPictureaddress());
        map.addAttribute("movieyears9", movie39.getYears());

        map.addAttribute("moviename10", movie310.getName());
        map.addAttribute("moviepictureaddress10", movie310.getPictureaddress());
        map.addAttribute("movieyears10", movie310.getYears());

        map.addAttribute("moviename11", movie311.getName());
        map.addAttribute("moviepictureaddress11", movie311.getPictureaddress());
        map.addAttribute("movieyears11", movie311.getYears());

        map.addAttribute("moviename12", movie312.getName());
        map.addAttribute("moviepictureaddress12", movie312.getPictureaddress());
        map.addAttribute("movieyears12", movie312.getYears());


        return "index";
    }

    //动作片
    @Autowired
    ActionMovieMapper actionMovieMapper;

    @RequestMapping("/action")
    public String action(ModelMap map) {
        //显示动作片
        ActionMovie actionMovie1 = actionMovieMapper.selectById(1);
        ActionMovie actionMovie2 = actionMovieMapper.selectById(2);
        ActionMovie actionMovie3 = actionMovieMapper.selectById(3);
        ActionMovie actionMovie4 = actionMovieMapper.selectById(4);
        ActionMovie actionMovie5 = actionMovieMapper.selectById(5);
        ActionMovie actionMovie6 = actionMovieMapper.selectById(6);
        ActionMovie actionMovie7 = actionMovieMapper.selectById(7);
        ActionMovie actionMovie8 = actionMovieMapper.selectById(8);
        ActionMovie actionMovie9 = actionMovieMapper.selectById(9);
        ActionMovie actionMovie10 = actionMovieMapper.selectById(10);
        ActionMovie actionMovie11 = actionMovieMapper.selectById(11);
        ActionMovie actionMovie12 = actionMovieMapper.selectById(12);
        ActionMovie actionMovie13 = actionMovieMapper.selectById(13);
        ActionMovie actionMovie14 = actionMovieMapper.selectById(14);
        ActionMovie actionMovie15 = actionMovieMapper.selectById(15);
        ActionMovie actionMovie16 = actionMovieMapper.selectById(16);
        ActionMovie actionMovie17 = actionMovieMapper.selectById(17);
        ActionMovie actionMovie18 = actionMovieMapper.selectById(18);
        System.out.println(actionMovie1.getPictureaddress());
        System.out.println(actionMovie13.getName());
        map.addAttribute("moviename1", actionMovie1.getName());
        map.addAttribute("moviepictureaddress1", actionMovie1.getPictureaddress());
        map.addAttribute("movieyears1", actionMovie1.getYears());

        map.addAttribute("moviename2", actionMovie2.getName());
        map.addAttribute("moviepictureaddress2", actionMovie2.getPictureaddress());
        map.addAttribute("movieyears2", actionMovie2.getYears());

        map.addAttribute("moviename3", actionMovie3.getName());
        map.addAttribute("moviepictureaddress3", actionMovie3.getPictureaddress());
        map.addAttribute("movieyears3", actionMovie3.getYears());

        map.addAttribute("moviename4", actionMovie4.getName());
        map.addAttribute("moviepictureaddress4", actionMovie4.getPictureaddress());
        map.addAttribute("movieyears4", actionMovie4.getYears());

        map.addAttribute("moviename5", actionMovie5.getName());
        map.addAttribute("moviepictureaddress5", actionMovie5.getPictureaddress());
        map.addAttribute("movieyears5", actionMovie5.getYears());

        map.addAttribute("moviename6", actionMovie6.getName());
        map.addAttribute("moviepictureaddress6", actionMovie6.getPictureaddress());
        map.addAttribute("movieyears6", actionMovie6.getYears());

        map.addAttribute("moviename7", actionMovie7.getName());
        map.addAttribute("moviepictureaddress7", actionMovie7.getPictureaddress());
        map.addAttribute("movieyears7", actionMovie7.getYears());

        map.addAttribute("moviename8", actionMovie8.getName());
        map.addAttribute("moviepictureaddress8", actionMovie8.getPictureaddress());
        map.addAttribute("movieyears8", actionMovie8.getYears());

        map.addAttribute("moviename9", actionMovie9.getName());
        map.addAttribute("moviepictureaddress9", actionMovie9.getPictureaddress());
        map.addAttribute("movieyears9", actionMovie9.getYears());

        map.addAttribute("moviename10", actionMovie10.getName());
        map.addAttribute("moviepictureaddress10", actionMovie10.getPictureaddress());
        map.addAttribute("movieyears10", actionMovie10.getYears());

        map.addAttribute("moviename11", actionMovie11.getName());
        map.addAttribute("moviepictureaddress11", actionMovie11.getPictureaddress());
        map.addAttribute("movieyears11", actionMovie11.getYears());

        map.addAttribute("moviename12", actionMovie12.getName());
        map.addAttribute("moviepictureaddress12", actionMovie12.getPictureaddress());
        map.addAttribute("movieyears12", actionMovie12.getYears());

        map.addAttribute("moviename13", actionMovie13.getName());
        System.out.println(actionMovie13.getName());
        map.addAttribute("moviepictureaddress13", actionMovie13.getPictureaddress());
        map.addAttribute("movieyears13", actionMovie13.getYears());

        map.addAttribute("moviename14", actionMovie14.getName());
        map.addAttribute("moviepictureaddress14", actionMovie14.getPictureaddress());
        map.addAttribute("movieyears14", actionMovie14.getYears());

        map.addAttribute("moviename15", actionMovie15.getName());
        map.addAttribute("moviepictureaddress15", actionMovie15.getPictureaddress());
        map.addAttribute("movieyears15", actionMovie15.getYears());

        map.addAttribute("moviename16", actionMovie16.getName());
        map.addAttribute("moviepictureaddress16", actionMovie16.getPictureaddress());
        map.addAttribute("movieyears16", actionMovie16.getYears());

        map.addAttribute("moviename17", actionMovie17.getName());
        map.addAttribute("moviepictureaddress17", actionMovie17.getPictureaddress());
        map.addAttribute("movieyears17", actionMovie17.getYears());

        map.addAttribute("moviename18", actionMovie18.getName());
        map.addAttribute("moviepictureaddress18", actionMovie18.getPictureaddress());
        map.addAttribute("movieyears18", actionMovie18.getYears());


        return "action";
    }

    //爱情片
    @Autowired
    LoveMovieMapper loveMovieMapper;

    @RequestMapping("/love")
    public String love(ModelMap map) {

        LoveMovie actionMovie1 = loveMovieMapper.selectById(1);
        LoveMovie actionMovie2 = loveMovieMapper.selectById(2);
        LoveMovie actionMovie3 = loveMovieMapper.selectById(3);
        LoveMovie actionMovie4 = loveMovieMapper.selectById(4);
        LoveMovie actionMovie5 = loveMovieMapper.selectById(5);
        LoveMovie actionMovie6 = loveMovieMapper.selectById(6);
        LoveMovie actionMovie7 = loveMovieMapper.selectById(7);
        LoveMovie actionMovie8 = loveMovieMapper.selectById(8);
        LoveMovie actionMovie9 = loveMovieMapper.selectById(9);
        LoveMovie actionMovie10 = loveMovieMapper.selectById(10);
        LoveMovie actionMovie11 = loveMovieMapper.selectById(11);
        LoveMovie actionMovie12 = loveMovieMapper.selectById(12);
        LoveMovie actionMovie13 = loveMovieMapper.selectById(13);
        LoveMovie actionMovie14 = loveMovieMapper.selectById(14);
        LoveMovie actionMovie15 = loveMovieMapper.selectById(15);
        LoveMovie actionMovie16 = loveMovieMapper.selectById(16);
        LoveMovie actionMovie17 = loveMovieMapper.selectById(17);
        LoveMovie actionMovie18 = loveMovieMapper.selectById(18);

        map.addAttribute("moviename1", actionMovie1.getName());
        map.addAttribute("moviepictureaddress1", actionMovie1.getPictureaddress());
        map.addAttribute("movieyears1", actionMovie1.getYears());

        map.addAttribute("moviename2", actionMovie2.getName());
        map.addAttribute("moviepictureaddress2", actionMovie2.getPictureaddress());
        map.addAttribute("movieyears2", actionMovie2.getYears());

        map.addAttribute("moviename3", actionMovie3.getName());
        map.addAttribute("moviepictureaddress3", actionMovie3.getPictureaddress());
        map.addAttribute("movieyears3", actionMovie3.getYears());

        map.addAttribute("moviename4", actionMovie4.getName());
        map.addAttribute("moviepictureaddress4", actionMovie4.getPictureaddress());
        map.addAttribute("movieyears4", actionMovie4.getYears());

        map.addAttribute("moviename5", actionMovie5.getName());
        map.addAttribute("moviepictureaddress5", actionMovie5.getPictureaddress());
        map.addAttribute("movieyears5", actionMovie5.getYears());

        map.addAttribute("moviename6", actionMovie6.getName());
        map.addAttribute("moviepictureaddress6", actionMovie6.getPictureaddress());
        map.addAttribute("movieyears6", actionMovie6.getYears());

        map.addAttribute("moviename7", actionMovie7.getName());
        map.addAttribute("moviepictureaddress7", actionMovie7.getPictureaddress());
        map.addAttribute("movieyears7", actionMovie7.getYears());

        map.addAttribute("moviename8", actionMovie8.getName());
        map.addAttribute("moviepictureaddress8", actionMovie8.getPictureaddress());
        map.addAttribute("movieyears8", actionMovie8.getYears());

        map.addAttribute("moviename9", actionMovie9.getName());
        map.addAttribute("moviepictureaddress9", actionMovie9.getPictureaddress());
        map.addAttribute("movieyears9", actionMovie9.getYears());

        map.addAttribute("moviename10", actionMovie10.getName());
        map.addAttribute("moviepictureaddress10", actionMovie10.getPictureaddress());
        map.addAttribute("movieyears10", actionMovie10.getYears());

        map.addAttribute("moviename11", actionMovie11.getName());
        map.addAttribute("moviepictureaddress11", actionMovie11.getPictureaddress());
        map.addAttribute("movieyears11", actionMovie11.getYears());

        map.addAttribute("moviename12", actionMovie12.getName());
        map.addAttribute("moviepictureaddress12", actionMovie12.getPictureaddress());
        map.addAttribute("movieyears12", actionMovie12.getYears());

        map.addAttribute("moviename13", actionMovie13.getName());
        System.out.println(actionMovie13.getName());
        map.addAttribute("moviepictureaddress13", actionMovie13.getPictureaddress());
        map.addAttribute("movieyears13", actionMovie13.getYears());

        map.addAttribute("moviename14", actionMovie14.getName());
        map.addAttribute("moviepictureaddress14", actionMovie14.getPictureaddress());
        map.addAttribute("movieyears14", actionMovie14.getYears());

        map.addAttribute("moviename15", actionMovie15.getName());
        map.addAttribute("moviepictureaddress15", actionMovie15.getPictureaddress());
        map.addAttribute("movieyears15", actionMovie15.getYears());

        map.addAttribute("moviename16", actionMovie16.getName());
        map.addAttribute("moviepictureaddress16", actionMovie16.getPictureaddress());
        map.addAttribute("movieyears16", actionMovie16.getYears());

        map.addAttribute("moviename17", actionMovie17.getName());
        map.addAttribute("moviepictureaddress17", actionMovie17.getPictureaddress());
        map.addAttribute("movieyears17", actionMovie17.getYears());

        map.addAttribute("moviename18", actionMovie18.getName());
        map.addAttribute("moviepictureaddress18", actionMovie18.getPictureaddress());
        map.addAttribute("movieyears18", actionMovie18.getYears());


        return "love";


    }

    //剧情片
    @Autowired
    StoryMovieMapper storyMovieMapper;

    @RequestMapping("/story")
    public String story(ModelMap map) {

        StoryMovie actionMovie1 = storyMovieMapper.selectById(1);
        StoryMovie actionMovie2 = storyMovieMapper.selectById(2);
        StoryMovie actionMovie3 = storyMovieMapper.selectById(3);
        StoryMovie actionMovie4 = storyMovieMapper.selectById(4);
        StoryMovie actionMovie5 = storyMovieMapper.selectById(5);
        StoryMovie actionMovie6 = storyMovieMapper.selectById(6);
        StoryMovie actionMovie7 = storyMovieMapper.selectById(7);
        StoryMovie actionMovie8 = storyMovieMapper.selectById(8);
        StoryMovie actionMovie9 = storyMovieMapper.selectById(9);
        StoryMovie actionMovie10 = storyMovieMapper.selectById(10);
        StoryMovie actionMovie11 = storyMovieMapper.selectById(11);
        StoryMovie actionMovie12 = storyMovieMapper.selectById(12);
        StoryMovie actionMovie13 = storyMovieMapper.selectById(13);
        StoryMovie actionMovie14 = storyMovieMapper.selectById(14);
        StoryMovie actionMovie15 = storyMovieMapper.selectById(15);
        StoryMovie actionMovie16 = storyMovieMapper.selectById(16);
        StoryMovie actionMovie17 = storyMovieMapper.selectById(17);
        StoryMovie actionMovie18 = storyMovieMapper.selectById(18);

        map.addAttribute("moviename1", actionMovie1.getName());
        map.addAttribute("moviepictureaddress1", actionMovie1.getPictureaddress());
        map.addAttribute("movieyears1", actionMovie1.getYears());

        map.addAttribute("moviename2", actionMovie2.getName());
        map.addAttribute("moviepictureaddress2", actionMovie2.getPictureaddress());
        map.addAttribute("movieyears2", actionMovie2.getYears());

        map.addAttribute("moviename3", actionMovie3.getName());
        map.addAttribute("moviepictureaddress3", actionMovie3.getPictureaddress());
        map.addAttribute("movieyears3", actionMovie3.getYears());

        map.addAttribute("moviename4", actionMovie4.getName());
        map.addAttribute("moviepictureaddress4", actionMovie4.getPictureaddress());
        map.addAttribute("movieyears4", actionMovie4.getYears());

        map.addAttribute("moviename5", actionMovie5.getName());
        map.addAttribute("moviepictureaddress5", actionMovie5.getPictureaddress());
        map.addAttribute("movieyears5", actionMovie5.getYears());

        map.addAttribute("moviename6", actionMovie6.getName());
        map.addAttribute("moviepictureaddress6", actionMovie6.getPictureaddress());
        map.addAttribute("movieyears6", actionMovie6.getYears());

        map.addAttribute("moviename7", actionMovie7.getName());
        map.addAttribute("moviepictureaddress7", actionMovie7.getPictureaddress());
        map.addAttribute("movieyears7", actionMovie7.getYears());

        map.addAttribute("moviename8", actionMovie8.getName());
        map.addAttribute("moviepictureaddress8", actionMovie8.getPictureaddress());
        map.addAttribute("movieyears8", actionMovie8.getYears());

        map.addAttribute("moviename9", actionMovie9.getName());
        map.addAttribute("moviepictureaddress9", actionMovie9.getPictureaddress());
        map.addAttribute("movieyears9", actionMovie9.getYears());

        map.addAttribute("moviename10", actionMovie10.getName());
        map.addAttribute("moviepictureaddress10", actionMovie10.getPictureaddress());
        map.addAttribute("movieyears10", actionMovie10.getYears());

        map.addAttribute("moviename11", actionMovie11.getName());
        map.addAttribute("moviepictureaddress11", actionMovie11.getPictureaddress());
        map.addAttribute("movieyears11", actionMovie11.getYears());

        map.addAttribute("moviename12", actionMovie12.getName());
        map.addAttribute("moviepictureaddress12", actionMovie12.getPictureaddress());
        map.addAttribute("movieyears12", actionMovie12.getYears());

        map.addAttribute("moviename13", actionMovie13.getName());
        System.out.println(actionMovie13.getName());
        map.addAttribute("moviepictureaddress13", actionMovie13.getPictureaddress());
        map.addAttribute("movieyears13", actionMovie13.getYears());

        map.addAttribute("moviename14", actionMovie14.getName());
        map.addAttribute("moviepictureaddress14", actionMovie14.getPictureaddress());
        map.addAttribute("movieyears14", actionMovie14.getYears());

        map.addAttribute("moviename15", actionMovie15.getName());
        map.addAttribute("moviepictureaddress15", actionMovie15.getPictureaddress());
        map.addAttribute("movieyears15", actionMovie15.getYears());

        map.addAttribute("moviename16", actionMovie16.getName());
        map.addAttribute("moviepictureaddress16", actionMovie16.getPictureaddress());
        map.addAttribute("movieyears16", actionMovie16.getYears());

        map.addAttribute("moviename17", actionMovie17.getName());
        map.addAttribute("moviepictureaddress17", actionMovie17.getPictureaddress());
        map.addAttribute("movieyears17", actionMovie17.getYears());

        map.addAttribute("moviename18", actionMovie18.getName());
        map.addAttribute("moviepictureaddress18", actionMovie18.getPictureaddress());
        map.addAttribute("movieyears18", actionMovie18.getYears());


        return "story";
    }

    //喜剧片
    @Autowired
    ComedyMovieMapper comedyMovieMapper;

    @RequestMapping("/comedy")
    public String comedy(ModelMap map) {

        ComedyMovie actionMovie1 = comedyMovieMapper.selectById(1);
        ComedyMovie actionMovie2 = comedyMovieMapper.selectById(2);
        ComedyMovie actionMovie3 = comedyMovieMapper.selectById(3);
        ComedyMovie actionMovie4 = comedyMovieMapper.selectById(4);
        ComedyMovie actionMovie5 = comedyMovieMapper.selectById(5);
        ComedyMovie actionMovie6 = comedyMovieMapper.selectById(6);
        ComedyMovie actionMovie7 = comedyMovieMapper.selectById(7);
        ComedyMovie actionMovie8 = comedyMovieMapper.selectById(8);
        ComedyMovie actionMovie9 = comedyMovieMapper.selectById(9);
        ComedyMovie actionMovie10 = comedyMovieMapper.selectById(10);
        ComedyMovie actionMovie11 = comedyMovieMapper.selectById(11);
        ComedyMovie actionMovie12 = comedyMovieMapper.selectById(12);
        ComedyMovie actionMovie13 = comedyMovieMapper.selectById(13);
        ComedyMovie actionMovie14 = comedyMovieMapper.selectById(14);
        ComedyMovie actionMovie15 = comedyMovieMapper.selectById(15);
        ComedyMovie actionMovie16 = comedyMovieMapper.selectById(16);
        ComedyMovie actionMovie17 = comedyMovieMapper.selectById(17);
        ComedyMovie actionMovie18 = comedyMovieMapper.selectById(18);

        map.addAttribute("moviename1", actionMovie1.getName());
        map.addAttribute("moviepictureaddress1", actionMovie1.getPictureaddress());
        map.addAttribute("movieyears1", actionMovie1.getYears());

        map.addAttribute("moviename2", actionMovie2.getName());
        map.addAttribute("moviepictureaddress2", actionMovie2.getPictureaddress());
        map.addAttribute("movieyears2", actionMovie2.getYears());

        map.addAttribute("moviename3", actionMovie3.getName());
        map.addAttribute("moviepictureaddress3", actionMovie3.getPictureaddress());
        map.addAttribute("movieyears3", actionMovie3.getYears());

        map.addAttribute("moviename4", actionMovie4.getName());
        map.addAttribute("moviepictureaddress4", actionMovie4.getPictureaddress());
        map.addAttribute("movieyears4", actionMovie4.getYears());

        map.addAttribute("moviename5", actionMovie5.getName());
        map.addAttribute("moviepictureaddress5", actionMovie5.getPictureaddress());
        map.addAttribute("movieyears5", actionMovie5.getYears());

        map.addAttribute("moviename6", actionMovie6.getName());
        map.addAttribute("moviepictureaddress6", actionMovie6.getPictureaddress());
        map.addAttribute("movieyears6", actionMovie6.getYears());

        map.addAttribute("moviename7", actionMovie7.getName());
        map.addAttribute("moviepictureaddress7", actionMovie7.getPictureaddress());
        map.addAttribute("movieyears7", actionMovie7.getYears());

        map.addAttribute("moviename8", actionMovie8.getName());
        map.addAttribute("moviepictureaddress8", actionMovie8.getPictureaddress());
        map.addAttribute("movieyears8", actionMovie8.getYears());

        map.addAttribute("moviename9", actionMovie9.getName());
        map.addAttribute("moviepictureaddress9", actionMovie9.getPictureaddress());
        map.addAttribute("movieyears9", actionMovie9.getYears());

        map.addAttribute("moviename10", actionMovie10.getName());
        map.addAttribute("moviepictureaddress10", actionMovie10.getPictureaddress());
        map.addAttribute("movieyears10", actionMovie10.getYears());

        map.addAttribute("moviename11", actionMovie11.getName());
        map.addAttribute("moviepictureaddress11", actionMovie11.getPictureaddress());
        map.addAttribute("movieyears11", actionMovie11.getYears());

        map.addAttribute("moviename12", actionMovie12.getName());
        map.addAttribute("moviepictureaddress12", actionMovie12.getPictureaddress());
        map.addAttribute("movieyears12", actionMovie12.getYears());

        map.addAttribute("moviename13", actionMovie13.getName());
        System.out.println(actionMovie13.getName());
        map.addAttribute("moviepictureaddress13", actionMovie13.getPictureaddress());
        map.addAttribute("movieyears13", actionMovie13.getYears());

        map.addAttribute("moviename14", actionMovie14.getName());
        map.addAttribute("moviepictureaddress14", actionMovie14.getPictureaddress());
        map.addAttribute("movieyears14", actionMovie14.getYears());

        map.addAttribute("moviename15", actionMovie15.getName());
        map.addAttribute("moviepictureaddress15", actionMovie15.getPictureaddress());
        map.addAttribute("movieyears15", actionMovie15.getYears());

        map.addAttribute("moviename16", actionMovie16.getName());
        map.addAttribute("moviepictureaddress16", actionMovie16.getPictureaddress());
        map.addAttribute("movieyears16", actionMovie16.getYears());

        map.addAttribute("moviename17", actionMovie17.getName());
        map.addAttribute("moviepictureaddress17", actionMovie17.getPictureaddress());
        map.addAttribute("movieyears17", actionMovie17.getYears());

        map.addAttribute("moviename18", actionMovie18.getName());
        map.addAttribute("moviepictureaddress18", actionMovie18.getPictureaddress());
        map.addAttribute("movieyears18", actionMovie18.getYears());

        return "comedy";


    }

    //恐怖片
    @Autowired
    ScaryMovieMapper scaryMovieMapper;

    @RequestMapping("/scary")
    public String scary(ModelMap map) {
        ScaryMovie actionMovie1 = scaryMovieMapper.selectById(1);
        ScaryMovie actionMovie2 = scaryMovieMapper.selectById(2);
        ScaryMovie actionMovie3 = scaryMovieMapper.selectById(3);
        ScaryMovie actionMovie4 = scaryMovieMapper.selectById(4);
        ScaryMovie actionMovie5 = scaryMovieMapper.selectById(5);
        ScaryMovie actionMovie6 = scaryMovieMapper.selectById(6);
        ScaryMovie actionMovie7 = scaryMovieMapper.selectById(7);
        ScaryMovie actionMovie8 = scaryMovieMapper.selectById(8);
        ScaryMovie actionMovie9 = scaryMovieMapper.selectById(9);
        ScaryMovie actionMovie10 = scaryMovieMapper.selectById(10);
        ScaryMovie actionMovie11 = scaryMovieMapper.selectById(11);
        ScaryMovie actionMovie12 = scaryMovieMapper.selectById(12);
        ScaryMovie actionMovie13 = scaryMovieMapper.selectById(13);
        ScaryMovie actionMovie14 = scaryMovieMapper.selectById(14);
        ScaryMovie actionMovie15 = scaryMovieMapper.selectById(15);
        ScaryMovie actionMovie16 = scaryMovieMapper.selectById(16);
        ScaryMovie actionMovie17 = scaryMovieMapper.selectById(17);
        ScaryMovie actionMovie18 = scaryMovieMapper.selectById(18);

        map.addAttribute("moviename1", actionMovie1.getName());
        map.addAttribute("moviepictureaddress1", actionMovie1.getPictureaddress());
        map.addAttribute("movieyears1", actionMovie1.getYears());

        map.addAttribute("moviename2", actionMovie2.getName());
        map.addAttribute("moviepictureaddress2", actionMovie2.getPictureaddress());
        map.addAttribute("movieyears2", actionMovie2.getYears());

        map.addAttribute("moviename3", actionMovie3.getName());
        map.addAttribute("moviepictureaddress3", actionMovie3.getPictureaddress());
        map.addAttribute("movieyears3", actionMovie3.getYears());

        map.addAttribute("moviename4", actionMovie4.getName());
        map.addAttribute("moviepictureaddress4", actionMovie4.getPictureaddress());
        map.addAttribute("movieyears4", actionMovie4.getYears());

        map.addAttribute("moviename5", actionMovie5.getName());
        map.addAttribute("moviepictureaddress5", actionMovie5.getPictureaddress());
        map.addAttribute("movieyears5", actionMovie5.getYears());

        map.addAttribute("moviename6", actionMovie6.getName());
        map.addAttribute("moviepictureaddress6", actionMovie6.getPictureaddress());
        map.addAttribute("movieyears6", actionMovie6.getYears());

        map.addAttribute("moviename7", actionMovie7.getName());
        map.addAttribute("moviepictureaddress7", actionMovie7.getPictureaddress());
        map.addAttribute("movieyears7", actionMovie7.getYears());

        map.addAttribute("moviename8", actionMovie8.getName());
        map.addAttribute("moviepictureaddress8", actionMovie8.getPictureaddress());
        map.addAttribute("movieyears8", actionMovie8.getYears());

        map.addAttribute("moviename9", actionMovie9.getName());
        map.addAttribute("moviepictureaddress9", actionMovie9.getPictureaddress());
        map.addAttribute("movieyears9", actionMovie9.getYears());

        map.addAttribute("moviename10", actionMovie10.getName());
        map.addAttribute("moviepictureaddress10", actionMovie10.getPictureaddress());
        map.addAttribute("movieyears10", actionMovie10.getYears());

        map.addAttribute("moviename11", actionMovie11.getName());
        map.addAttribute("moviepictureaddress11", actionMovie11.getPictureaddress());
        map.addAttribute("movieyears11", actionMovie11.getYears());

        map.addAttribute("moviename12", actionMovie12.getName());
        map.addAttribute("moviepictureaddress12", actionMovie12.getPictureaddress());
        map.addAttribute("movieyears12", actionMovie12.getYears());

        map.addAttribute("moviename13", actionMovie13.getName());
        System.out.println(actionMovie13.getName());
        map.addAttribute("moviepictureaddress13", actionMovie13.getPictureaddress());
        map.addAttribute("movieyears13", actionMovie13.getYears());

        map.addAttribute("moviename14", actionMovie14.getName());
        map.addAttribute("moviepictureaddress14", actionMovie14.getPictureaddress());
        map.addAttribute("movieyears14", actionMovie14.getYears());

        map.addAttribute("moviename15", actionMovie15.getName());
        map.addAttribute("moviepictureaddress15", actionMovie15.getPictureaddress());
        map.addAttribute("movieyears15", actionMovie15.getYears());

        map.addAttribute("moviename16", actionMovie16.getName());
        map.addAttribute("moviepictureaddress16", actionMovie16.getPictureaddress());
        map.addAttribute("movieyears16", actionMovie16.getYears());

        map.addAttribute("moviename17", actionMovie17.getName());
        map.addAttribute("moviepictureaddress17", actionMovie17.getPictureaddress());
        map.addAttribute("movieyears17", actionMovie17.getYears());

        map.addAttribute("moviename18", actionMovie18.getName());
        map.addAttribute("moviepictureaddress18", actionMovie18.getPictureaddress());
        map.addAttribute("movieyears18", actionMovie18.getYears());


        return "scary";


    }

    //战争片
    @Autowired
    WarMovieMapper warMovieMapper;

    @RequestMapping("/war")
    public String war(ModelMap map) {

        WarMovie actionMovie1 = warMovieMapper.selectById(1);
        WarMovie actionMovie2 = warMovieMapper.selectById(2);
        WarMovie actionMovie3 = warMovieMapper.selectById(3);
        WarMovie actionMovie4 = warMovieMapper.selectById(4);
        WarMovie actionMovie5 = warMovieMapper.selectById(5);
        WarMovie actionMovie6 = warMovieMapper.selectById(6);
        WarMovie actionMovie7 = warMovieMapper.selectById(7);
        WarMovie actionMovie8 = warMovieMapper.selectById(8);
        WarMovie actionMovie9 = warMovieMapper.selectById(9);
        WarMovie actionMovie10 = warMovieMapper.selectById(10);
        WarMovie actionMovie11 = warMovieMapper.selectById(11);
        WarMovie actionMovie12 = warMovieMapper.selectById(12);
        WarMovie actionMovie13 = warMovieMapper.selectById(13);
        WarMovie actionMovie14 = warMovieMapper.selectById(14);
        WarMovie actionMovie15 = warMovieMapper.selectById(15);
        WarMovie actionMovie16 = warMovieMapper.selectById(16);
        WarMovie actionMovie17 = warMovieMapper.selectById(17);
        WarMovie actionMovie18 = warMovieMapper.selectById(18);


        map.addAttribute("moviename1", actionMovie1.getName());
        map.addAttribute("moviepictureaddress1", actionMovie1.getPictureaddress());
        map.addAttribute("movieyears1", actionMovie1.getYears());

        map.addAttribute("moviename2", actionMovie2.getName());
        map.addAttribute("moviepictureaddress2", actionMovie2.getPictureaddress());
        map.addAttribute("movieyears2", actionMovie2.getYears());

        map.addAttribute("moviename3", actionMovie3.getName());
        map.addAttribute("moviepictureaddress3", actionMovie3.getPictureaddress());
        map.addAttribute("movieyears3", actionMovie3.getYears());

        map.addAttribute("moviename4", actionMovie4.getName());
        map.addAttribute("moviepictureaddress4", actionMovie4.getPictureaddress());
        map.addAttribute("movieyears4", actionMovie4.getYears());

        map.addAttribute("moviename5", actionMovie5.getName());
        map.addAttribute("moviepictureaddress5", actionMovie5.getPictureaddress());
        map.addAttribute("movieyears5", actionMovie5.getYears());

        map.addAttribute("moviename6", actionMovie6.getName());
        map.addAttribute("moviepictureaddress6", actionMovie6.getPictureaddress());
        map.addAttribute("movieyears6", actionMovie6.getYears());

        map.addAttribute("moviename7", actionMovie7.getName());
        map.addAttribute("moviepictureaddress7", actionMovie7.getPictureaddress());
        map.addAttribute("movieyears7", actionMovie7.getYears());

        map.addAttribute("moviename8", actionMovie8.getName());
        map.addAttribute("moviepictureaddress8", actionMovie8.getPictureaddress());
        map.addAttribute("movieyears8", actionMovie8.getYears());

        map.addAttribute("moviename9", actionMovie9.getName());
        map.addAttribute("moviepictureaddress9", actionMovie9.getPictureaddress());
        map.addAttribute("movieyears9", actionMovie9.getYears());

        map.addAttribute("moviename10", actionMovie10.getName());
        map.addAttribute("moviepictureaddress10", actionMovie10.getPictureaddress());
        map.addAttribute("movieyears10", actionMovie10.getYears());

        map.addAttribute("moviename11", actionMovie11.getName());
        map.addAttribute("moviepictureaddress11", actionMovie11.getPictureaddress());
        map.addAttribute("movieyears11", actionMovie11.getYears());

        map.addAttribute("moviename12", actionMovie12.getName());
        map.addAttribute("moviepictureaddress12", actionMovie12.getPictureaddress());
        map.addAttribute("movieyears12", actionMovie12.getYears());

        map.addAttribute("moviename13", actionMovie13.getName());
        System.out.println(actionMovie13.getName());
        map.addAttribute("moviepictureaddress13", actionMovie13.getPictureaddress());
        map.addAttribute("movieyears13", actionMovie13.getYears());

        map.addAttribute("moviename14", actionMovie14.getName());
        map.addAttribute("moviepictureaddress14", actionMovie14.getPictureaddress());
        map.addAttribute("movieyears14", actionMovie14.getYears());

        map.addAttribute("moviename15", actionMovie15.getName());
        map.addAttribute("moviepictureaddress15", actionMovie15.getPictureaddress());
        map.addAttribute("movieyears15", actionMovie15.getYears());

        map.addAttribute("moviename16", actionMovie16.getName());
        map.addAttribute("moviepictureaddress16", actionMovie16.getPictureaddress());
        map.addAttribute("movieyears16", actionMovie16.getYears());

        map.addAttribute("moviename17", actionMovie17.getName());
        map.addAttribute("moviepictureaddress17", actionMovie17.getPictureaddress());
        map.addAttribute("movieyears17", actionMovie17.getYears());

        map.addAttribute("moviename18", actionMovie18.getName());
        map.addAttribute("moviepictureaddress18", actionMovie18.getPictureaddress());
        map.addAttribute("movieyears18", actionMovie18.getYears());

        return "war";
    }

    //动漫
    @Autowired
    DongmanMapper dongmanMapper;

    @RequestMapping("/dongman")
    public String dongman(ModelMap map) {

        Dongman actionMovie1 = dongmanMapper.selectById(1);
        Dongman actionMovie2 = dongmanMapper.selectById(2);
        Dongman actionMovie3 = dongmanMapper.selectById(3);
        Dongman actionMovie4 = dongmanMapper.selectById(4);
        Dongman actionMovie5 = dongmanMapper.selectById(5);
        Dongman actionMovie6 = dongmanMapper.selectById(6);
        Dongman actionMovie7 = dongmanMapper.selectById(7);
        Dongman actionMovie8 = dongmanMapper.selectById(8);
        Dongman actionMovie9 = dongmanMapper.selectById(9);
        Dongman actionMovie10 = dongmanMapper.selectById(10);
        Dongman actionMovie11 = dongmanMapper.selectById(11);
        Dongman actionMovie12 = dongmanMapper.selectById(12);
        Dongman actionMovie13 = dongmanMapper.selectById(13);
        Dongman actionMovie14 = dongmanMapper.selectById(14);
        Dongman actionMovie15 = dongmanMapper.selectById(15);
        Dongman actionMovie16 = dongmanMapper.selectById(16);
        Dongman actionMovie17 = dongmanMapper.selectById(17);
        Dongman actionMovie18 = dongmanMapper.selectById(18);


        map.addAttribute("moviename1", actionMovie1.getName());
        map.addAttribute("moviepictureaddress1", actionMovie1.getPictureaddress());
        map.addAttribute("movieyears1", actionMovie1.getYears());

        map.addAttribute("moviename2", actionMovie2.getName());
        map.addAttribute("moviepictureaddress2", actionMovie2.getPictureaddress());
        map.addAttribute("movieyears2", actionMovie2.getYears());

        map.addAttribute("moviename3", actionMovie3.getName());
        map.addAttribute("moviepictureaddress3", actionMovie3.getPictureaddress());
        map.addAttribute("movieyears3", actionMovie3.getYears());

        map.addAttribute("moviename4", actionMovie4.getName());
        map.addAttribute("moviepictureaddress4", actionMovie4.getPictureaddress());
        map.addAttribute("movieyears4", actionMovie4.getYears());

        map.addAttribute("moviename5", actionMovie5.getName());
        map.addAttribute("moviepictureaddress5", actionMovie5.getPictureaddress());
        map.addAttribute("movieyears5", actionMovie5.getYears());

        map.addAttribute("moviename6", actionMovie6.getName());
        map.addAttribute("moviepictureaddress6", actionMovie6.getPictureaddress());
        map.addAttribute("movieyears6", actionMovie6.getYears());

        map.addAttribute("moviename7", actionMovie7.getName());
        map.addAttribute("moviepictureaddress7", actionMovie7.getPictureaddress());
        map.addAttribute("movieyears7", actionMovie7.getYears());

        map.addAttribute("moviename8", actionMovie8.getName());
        map.addAttribute("moviepictureaddress8", actionMovie8.getPictureaddress());
        map.addAttribute("movieyears8", actionMovie8.getYears());

        map.addAttribute("moviename9", actionMovie9.getName());
        map.addAttribute("moviepictureaddress9", actionMovie9.getPictureaddress());
        map.addAttribute("movieyears9", actionMovie9.getYears());

        map.addAttribute("moviename10", actionMovie10.getName());
        map.addAttribute("moviepictureaddress10", actionMovie10.getPictureaddress());
        map.addAttribute("movieyears10", actionMovie10.getYears());

        map.addAttribute("moviename11", actionMovie11.getName());
        map.addAttribute("moviepictureaddress11", actionMovie11.getPictureaddress());
        map.addAttribute("movieyears11", actionMovie11.getYears());

        map.addAttribute("moviename12", actionMovie12.getName());
        map.addAttribute("moviepictureaddress12", actionMovie12.getPictureaddress());
        map.addAttribute("movieyears12", actionMovie12.getYears());

        map.addAttribute("moviename13", actionMovie13.getName());
        System.out.println(actionMovie13.getName());
        map.addAttribute("moviepictureaddress13", actionMovie13.getPictureaddress());
        map.addAttribute("movieyears13", actionMovie13.getYears());

        map.addAttribute("moviename14", actionMovie14.getName());
        map.addAttribute("moviepictureaddress14", actionMovie14.getPictureaddress());
        map.addAttribute("movieyears14", actionMovie14.getYears());

        map.addAttribute("moviename15", actionMovie15.getName());
        map.addAttribute("moviepictureaddress15", actionMovie15.getPictureaddress());
        map.addAttribute("movieyears15", actionMovie15.getYears());

        map.addAttribute("moviename16", actionMovie16.getName());
        map.addAttribute("moviepictureaddress16", actionMovie16.getPictureaddress());
        map.addAttribute("movieyears16", actionMovie16.getYears());

        map.addAttribute("moviename17", actionMovie17.getName());
        map.addAttribute("moviepictureaddress17", actionMovie17.getPictureaddress());
        map.addAttribute("movieyears17", actionMovie17.getYears());

        map.addAttribute("moviename18", actionMovie18.getName());
        map.addAttribute("moviepictureaddress18", actionMovie18.getPictureaddress());
        map.addAttribute("movieyears18", actionMovie18.getYears());

        return "dongman";
    }
//最新影视

    @Autowired
    NewtvMapper newtvMapper;

    @RequestMapping("/newtv")
    public String newTv(ModelMap map) {

        Newtv actionMovie1 = newtvMapper.selectById(1);
        Newtv actionMovie2 = newtvMapper.selectById(2);
        Newtv actionMovie3 = newtvMapper.selectById(3);
        Newtv actionMovie4 = newtvMapper.selectById(4);
        Newtv actionMovie5 = newtvMapper.selectById(5);
        Newtv actionMovie6 = newtvMapper.selectById(6);
        Newtv actionMovie7 = newtvMapper.selectById(7);
        Newtv actionMovie8 = newtvMapper.selectById(8);
        Newtv actionMovie9 = newtvMapper.selectById(9);
        Newtv actionMovie10 = newtvMapper.selectById(10);
        Newtv actionMovie11 = newtvMapper.selectById(11);
        Newtv actionMovie12 = newtvMapper.selectById(12);
        Newtv actionMovie13 = newtvMapper.selectById(13);
        Newtv actionMovie14 = newtvMapper.selectById(14);
        Newtv actionMovie15 = newtvMapper.selectById(15);
        Newtv actionMovie16 = newtvMapper.selectById(16);
        Newtv actionMovie17 = newtvMapper.selectById(17);
        Newtv actionMovie18 = newtvMapper.selectById(18);

        map.addAttribute("moviename1", actionMovie1.getName());
        map.addAttribute("moviepictureaddress1", actionMovie1.getPictureaddress());
        map.addAttribute("movieyears1", actionMovie1.getYears());

        map.addAttribute("moviename2", actionMovie2.getName());
        map.addAttribute("moviepictureaddress2", actionMovie2.getPictureaddress());
        map.addAttribute("movieyears2", actionMovie2.getYears());

        map.addAttribute("moviename3", actionMovie3.getName());
        map.addAttribute("moviepictureaddress3", actionMovie3.getPictureaddress());
        map.addAttribute("movieyears3", actionMovie3.getYears());

        map.addAttribute("moviename4", actionMovie4.getName());
        map.addAttribute("moviepictureaddress4", actionMovie4.getPictureaddress());
        map.addAttribute("movieyears4", actionMovie4.getYears());

        map.addAttribute("moviename5", actionMovie5.getName());
        map.addAttribute("moviepictureaddress5", actionMovie5.getPictureaddress());
        map.addAttribute("movieyears5", actionMovie5.getYears());

        map.addAttribute("moviename6", actionMovie6.getName());
        map.addAttribute("moviepictureaddress6", actionMovie6.getPictureaddress());
        map.addAttribute("movieyears6", actionMovie6.getYears());

        map.addAttribute("moviename7", actionMovie7.getName());
        map.addAttribute("moviepictureaddress7", actionMovie7.getPictureaddress());
        map.addAttribute("movieyears7", actionMovie7.getYears());

        map.addAttribute("moviename8", actionMovie8.getName());
        map.addAttribute("moviepictureaddress8", actionMovie8.getPictureaddress());
        map.addAttribute("movieyears8", actionMovie8.getYears());

        map.addAttribute("moviename9", actionMovie9.getName());
        map.addAttribute("moviepictureaddress9", actionMovie9.getPictureaddress());
        map.addAttribute("movieyears9", actionMovie9.getYears());

        map.addAttribute("moviename10", actionMovie10.getName());
        map.addAttribute("moviepictureaddress10", actionMovie10.getPictureaddress());
        map.addAttribute("movieyears10", actionMovie10.getYears());

        map.addAttribute("moviename11", actionMovie11.getName());
        map.addAttribute("moviepictureaddress11", actionMovie11.getPictureaddress());
        map.addAttribute("movieyears11", actionMovie11.getYears());

        map.addAttribute("moviename12", actionMovie12.getName());
        map.addAttribute("moviepictureaddress12", actionMovie12.getPictureaddress());
        map.addAttribute("movieyears12", actionMovie12.getYears());

        map.addAttribute("moviename13", actionMovie13.getName());
        System.out.println(actionMovie13.getName());
        map.addAttribute("moviepictureaddress13", actionMovie13.getPictureaddress());
        map.addAttribute("movieyears13", actionMovie13.getYears());

        map.addAttribute("moviename14", actionMovie14.getName());
        map.addAttribute("moviepictureaddress14", actionMovie14.getPictureaddress());
        map.addAttribute("movieyears14", actionMovie14.getYears());

        map.addAttribute("moviename15", actionMovie15.getName());
        map.addAttribute("moviepictureaddress15", actionMovie15.getPictureaddress());
        map.addAttribute("movieyears15", actionMovie15.getYears());

        map.addAttribute("moviename16", actionMovie16.getName());
        map.addAttribute("moviepictureaddress16", actionMovie16.getPictureaddress());
        map.addAttribute("movieyears16", actionMovie16.getYears());

        map.addAttribute("moviename17", actionMovie17.getName());
        map.addAttribute("moviepictureaddress17", actionMovie17.getPictureaddress());
        map.addAttribute("movieyears17", actionMovie17.getYears());

        map.addAttribute("moviename18", actionMovie18.getName());
        map.addAttribute("moviepictureaddress18", actionMovie18.getPictureaddress());
        map.addAttribute("movieyears18", actionMovie18.getYears());


        return "newtv";


    }


}
