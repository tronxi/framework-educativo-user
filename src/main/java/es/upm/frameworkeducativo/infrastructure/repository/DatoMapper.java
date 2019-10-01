package es.upm.frameworkeducativo.infrastructure.repository;

import es.upm.frameworkeducativo.domain.model.Dato;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DatoMapper {

    @Select("SELECT * FROM tablaPrueba where id = 109")
    Dato getArticle();
}
