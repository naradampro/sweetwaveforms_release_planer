package com.sweetwaveforms.releaseplanner.service;

import com.sweetwaveforms.releaseplanner.exception.ResourceNotFoundException;
import com.sweetwaveforms.releaseplanner.model.WorkManager;
import com.sweetwaveforms.releaseplanner.model.WorkType;
import com.sweetwaveforms.releaseplanner.repository.WorkManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkManageService {

    private final WorkManageRepository workManageRepository;

    @Autowired
    public WorkManageService(WorkManageRepository workManageRepository) {
        this.workManageRepository = workManageRepository;
    }

    public List<WorkManager> gellAllWorkManagers(){return workManageRepository.findAll();}

    public WorkManager createWorkManager(WorkManager workManager){
        workManager.setWorkType(WorkType.PENDING);
        return workManageRepository.save(workManager);
    }

    public WorkManager getWorkManagerById(Long id){
        return workManageRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Approve request not exist with id :"+id));
    }

    public WorkManager updateWorkManager(Long id, WorkManager workManager){
        WorkManager workManager1 = workManageRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Approve request not exist with id: "+id));

        workManager.setStatus(workManager.getStatus());
        workManager.setApprovedBy(workManager.getApprovedBy());
        workManager.setWorkType(workManager.getWorkType());

        if (workManager.getStatus()!=null){
            workManager.setStatus(workManager.getStatus());
        }
        return workManageRepository.save(workManager);
    }

    public void deleteWorkManager(Long id){
        WorkManager workManager = workManageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Approve request not exist with id: "+id));
    }
}
