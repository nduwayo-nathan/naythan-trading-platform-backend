package com.naythan.trading.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.naythan.trading.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String fullName;
    private  String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Embedded
    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();

    @Enumerated(EnumType.STRING)
    private USER_ROLE role= USER_ROLE.ROLE_CUSTOMER;
}
