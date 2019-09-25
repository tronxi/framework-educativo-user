package es.upm.frameworkeducativo.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class status {
    @Value("${environment:entorno por defecto}")
    private String environment;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String inicio() {
        return "Environment " + environment;
    }
}
