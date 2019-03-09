package com.sabre.pnrretriever.headers.security_header;

import com.sabre.pnrretriever.config.properties.HeaderProperties;
import com.sabre.web_services.wsse.Security;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecurityRq {

    @Autowired
    private HeaderProperties headerProperties;

    @Value(value = "${security.username}")
    private String username;

    @Value(value = "${security.password}")
    private String password;

    @Setter
    private String token;

    public Security getSessionSecurityHeader() {
        Security security = new Security();
        Security.UsernameToken usernameToken = new Security.UsernameToken();
        usernameToken.setUsername(username);
        usernameToken.setPassword(password);
        usernameToken.setOrganization(headerProperties.getCpaid());
        usernameToken.setDomain("DEFAULT");
        security.setUsernameToken(usernameToken);
        return security;
    }

    public Security getSecurityHeader() {
        Security security = new Security();
        security.setBinarySecurityToken(token);
        return security;
    }
}
