package com.example.hello;

import com.example.hello.dto.Member;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {

        System.out.println("---");

        //TEXT JSON ->Object
        //Object ->

        //controller req json(text) -> object
        //response object ->json(text)

        var objectMapper = new ObjectMapper();
        //object ->text
        //object mapper get method를 활용한다.
        var member = new Member("sj",10,"010-1111-1111");
        var text = objectMapper.writeValueAsString(member);
        System.out.println(text);

        //text ->object
        //object mapper 는 default 생성자를 필요로 한다.
        var objectMember = objectMapper.readValue(text,Member.class);
        System.out.println(objectMember);

    }

}
