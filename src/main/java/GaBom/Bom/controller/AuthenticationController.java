package GaBom.Bom.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @RequestMapping("/auth")
    public Authentication auth(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @PreAuthorize("hasAnyAuthority(ROLE_USER)")
    @RequestMapping("/user")
    public SecurityMessage user(){
        return SecurityMessage.builder()
                .authentication(SecurityContextHolder.getContext().getAuthentication())
                .message("User 정보")
                .build();
    }

    @PreAuthorize("hasAnyAuthority(ROLE_ADMIN)")
    @RequestMapping("/admin")
    public SecurityMessage admin(){
        return SecurityMessage.builder()
                .authentication(SecurityContextHolder.getContext().getAuthentication())
                .message("User 정보")
                .build();
    }

}
