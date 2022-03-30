package com.example.Ejercicio.DB0.Persona.Infrastructure.Controller;

import com.example.Ejercicio.DB0.Persona.Infrastructure.Controller.DTO.output.PersonaoutputDTO;
import com.example.Ejercicio.DB0.Persona.application.PersonaService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {

    @Autowired
    PersonaService personaService;

    @PostMapping("login")
    public ResponseEntity <String> login(@RequestParam("usuario") String usuario, @RequestParam("password") String pwd){
            personaService.checkPassword(usuario,pwd);
          PersonaoutputDTO personaoutputDTO= personaService.findUsuario(usuario,"").getLista().get(0);
          String rol= personaoutputDTO.isAdmin()? "ROLE_ADMIN":"ROLE_USER";
          return new  ResponseEntity<> (getJWTToken(usuario,rol), HttpStatus.OK);
    }

    private String getJWTToken(String username, String rol) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(rol);

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
