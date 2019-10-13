package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.api.rest.model.UserDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select ID_USER, NAME, SURNAMES, PASSWORD, EMAIL " +
            "FROM USER WHERE EMAIL = #{email}")
    UserDAO getUserByEmail(String email);

}
