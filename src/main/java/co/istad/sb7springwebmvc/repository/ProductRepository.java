package co.istad.sb7springwebmvc.repository;

import co.istad.sb7springwebmvc.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper //this repo is the mapper of mybatis
@Repository
public interface ProductRepository {
    //select: return as pojo and list of pojo(Product)
    @Select("SELECT * FROM products")
    List<Product> select();

    @Select("SELECT * FROM products WHERE id =?")
    Optional<Product> selectProductById(@Param("id") Integer id);
}
