package fr.miage.mbds.account;

import lombok.Data;

@Data
public class CustomerProxy {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
