package es.upm.frameworkeducativo.domain.port.primary;

import org.springframework.http.HttpStatus;

public interface DeleteSubjectService {
    HttpStatus deleteSubject(String id);
}
