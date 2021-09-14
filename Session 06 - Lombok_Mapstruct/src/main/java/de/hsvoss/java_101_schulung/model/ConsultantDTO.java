package de.hsvoss.java_101_schulung.model;

import lombok.Data;

@Data
public class ConsultantDTO {
    private String name;
    private ClientDTO[] clients;
    private ShoeDTO shoe;

}
