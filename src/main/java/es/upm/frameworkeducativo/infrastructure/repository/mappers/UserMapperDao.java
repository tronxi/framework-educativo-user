package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapperDao {

    @Select("select ID_USER, IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED " +
            "FROM USER WHERE IDENT = #{ident}")
    UserEntity getUserByIdent(String ident);

    @Select("select ID_USER, IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED " +
            "FROM USER WHERE EMAIL = #{email}")
    UserEntity getUserByEmail(String email);

    @Select("select ID_USER, IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED " +
            "FROM USER WHERE ID_USER = #{idUser}")
    UserEntity getUserByIdUser(String idUser);

    @Select("insert into USER (IDENT, NAME, SURNAMES, PASSWORD, EMAIL, IS_CHANGED) VALUES" +
            "(#{ident}, #{name}, #{surnames}, #{password} ,#{email}, #{isChanged})")
    void saveUser(String ident, String name,
                  String surnames, String password, String email, Boolean isChanged);

    @Update("update USER set IDENT = #{ident}, NAME = #{name}, SURNAMES = #{surnames}, " +
            "PASSWORD = #{password}, EMAIL = #{email}, IS_CHANGED = #{isChanged}" +
            " where ID_USER = #{idUser}")
    void updateUser(String ident, String name,
                   String surnames, String password, String email, Boolean isChanged,
                   int idUser);

    @Delete("delete from USER where ident = #{ident}")
    void deleteUserByIdent(String ident);

}