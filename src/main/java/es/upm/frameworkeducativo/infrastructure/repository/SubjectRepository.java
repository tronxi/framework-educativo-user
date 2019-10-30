package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.domain.model.Subject;
import es.upm.frameworkeducativo.domain.model.User;
import es.upm.frameworkeducativo.domain.port.secundary.ISubjectRepository;
import es.upm.frameworkeducativo.domain.port.secundary.IUserRepository;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.SubjectMapper;
import es.upm.frameworkeducativo.infrastructure.repository.mappers.UserMapper;
import es.upm.frameworkeducativo.infrastructure.repository.model.SubjectDAO;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectRepository implements ISubjectRepository {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public Subject getSubjectById(String id) {
        return subjectDAOToSubject(subjectMapper.getSubjectById(id));
    }


    @Override
    public void saveSubject(Subject subject) throws Exception {
        try {
            subjectMapper.saveSubject(
                    subject.getName(), subject.getYear());
        } catch (PersistenceException e) {
            throw new Exception("ex");
        }

    }

    @Override
    public void updateSubject(Subject subject) throws Exception {
        try {
            subjectMapper.updateSubject(
                    subject.getId_subject(), subject.getName(),
                    subject.getYear());
        } catch (PersistenceException e) {
            throw new Exception("ex");
        }
    }

    @Override
    public void deleteSubjectById(String id) {
        subjectMapper.deleteSubjectById(id);
    }

    private Subject subjectDAOToSubject(SubjectDAO subjectDAO) {
        return Subject.builder()
                .id_subject(subjectDAO.getIdSubject())
                .name(subjectDAO.getName())
                .year(subjectDAO.getYear())
                .build();
    }
}
