package co.edu.udea.vuelosback.core.interfaces;

import co.edu.udea.vuelosback.core.dto.UpdateUserDto;
import co.edu.udea.vuelosback.core.dto.UserResponseDto;
import co.edu.udea.vuelosback.core.models.ApplicationRole;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    UserResponseDto getUserById(UUID id);
    UserResponseDto assignRoleToUser(UUID userId, ApplicationRole roleName);
    void updateUserRole(UUID id, String role);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(UpdateUserDto updateUserDto);
}
