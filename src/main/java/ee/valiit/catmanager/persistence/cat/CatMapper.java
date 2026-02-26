package ee.valiit.catmanager.persistence.cat;

import ee.valiit.catmanager.controller.cat.CatDto;
import ee.valiit.catmanager.controller.cat.CatInfo;
import ee.valiit.catmanager.infrastructure.util.ImageConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = ImageConverter.class)
public interface CatMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "imageData", source = "imageData")
    Cat toCat(CatInfo catInfo);

    @Mapping(target = "imageData", source = "imageData")
    CatDto toCatDto(Cat cat);

    List<CatDto> toCatDtos(List<Cat> cats);
}
