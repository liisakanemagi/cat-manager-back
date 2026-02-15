package ee.valiit.catmanager.persistence.cat;

import ee.valiit.catmanager.controller.cat.CatInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CatMapper {
    @Mapping(target = "createdAt", ignore = true)
    Cat toCat(CatInfo catInfo);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Cat partialUpdate(CatInfo catInfo, @MappingTarget Cat cat);
}