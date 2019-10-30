package es.upm.frameworkeducativo.domain.service.impl;

import es.upm.frameworkeducativo.domain.model.Subject;
import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.primary.LoadSubjectService;
import es.upm.frameworkeducativo.domain.port.primary.LoadUserService;
import es.upm.frameworkeducativo.domain.port.secundary.IRoleRepository;
import es.upm.frameworkeducativo.domain.port.secundary.ISubjectRepository;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRepository;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRoleRepository;
import es.upm.frameworkeducativo.infrastructure.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class LoadSubjectServiceImpl implements LoadSubjectService {

    @Autowired
    ISubjectRepository subjectRepository;

    @Override
    public void loadSubject(Subject subject) {
        try {
        subjectRepository.saveSubject(subject);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
