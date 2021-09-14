package de.hsvoss.java_101_schulung.mapper;

import de.hsvoss.java_101_schulung.domain.Kunde;
import de.hsvoss.java_101_schulung.model.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClientMapper {

    @Mapping(target = "company", source = "firmenname")
    @Mapping(target = "branch", source = "branche")
    public ClientDTO kundeToClientDTO(Kunde kunde);

    @Mapping(target = "firmenname", source = "company")
    @Mapping(target = "branche", source = "branch")
    public Kunde clientDtoToKunde(ClientDTO clientDTO);
}
