package co.edu.udea.vuelosback.application;

import co.edu.udea.vuelosback.core.dto.UpdateUserDto;
import co.edu.udea.vuelosback.security.jwt.JwtFilter;
import co.edu.udea.vuelosback.core.dao.UserRepository;
import co.edu.udea.vuelosback.core.dto.UserResponseDto;
import co.edu.udea.vuelosback.core.interfaces.IUserService;
import co.edu.udea.vuelosback.core.models.ApplicationRole;
import co.edu.udea.vuelosback.core.models.User;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    public UserResponseDto getUserById(UUID id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new GraphQLException("User not found");
        }
        return new UserResponseDto(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAplicationRole().getRol()
        );
    }

    @Override
    public UserResponseDto assignRoleToUser(UUID userId, ApplicationRole roleName) {
        return null;
    }


    public void updateUserRole(UUID id, String newRole) {

        if (!jwtFilter.isAdmin()) {
            throw new GraphQLException("You are not authorized to perform this action");
        }

        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new GraphQLException("User not found");
        }

        if (newRole != null) {
            user.setAplicationRole(ApplicationRole.valueOf(newRole));
            userRepository.save(user);
        }else {
            throw new RuntimeException("Invalid role");
        }
    }

    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new GraphQLException("No users found");
        }
        return users.stream()
                .map(user -> new UserResponseDto(
                        user.getId(),
                        user.getFullName(),
                        user.getEmail(),
                        user.getPhoneNumber(),
                        user.getAplicationRole().getRol()
                ))
                .collect(Collectors.toList());
    }

    public UserResponseDto updateUser(UpdateUserDto updateUserDto) {
        User user = userRepository.findById(updateUserDto.getId()).orElse(null);
        if (user == null) {
            throw new GraphQLException("User not found");
        }
        user.setFullName(updateUserDto.getFullName());
        user.setPhoneNumber(updateUserDto.getPhoneNumber());
        userRepository.save(user);
        return new UserResponseDto(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAplicationRole().getRol()
        );
    }

}
