package co.istad.sb7springwebmvc.repository;

import co.istad.sb7springwebmvc.model.Category;
import co.istad.sb7springwebmvc.repository.CategoryProvider.CategoryProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryRepository {
    @SelectProvider(CategoryProvider.class)
    List<Category> selectProductCategories(@Param("productId") Integer productId);
    @SelectProvider(CategoryProvider.class)
    List<Category> selectCategories();

    @Select("SELECT * FROM categories WHERE id=#{id}")
    Category selectCategoryByID(@Param("id") Integer id);
    //@SelectProvider(CategoryProvider.class)
    @Insert("""
                INSERT INTO categories(name, description)
                VALUES (#{c.name},#{c.description})
            """)
    void insertCategory(@Param("c") Category category);
    @Update("""
            UPDATE categories
            SET name=#{c.name},
                description=#{c.description}
                WHERE id=#{id};
            """)
    void updateCategoryByID(@Param("id")Integer id,@Param("c") Category category);
}
