package com.sweetwaveforms.releaseplanner.controller;

import com.sweetwaveforms.releaseplanner.model.File;
import com.sweetwaveforms.releaseplanner.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:9091", "http://localhost:9092"})
@RestController
@RequestMapping("/api/v1/")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    // get all files
    @GetMapping("/files")
    public List<File> getAllFiles(){
        return fileService.getAllFiles();
    }

    // create file rest api
    @PostMapping("/files")
    public File createFile(@RequestBody File file) {
        return fileService.createFile(file);
    }

    // get file by id rest api
    @GetMapping("/files/{id}")
    public ResponseEntity<File> getFileById(@PathVariable Long id) {
        File file = fileService.getFileById(id);
        return ResponseEntity.ok(file);
    }

    // update file rest api
    @PutMapping("/files/{id}")
    public ResponseEntity<File> updateFile(@PathVariable Long id, @RequestBody File fileDetails){
        File updatedFile = fileService.updateFile(id, fileDetails);
        return ResponseEntity.ok(updatedFile);
    }

    // delete file rest api
    @DeleteMapping("/files/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFile(@PathVariable Long id){
        fileService.deleteFile(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

