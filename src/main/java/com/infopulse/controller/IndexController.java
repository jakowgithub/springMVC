package com.infopulse.controller;

import com.infopulse.entity.User;
import com.infopulse.entity.UserDTO;
import com.infopulse.entity.UserMapper;
import com.infopulse.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping(value = "/clientsDTO", method = RequestMethod.GET)
    public ModelAndView getClientsDTO() {

        List<User> users = this.dataService.getAllUsers();

        List<String> usersDTOstring = users.stream()
                            .map(user -> UserMapper.INSTANCE.userToUserDTO(user).toString())
                            .collect(Collectors.toList());

//       List<String> usersDTOstring = new ArrayList<>();
//
//       for (User user: users){
//            UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO(user);
//            usersDTOstring.add(userDTO.getIdUser() + "*DTO*" + userDTO.getNameUser());
//        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("answerDTO");
        mav.addObject("list", usersDTOstring);
        return mav;
    }
}
