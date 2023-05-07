package com.sweetwaveforms.releaseplanner.service;

import com.sweetwaveforms.releaseplanner.exception.ResourceNotFoundException;
import com.sweetwaveforms.releaseplanner.model.File;
import com.sweetwaveforms.releaseplanner.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public File createFile(File file) {
        return fileRepository.save(file);
    }

    public File getFileById(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not exist with id :" + id));
    }

    public File updateFile(Long id, File fileDetails) {
        File file = fileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not exist with id :" + id));

        file.setName(fileDetails.getName());
        file.setCloudStoreLink(fileDetails.getCloudStoreLink());
        file.setType(fileDetails.getType());

        return fileRepository.save(file);
    }

    public void deleteFile(Long id) {
        File file = fileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not exist with id :" + id));

        fileRepository.delete(file);
    }
}

