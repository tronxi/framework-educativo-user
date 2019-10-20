package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserDAO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select ID_USER, IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED " +
            "FROM USER WHERE IDENT = #{ident}")
    UserDAO getUserByIdent(String ident);

    @Select("select ID_USER, IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED " +
            "FROM USER WHERE EMAIL = #{email}")
    UserDAO getUserByEmail(String email);

    @Select("insert into USER (IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED) VALUES" +
            "(#{ident}, #{name}, #{surnames}, #{password} ,#{email}, #{isChanged})")
    void saveUser(String ident, String name,
                  String surnames, String password, String email, Boolean isChanged);

    @Update("update USER set IDENT = #{ident}, NAME = #{name}, SURNAMES = #{surnames}, " +
            "PASSWORD = #{password}, EMAIL = #{email}, IS_CHANGED = #{isChanged}" +
            "where ID_USER = #{idUser}")
    void updateUser(String ident, String name,
                   String surnames, String password, String email, Boolean isChanged,
                   String idUser);

}
