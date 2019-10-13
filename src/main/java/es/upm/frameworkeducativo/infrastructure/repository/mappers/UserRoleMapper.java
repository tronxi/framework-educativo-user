package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    @Select("select ID_USER, ID_ROLE from USER_ROLE where ID_USER = #{id_user}")
    List<UserRoleDAO> getRoleByUserId(String id_user);
}
