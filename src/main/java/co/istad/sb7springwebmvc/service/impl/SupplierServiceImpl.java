package co.istad.sb7springwebmvc.service.impl;

import co.istad.sb7springwebmvc.model.Supplier;
import co.istad.sb7springwebmvc.repository.SupplierRepository;
import co.istad.sb7springwebmvc.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;

    @Override
    public List<Supplier> loadSuppliers() {
        return supplierRepository.loadSuppliers();
    }

    @Override
    public Supplier loadSupplierById(Integer id) {
        return supplierRepository.selectSupplierById(id);
    }

    @Override
    public void createNewSupplier(Supplier supplier) {
        supplier.setSince(LocalDate.now());
        supplier.setStatus(true);
        supplierRepository.insertProductSupplier(supplier);
    }

    @Override
    public void updateSupplierById(Integer id, Supplier supplier) {
        supplier.setId(id);
        supplierRepository.updateSupplierById(supplier);
    }


}
