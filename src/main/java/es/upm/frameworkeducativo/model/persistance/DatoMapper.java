package es.upm.frameworkeducativo.model.persistance;

import es.upm.frameworkeducativo.model.entities.Dato;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DatoMapper {

    @Select("SELECT * FROM tablaPrueba where id = 109")
    Dato getArticle();
}
