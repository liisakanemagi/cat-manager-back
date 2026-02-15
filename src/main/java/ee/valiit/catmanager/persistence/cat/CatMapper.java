package ee.valiit.catmanager.persistence.cat;

import ee.valiit.catmanager.controller.cat.CatInfo;
import ee.valiit.catmanager.infrastructure.util.ImageConverter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = ImageConverter.class)
public interface CatMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "imageData", source = "imageData")
    Cat toCat(CatInfo catInfo);

    @Mapping(target = "imageData", source = "imageData")
    CatInfo toCatInfo(Cat cat);
}