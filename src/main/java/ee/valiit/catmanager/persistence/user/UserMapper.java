package ee.valiit.catmanager.persistence.user;

import ee.valiit.catmanager.controller.login.LoginResponse;
import ee.valiit.catmanager.controller.register.UserInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role", target = "userRole")
    LoginResponse toLoginResponse (User user);
    
    @Mapping(source = "email",target = "email")
    @Mapping(source = "password",target = "password")
    @Mapping(source = "username",target = "username")
    User toUser(UserInfo userInfo);

}