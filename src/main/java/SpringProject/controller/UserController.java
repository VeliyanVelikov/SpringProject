package SpringProject.controller;


import SpringProject.converter.UserConverter;
import SpringProject.dto.user.UserResponse;
import SpringProject.dto.user.UserSaveRequest;
import SpringProject.entity.User;
import SpringProject.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")

public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping
    public ResponseEntity<Set<UserResponse>>findAll(){
        return ResponseEntity.ok(userService.findAll()
                .stream()
                .map(userConverter::convert)
                .collect(Collectors.toSet())
        );
    }

    @PostMapping
    public ResponseEntity<UserResponse>save(@RequestBody @Valid UserSaveRequest userSaveRequest){
        User user = userConverter.convert(userSaveRequest);
        User savedUser = userService.save(user);
        UserResponse userResponse =userConverter.convert(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }


}
