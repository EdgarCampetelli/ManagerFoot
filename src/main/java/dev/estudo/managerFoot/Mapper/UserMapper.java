package dev.estudo.managerFoot.Mapper;

import dev.estudo.managerFoot.Controller.request.UserRequest;
import dev.estudo.managerFoot.Controller.response.UserResponse;
import dev.estudo.managerFoot.Entity.Scope;
import dev.estudo.managerFoot.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "scopes", source = "scopeList", qualifiedByName = "mapScopesEntityToScopesString")
    UserResponse toUserResponder(User user);
    @Named("mapScopesEntityToScopesString")
    default List<String> mapScopesEntityToScopesString(List<Scope> scopes){
        if (scopes == null ) return List.of();
        return scopes.stream()
                .map(Scope::getName)
                .toList();
    }


    @Mapping(target = "scopeList", source = "scopes", qualifiedByName = "mapScopsIdToScopesEntity")
    User toUser(UserRequest request);
    @Named("mapScopsIdToScopesEntity")
    default List<Scope> mapScopsIdToScopesEntity(List<Long> scopeIds){
        if (scopeIds == null ) return List.of();

        return scopeIds.stream()
                .map(id -> Scope.builder().id(id).build())
                .toList();
    }
}
