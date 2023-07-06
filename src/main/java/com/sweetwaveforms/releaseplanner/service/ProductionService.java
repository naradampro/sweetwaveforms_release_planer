package com.sweetwaveforms.releaseplanner.service;

import com.sweetwaveforms.releaseplanner.exception.ResourceNotFoundException;
import com.sweetwaveforms.releaseplanner.model.Production;
import com.sweetwaveforms.releaseplanner.repository.ProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionService {

    private final ProductionRepository productionRepository;

    @Autowired
    public ProductionService(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    public List<Production> getAllProductions() {
        return productionRepository.findAll();
    }

    public Production createProduction(Production production) {
        return productionRepository.save(production);
    }

    public Production getProductionById(Long id) {
        return productionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Production not exist with id :" + id));
    }

    public Production updateProduction(Long id, Production productionDetails) {
        Production production = productionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Production not exist with id :" + id));

        production.setReleaseId(productionDetails.getReleaseId());
        production.setliveLink(productionDetails.getliveLink());
        production.setCreatedDateTime(productionDetails.getCreatedDateTime());

        return productionRepository.save(production);
    }

    public void deleteProduction(Long id) {
        Production production = productionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not exist with id :" + id));

        productionRepository.delete(production);
    }
}

