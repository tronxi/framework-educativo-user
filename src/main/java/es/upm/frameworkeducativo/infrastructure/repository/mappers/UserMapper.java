package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.exceptions.PersistenceException;

@Mapper
public interface UserMapper {

    @Select("select ID_USER, IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED " +
            "FROM USER WHERE EMAIL = #{email}")
    UserDAO getUserByEmail(String email);

    @Select("insert into USER (IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED) VALUES" +
            "(#{ident}, #{name}, #{surnames}, #{password} ,#{email}, #{isChanged})")
    void saveUser(String ident, String name,
                  String surnames, String password, String email, Boolean isChanged);

}
