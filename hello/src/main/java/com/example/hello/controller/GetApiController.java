package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") //http://localhost:9090/api/get/hello
    public String getHello() {
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) // method 안해주면 get / post / put / delete 모두 동작
    public String hi() {
        return "hi";
    }
    // http://localhost:9090/api/get/path-variable/{spring-boot}
    // http://localhost:9090/api/get/path-variable/{spring}

    @GetMapping("/path-variable/{name}") // 주소에 대문자는 쓰지 않는다. -로 바꿔줌.
    public String pathVariable(@PathVariable(name = "name") String pathName) {

        //GetMapping 속 {name}과 매개변수의 이름을 같게 해줘야한다. 이름을 일치 시켜줄 수 없을 때 괄호하고 name = "name" 과 같이 해줌.
        System.out.println("PathVariable: " + pathName);
        return pathName;
    }

    //http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    //처음 시작은 ? 그 뒤로 key value 값
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        //왜 /안해주나?
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");

        });
        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);
        return name+" "+email+" "+age;
    }//DTO 형태로 매핑

    @GetMapping("query-param03")
    public String queryParam02(UserRequest userRequest) {//객체가 들어오게 되면 파라미터 파악하고 객체의 변수와 이름 매칭해줌.
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());
        return userRequest.toString();
    }


}
