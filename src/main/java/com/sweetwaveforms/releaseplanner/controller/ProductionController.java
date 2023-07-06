package com.sweetwaveforms.releaseplanner.controller;

import com.sweetwaveforms.releaseplanner.model.Production;
import com.sweetwaveforms.releaseplanner.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:9095")
@RestController
@RequestMapping("/api/v1/")
public class ProductionController {
    private final ProductionService productionService;

    @Autowired
    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    // get all productions
    @GetMapping("/productions")
    public List<Production> getAllProductions(){
        return productionService.getAllProductions();
    }

    // create production rest api
    @PostMapping("/productions")
    public Production createProduction(@RequestBody Production production) {
        return productionService.createProduction(production);
    }

    @GetMapping("/productions/{id}")
            public ResponseEntity<Production> getProductionById(@PathVariable Long id) {
        Production production = productionService.getProductionById(id);
        return ResponseEntity.ok(production);
    }

    // update production rest api
    @PutMapping("/productions/{id}")
    public ResponseEntity<Production> updateProduction(@PathVariable Long id, @RequestBody Production productionDetails){
        Production updatedUser = productionService.updateProduction(id, productionDetails);
        return ResponseEntity.ok(updatedUser);
    }

    // delete production rest api
    @DeleteMapping("/productions/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduction(@PathVariable Long id){
        productionService.deleteProduction(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
