package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.exceptions.PersistenceException;

@Mapper
public interface UserMapper {

    @Select("select ID_USER, NAME, SURNAMES, PASSWORD, EMAIL " +
            "FROM USER WHERE EMAIL = #{email}")
    UserDAO getUserByEmail(String email);

    @Select("insert into USER (ID_USER, NAME, SURNAMES, PASSWORD, EMAIL) VALUES" +
            "(#{id}, #{name}, #{surnames}, #{password} ,#{email})")
    void saveUser(String id, String name, String surnames, String password, String email);

}
