package jw.io.controller;

import jw.io.web.Rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@EnableWebMvc
@RequestMapping("/cv19/cases")
public class CaseDataController {

    @Autowired
    Rest<String> rest;

    @RequestMapping(path = "/listAll", method = RequestMethod.GET)
    public String listAll() {
        return rest.get();
    }

    @RequestMapping(path = "/getBy", method = RequestMethod.GET)
    public String getBy(@RequestParam String q) {
        return rest.get(q);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(@RequestBody String body) {
        return rest.post(body);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable String id, @RequestBody String body) {
        return rest.put(id, body);
    }
}
