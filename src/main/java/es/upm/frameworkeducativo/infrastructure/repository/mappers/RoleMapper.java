package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.repository.model.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {

    @Select("select ID_ROLE, DESCRIPTION from ROLE where id_role = #{id_role}")
    RoleEntity getRoleById(String id_role);

    @Select("select id_role from ROLE where description = #{description}")
    String getRoleByDescription(String description);

    @Select("select description from ROLE where id_role = #{id_role}")
    String getDescriptionByRoleId(String id_role);
}
