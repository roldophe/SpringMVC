package co.istad.sb7springwebmvc.repository;

import co.istad.sb7springwebmvc.model.Supplier;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SupplierRepository {
    @Select("SELECT * FROM suppliers WHERE id=#{id}")
    Supplier selectSupplierById(@Param("id") Integer id);
    @Select("SELECT * FROM suppliers")
    List<Supplier> loadSuppliers();
    @Insert("""
            INSERT INTO suppliers (company, since, status)
            VALUES(#{s.company}, #{s.since}, #{s.status})
            """)
    void insertProductSupplier(@Param("s") Supplier supplier);

    @Update("""
                    UPDATE suppliers
                    SET company= #{s.company},
                        status=#{s.status}
                    WHERE id = #{s.id}
            """)
    void updateSupplierById(@Param("s") Supplier supplier);
    @Delete("DELETE FROM suppliers WHERE id = #{id}")
    void delete(@Param("id") Integer id);
}
