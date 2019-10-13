package es.upm.frameworkeducativo.infrastructure.repository.mappers;

import es.upm.frameworkeducativo.infrastructure.api.rest.model.RoleDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select ID_ROLE, DESCRIPTION from role where id_role = #{id_role}")
    RoleDAO getRoleById(String id_role);
}
