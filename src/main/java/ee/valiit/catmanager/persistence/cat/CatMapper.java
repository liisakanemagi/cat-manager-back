package ee.valiit.catmanager.persistence.cat;

import ee.valiit.catmanager.controller.cat.CatDto;
import ee.valiit.catmanager.controller.cat.CatInfo;
import ee.valiit.catmanager.infrastructure.util.ImageConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = ImageConverter.class)
public interface CatMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "imageData", source = "imageData")
    Cat toCat(CatInfo catInfo);

    @Mapping(target = "imageData", source = "imageData")
    CatDto toCatDto(Cat cat);

    List<CatDto> toCatDtos(List<Cat> cats);

    void updateCat(CatInfo catInfo, @MappingTarget Cat cat);
}
