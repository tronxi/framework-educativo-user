package es.upm.frameworkeducativo.domain.port.primary;

import es.upm.frameworkeducativo.domain.model.Subject;

public interface FindSubjectService {
     Subject findSubjectById(String id);
}
