package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.repository.model.RoleDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleMapper {

    @Select("select ID_ROLE, DESCRIPTION from ROLE where id_role = #{id_role}")
    RoleDAO getRoleById(String id_role);

    @Select("select id_role from ROLE where description = #{description}")
    String getRoleByDescription(String description);
}
