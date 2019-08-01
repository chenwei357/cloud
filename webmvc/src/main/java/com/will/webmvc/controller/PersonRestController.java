package com.will.webmvc.controller;

import com.will.webmvc.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonRestController {

    @GetMapping(value = "/person/{id}")
    public Person person(@PathVariable Long id, @RequestParam(required = false) String name){
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        return person;
    }

    @PostMapping(value = "/person/json",
                consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,   //请求类型  content-type
                produces = "application/properties+person")         //响应类型  accept
    public Person personJson2Properties(@RequestBody Person person){
        //@RequestBody读取的内容是 JSON
        //相应的内容是 properties
        return person;
    }


    @PostMapping(value = "/person/properties",
                consumes = "application/properties+person",                 //请求类型
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE)           //响应类型
    public Person personProperties2Json(@RequestBody Person person){
        //@RequestBody读取的内容是 properties
        //相应的内容是 JSON
        return person;
    }
}
