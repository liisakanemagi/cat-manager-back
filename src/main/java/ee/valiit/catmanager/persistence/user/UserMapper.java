package ee.valiit.catmanager.persistence.user;

import ee.valiit.catmanager.controller.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    LoginResponse toLoginResponse (User user);

}