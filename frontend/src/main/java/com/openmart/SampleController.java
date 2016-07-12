package com.openmart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sandip on 7/10/16.
 */
@Controller
public class SampleController {
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    public void test(){

    }
}
