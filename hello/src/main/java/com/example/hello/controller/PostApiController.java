package com.example.hello.controller;

import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody PostRequestDto requestData){

        //RequestBody를 통해 데이터를 파싱할 수 있다.
        System.out.println(requestData);
    }
}
