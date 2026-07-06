package com.coding.SecurityApp.SecurityApplication.utils;

import com.coding.SecurityApp.SecurityApplication.entities.enums.Permissions;
import com.coding.SecurityApp.SecurityApplication.entities.enums.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;


import static com.coding.SecurityApp.SecurityApplication.entities.enums.Permissions.*;
import static com.coding.SecurityApp.SecurityApplication.entities.enums.Role.*;

public class PermissionMapping {

  private static final Map<Role, Set<Permissions>> map = Map.of(
            USER,Set.of(USER_VIEW,POST_VIEW),
            CREATOR,Set.of(USER_VIEW,POST_VIEW,USER_UPDATE,POST_UPDATE),
            ADMIN,Set.of(USER_DELETE,USER_CREATE,POST_DELETE)
    );

  public static Set<SimpleGrantedAuthority> getAuthoritiesForRole(Role role){
      return map.get(role).stream()
              .map(permission->new SimpleGrantedAuthority(permission.name()))
              .collect(Collectors.toSet());
  }

}
