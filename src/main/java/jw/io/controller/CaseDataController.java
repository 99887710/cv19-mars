package jw.io.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import jw.io.web.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping("/cv19/cases")
public class CaseDataController {

    @Autowired
    Rest rest;

    @RequestMapping(path = "/listAll", method = RequestMethod.GET)
    public String listAll() throws UnirestException {
        return rest.get();
    }
}
