package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.port.primary.DeleteSubjectService;
import es.upm.frameworkeducativo.domain.port.primary.DeleteUserService;
import es.upm.frameworkeducativo.domain.port.secundary.ISubjectRepository;
import es.upm.frameworkeducativo.infrastructure.repository.SubjectRepository;
import es.upm.frameworkeducativo.infrastructure.repository.UserRepository;
import es.upm.frameworkeducativo.infrastructure.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DeleteSubjectServiceImpl implements DeleteSubjectService {

    @Autowired
    ISubjectRepository subjectRepository;

    @Override
    public HttpStatus deleteSubject(String id) {
        subjectRepository.deleteSubjectById(id);
        return HttpStatus.OK;
    }
}
