package de.hsvoss.java_101_schulung;

import de.hsvoss.java_101_schulung.domain.Berater;
import de.hsvoss.java_101_schulung.mapper.ConsultantMapper;
import de.hsvoss.java_101_schulung.model.ConsultantDTO;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {

        ConsultantMapper mapper = Mappers.getMapper(ConsultantMapper.class);

        List<Berater> beraterList = Helper.generateData();


        Berater.BeraterBuilder builder = Berater.builder();

        Berater oleg = builder.schuhgroesse(48)
                .name("Oleg")
                .kunden(Collections.emptySet())
                .build();
        System.out.println(oleg);

        List<ConsultantDTO> collect = beraterList.stream().map(mapper::beraterToConsultantDto)
                .collect(Collectors.toList());

        System.out.println(collect);

    }
}
