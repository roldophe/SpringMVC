package co.istad.sb7springwebmvc.controller;

import co.istad.sb7springwebmvc.model.Supplier;
import co.istad.sb7springwebmvc.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping
    public List<Supplier> loadSuppliers() {
        return supplierService.loadSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier loadSupplierById(@PathVariable("id") Integer id) {
        return supplierService.loadSupplierById(id);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewSupplier(@RequestBody Supplier supplier) {
        supplierService.createNewSupplier(supplier);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateSupplierById(@PathVariable Integer id,
                                   @RequestBody Supplier supplier) {
        supplierService.updateSupplierById(id, supplier);
    }
}
