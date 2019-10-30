package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.repository.model.SubjectDAO;
import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SubjectMapper {

    @Select("select ID_SUBJECT, NAME, YEAR" +
            "FROM SUBJECT WHERE ID = #{id}")
    SubjectDAO getSubjectById(String id);

    @Select("insert into SUBJECT (NAME, YEAR) VALUES" +
            "(#{name}, #{year})")
    void saveSubject(String name, String year);

    @Update("update SUBJECT set NAME = #{name}, YEAR = #{year}, " +
            "where ID_SUBJECT = #{id}")
    void updateSubject(String id, String name, String year);

    @Delete("delete from USER where ID_SUBJECT = #{id}")
    void deleteSubjectById(String id);

}
