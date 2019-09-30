package es.upm.frameworkeducativo.infrastructure.repository.api.rest.resources;


import es.upm.frameworkeducativo.domain.model.Dato;
import es.upm.frameworkeducativo.infrastructure.repository.repository.DatoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class status {
    @Value("${environment:entorno por defecto}")
    private String environment;

    @Autowired
    DatoMapper datoMapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String inicio() {
        return "Environment " + environment;
    }
    @RequestMapping(value = "/dato", method = RequestMethod.GET)
    public Dato dato() {
        return datoMapper.getArticle();
    }
}
