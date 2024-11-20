package co.edu.udea.vuelosback.core.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


import java.util.UUID;

@NamedQuery(
  name = "User.findByEmail",
  query = "SELECT u FROM User u WHERE u.email = :email"
)

@Entity
@Table(name = "Users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private UUID id;

  @Column(name = "full_name", nullable = false, length = 100)
  private String fullName;

  @Column(name = "email", nullable = false, length = 100)
  private String email;

  @Column(name = "password", nullable = false, length = 100)
  private String password;

  @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

  @Enumerated(EnumType.STRING)
  @Column(name = "rolesAplicacion", length = 30)
  private ApplicationRole applicationRole;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public ApplicationRole getAplicationRole() {
    return applicationRole;
  }

  public void setAplicationRole(ApplicationRole aplicationRole) {
    this.applicationRole = aplicationRole;
  }

  public void setRole(String newRole) {

  }

}
