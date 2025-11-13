package fr.miage.mbds.account;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerProxy {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
