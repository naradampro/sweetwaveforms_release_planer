package com.sweetwaveforms.releaseplanner.service;

import com.sweetwaveforms.releaseplanner.exception.ResourceNotFoundException;
import com.sweetwaveforms.releaseplanner.model.SongRequest;
import com.sweetwaveforms.releaseplanner.model.SongRequestStatus;
import com.sweetwaveforms.releaseplanner.repository.SongRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongRequestService {

    private final SongRequestRepository songRequestRepository;

    @Autowired
    public SongRequestService(SongRequestRepository songRequestRepository) {
        this.songRequestRepository = songRequestRepository;
    }

    public List<SongRequest> getAllSongRequests() {
        return songRequestRepository.findAll();
    }

    public SongRequest createSongRequest(SongRequest songRequest) {
        songRequest.setStatus(SongRequestStatus.PENDING); // Set default status as PENDING
        return songRequestRepository.save(songRequest);
    }

    public SongRequest getSongRequestById(Long id) {
        return songRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song request not exist with id :" + id));
    }

    public SongRequest updateSongRequest(Long id, SongRequest songRequestDetails) {
        SongRequest songRequest = songRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song request not exist with id :" + id));

        songRequest.setTitle(songRequestDetails.getTitle());
        songRequest.setArtistName(songRequestDetails.getArtistName());
        songRequest.setYoutubeLink(songRequestDetails.getYoutubeLink());
        songRequest.setCreatorId(songRequestDetails.getCreatorId());

        // Set status based on the status in songRequestDetails
        if (songRequestDetails.getStatus() != null) {
            songRequest.setStatus(songRequestDetails.getStatus());
        }

        return songRequestRepository.save(songRequest);
    }

    public void deleteSongRequest(Long id) {
        SongRequest songRequest = songRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Song request not exist with id :" + id));

        songRequestRepository.delete(songRequest);
    }
}
