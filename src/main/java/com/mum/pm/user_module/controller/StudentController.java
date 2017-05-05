package com.mum.pm.user_module.controller;

import com.mum.pm.user_module.model.StudentAccessKeyForm;
import com.mum.pm.user_module.model.TestKey;
import com.mum.pm.user_module.model.User;
import com.mum.pm.user_module.service.StudentService;
import com.mum.pm.user_module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by 985191 on 4/27/2017.
 */

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value={"/student","/student/test"},  method = RequestMethod.GET)
    public ModelAndView addAccessKey() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(new StudentAccessKeyForm());
        modelAndView.setViewName("add-access-key");
        return modelAndView;
    }

    @RequestMapping(value={"/student/test"},  method = RequestMethod.POST)
    public ModelAndView postAccessKey(@Valid StudentAccessKeyForm studentAccessKeyForm, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        String accessKey = studentAccessKeyForm.getAccessKey();

        if(accessKey.isEmpty()){

            modelAndView.setViewName("add-access-key");
            return modelAndView;
        }else if (studentService.isAccessKey(accessKey)){
            studentService.deactivateAccessKey(accessKey);
            modelAndView.setViewName("category-subCategory");
        }else{
            modelAndView.setViewName("add-access-key");
            return modelAndView;
        }

        return modelAndView;
    }
}
