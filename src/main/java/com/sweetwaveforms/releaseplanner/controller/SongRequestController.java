package com.sweetwaveforms.releaseplanner.controller;

import com.sweetwaveforms.releaseplanner.model.SongRequest;
import com.sweetwaveforms.releaseplanner.service.SongRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:9091")
@RestController
@RequestMapping("/api/v1/")
public class SongRequestController {

    private final SongRequestService songRequestService;

    @Autowired
    public SongRequestController(SongRequestService songRequestService) {
        this.songRequestService = songRequestService;
    }

    // get all song requests
    @GetMapping("/song-requests")
    public List<SongRequest> getAllSongRequests(){
        return songRequestService.getAllSongRequests();
    }

    // create song request rest api
    @PostMapping("/song-requests")
    public SongRequest createSongRequest(@RequestBody SongRequest songRequest) {
        return songRequestService.createSongRequest(songRequest);
    }

    // get song request by id rest api
    @GetMapping("/song-requests/{id}")
    public ResponseEntity<SongRequest> getSongRequestById(@PathVariable Long id) {
        SongRequest songRequest = songRequestService.getSongRequestById(id);
        return ResponseEntity.ok(songRequest);
    }

    // update song request rest api
    @PutMapping("/song-requests/{id}")
    public ResponseEntity<SongRequest> updateSongRequest(@PathVariable Long id, @RequestBody SongRequest songRequestDetails){
        SongRequest updatedSongRequest = songRequestService.updateSongRequest(id, songRequestDetails);
        return ResponseEntity.ok(updatedSongRequest);
    }

    // delete song request rest api
    @DeleteMapping("/song-requests/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteSongRequest(@PathVariable Long id){
        songRequestService.deleteSongRequest(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
