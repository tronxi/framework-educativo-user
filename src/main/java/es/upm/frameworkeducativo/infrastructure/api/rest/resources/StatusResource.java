package es.upm.frameworkeducativo.infrastructure.api.rest.resources;


import es.upm.frameworkeducativo.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
//@PreAuthorize("authenticated")
public class StatusResource {
    @Autowired
    private UserRepository userRepository;
    @Value("${environment:entorno por defecto}")
    private String environment;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String inicio() {
        return "Environment " + environment;
    }

    @PreAuthorize("hasRole('STUDENT')")
    @RequestMapping(value = "student", method = RequestMethod.GET)
    public String student() {
        return "Tienes el rol student";
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value = "teacher", method = RequestMethod.GET)
    public String teacher() {
        return "Tienes el rol teacher";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "admin", method = RequestMethod.POST)
    public String admin(@RequestBody String users) {
        System.out.println(users);
        return "Tienes el rol admin";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {
        System.out.println(userRepository.getUserByEmail("admin@upm"));
        return "";
    }

}
