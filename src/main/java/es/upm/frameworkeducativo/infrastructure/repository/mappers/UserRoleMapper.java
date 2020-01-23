package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.repository.model.UserRoleEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    @Select("select ID_USER, ID_ROLE from USER_ROLE where ID_USER = #{id_user}")
    List<UserRoleEntity> getRoleByUserId(String id_user);

    @Insert("insert into USER_ROLE (id_user, id_role) VALUES " +
            "(#{id_user}, #{id_role})")
    void insertUserRole(String id_user, String id_role);

    @Delete("delete from USER_ROLE where id_user = #{id_user}")
    void deleteUserRoleByUserId(String id_user);
}
