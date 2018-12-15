package com.infopulse.controller;

import com.infopulse.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    private DataService dataService;

    public IndexController(DataService dataService){
        this.dataService = dataService;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("action", "./clients");
        return mav;
    }

    @RequestMapping(value="/clients", method = RequestMethod.POST)
    public ModelAndView createClient(@RequestParam("username") String name){
        // String name= request.getParameter("name");
        this.dataService.createClient(name);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ok");
        return mav;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ModelAndView getClients() {
        List<String> names = this.dataService.getAll();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("answer");
        mav.addObject("list", names);
        return mav;
    }

}
