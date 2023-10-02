package co.istad.sb7springwebmvc.service;

import co.istad.sb7springwebmvc.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> loadSuppliers();
    Supplier loadSupplierById(Integer id);
    void createNewSupplier(Supplier supplier);
    void updateSupplierById(Integer id, Supplier supplier);
}
