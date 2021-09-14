package de.hsvoss.java_101_schulung.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kunde {
    private String firmenname;
    private Branche branche;


}
