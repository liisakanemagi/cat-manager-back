package ee.valiit.catmanager.persistence.catstatus;

import ee.valiit.catmanager.controller.catstatus.CatStatusInfo;
import org.mapstruct.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CatStatusMapper {


    List<CatStatusInfo> toCatStatusInfos(List<CatStatus> catStatuses);

}