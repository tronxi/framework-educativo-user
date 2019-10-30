package es.upm.frameworkeducativo.domain.port.primary;

import es.upm.frameworkeducativo.domain.model.Subject;
import org.springframework.http.HttpStatus;

public interface UpdateSubjectService {
    HttpStatus updateSubject(Subject subject);
}
