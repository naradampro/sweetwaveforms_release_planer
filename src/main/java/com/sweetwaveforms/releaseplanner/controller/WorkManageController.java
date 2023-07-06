package com.sweetwaveforms.releaseplanner.controller;

import com.sweetwaveforms.releaseplanner.model.WorkManager;
import com.sweetwaveforms.releaseplanner.service.WorkManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:9094")
@RestController
@RequestMapping("/api/v1")
public class WorkManageController {

    private final WorkManageService workManageService;

    @Autowired
    public WorkManageController(WorkManageService workManageService){
        this.workManageService = workManageService;
    }
    @GetMapping("/approve-requests")
    public List<WorkManager> gellAllWorkManagers(){ return workManageService.gellAllWorkManagers();}

    @PostMapping("/approve-requests")
    public WorkManager createWorkManager(@RequestBody WorkManager workManager){
        return workManageService.createWorkManager(workManager);
    }

    @GetMapping("/approve-request/{id}")
    public ResponseEntity<WorkManager> getWorkManagerById(@PathVariable Long id){
        WorkManager workManager = workManageService.getWorkManagerById(id);
        return ResponseEntity.ok(workManager);
    }

    @PutMapping("/approve-request/{id}")
    public ResponseEntity<WorkManager> updateWorkManager(@PathVariable Long id, @RequestBody WorkManager workManager){
        WorkManager updateWorkManager = workManageService.updateWorkManager(id, workManager);
        return ResponseEntity.ok(updateWorkManager);
    }

    @DeleteMapping("/approve-request/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteWorkManager(@PathVariable Long id){
        workManageService.deleteWorkManager(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
