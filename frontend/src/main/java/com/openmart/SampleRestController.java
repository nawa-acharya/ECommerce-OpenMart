package com.openmart;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Sandip on 7/12/16.
 */
@RestController
public class SampleRestController {


    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String order(@RequestBody String data){
        RestTemplate restTemplate = new RestTemplate();
       return restTemplate.getForObject("localhost:8090/openmart/api/order",String.class);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody String data){

        return data;

    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestBody String data){

        return data;

    }
}
