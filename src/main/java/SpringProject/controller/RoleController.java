package SpringProject.controller;


import SpringProject.converter.RoleConverter;
import SpringProject.dto.role.RoleResponse;
import SpringProject.dto.role.RoleSaveRequest;
import SpringProject.dto.role.RoleUpdateRequest;
import SpringProject.entity.Role;
import SpringProject.service.RoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/roles") // if needed value = "/v1/roles"
@Transactional
public class RoleController {

    private final RoleService roleService;
    private final RoleConverter roleConverter;

    @GetMapping
    public ResponseEntity<Set<RoleResponse>> findAll(){

        return ResponseEntity.ok(roleService.findAll()
                .stream()
                .map(roleConverter::convert)
                .collect(Collectors.toSet()));

    }

    @PostMapping
    public ResponseEntity<RoleResponse> save(@RequestBody @Valid RoleSaveRequest roleSaveRequest){
        Role role =roleConverter.convert(roleSaveRequest);
        Role savedRole = roleService.save(role);
        RoleResponse response = roleConverter.convert(savedRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable("id") Long id){
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "/name/{name}" )
    public ResponseEntity<Void>delete(@PathVariable("name") String name) {
        roleService.delete(name);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<RoleResponse> update(@RequestBody @Valid RoleUpdateRequest roleUpdateRequest){
        Role role = roleConverter.convert(roleUpdateRequest);
        Role updatedRole = roleService.update(role, role.getId());
        return ResponseEntity.ok(roleConverter.convert(updatedRole));
    }



}
