package co.edu.udea.vuelosback.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private UUID id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String role;
}
