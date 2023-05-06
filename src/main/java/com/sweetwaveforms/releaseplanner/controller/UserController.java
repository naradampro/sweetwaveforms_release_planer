package com.sweetwaveforms.releaseplanner.controller;

import com.sweetwaveforms.releaseplanner.dto.UserDTO;
import com.sweetwaveforms.releaseplanner.model.User;
import com.sweetwaveforms.releaseplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        List<User> users = userService.findAll();
        return users.stream()
                .map(this::mapUserToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = mapDTOToUser(userDTO);
        User savedUser = userService.save(user);
        return ResponseEntity.created(getUserLocation(savedUser)).body(mapUserToDTO(savedUser));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private URI getUserLocation(User user) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(user.getEmail())
                .toUri();
    }

    private User mapDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    private UserDTO mapUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}