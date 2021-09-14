package de.hsvoss.java_101_schulung.mapper;

import de.hsvoss.java_101_schulung.domain.Berater;
import de.hsvoss.java_101_schulung.model.ConsultantDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = ClientMapper.class)
public interface ConsultantMapper {


    @Mapping(target = "shoe", ignore = true)
    @Mapping(target = "shoe.size", source = "schuhgroesse")
    @Mapping(target = "shoe.brand", source = "schuhmarke")
    @Mapping(target = "clients", source = "kunden")
    ConsultantDTO beraterToConsultantDto(Berater berater);

    @Mapping(target = "schuhmarke", source = "shoe.brand")
    @Mapping(target = "schuhgroesse", source = "shoe.size")
    @Mapping(target = "kunden", source = "clients")
    Berater consultantDtoToBerater(ConsultantDTO consultantDTO);

}
