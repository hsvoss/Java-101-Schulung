package de.hsvoss.java_101_schulung.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.util.Set;

@Builder
@With
@Data
@AllArgsConstructor
public class Berater {

    private String name;
    private int schuhgroesse;
    private String schuhmarke;
    private Set<Kunde> kunden;

}
