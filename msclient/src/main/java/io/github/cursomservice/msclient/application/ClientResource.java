package io.github.cursomservice.msclient.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientResource {

    @GetMapping
    public String status(){
        return "ok";
    }
}
