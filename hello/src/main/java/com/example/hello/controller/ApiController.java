package com.example.hello.controller;

import com.example.hello.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 해당 Class 는 REST API 처리하는 COntroller - 스프링이 자동으로 인식
@RequestMapping("/api") //RequestMapping URI를 지정해주는 Annotation
public class ApiController {

    @GetMapping("/hello") //http://localhost:9090/api/hello 주소에 매핑
    public String hello(){
        return "hello spring boot!";
    }

    //TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account){
        return account;
    }

    //JSON
    // req -> object mapper -> object -> method ->object -> object mapper ->json ->response
    @PostMapping("/json")
    public UserDto json(@RequestBody UserDto user){
        return user; //200 OK
    }


    //ResponseEntity
    @PutMapping("/put1")
    public ResponseEntity<UserDto> put(@RequestBody UserDto userDto){

        //CREATED 201 , PUT 완료 시 200
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }


}
