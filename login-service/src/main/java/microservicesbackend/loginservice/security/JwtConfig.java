package microservicesbackend.loginservice.security;

import org.springframework.beans.factory.annotation.Value;

public class JwtConfig {


    @Value("${security.jwt.uri:/auth/**}")
    private String Uri;

    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Value("${security.jwt.expiration:#{21}}")
    private int expiration;

    @Value("${security.jwt.secret:r1ooYm6xArr1ooYmr1ooYm6xArr1ooYmr1ooYr1ooYr1ooYm6xArr1ooYmr1ooYr1ooYm6xArr1ooYm6xArr1ooYm6xArm6xArr1ooYm6xr1ooYm6xArr1ooYmr1ooYr1ooYm6xArr1ooYm6xArr1ooYm6xArm6xArr1ooYm6xArr1ooYm6xAr6xArr1ooYm6xArArr1ooYm6xAr6xArr1ooYm6xArm6xArr1ooYm6xArr1ooYm6xArm6xArr1ooYm6xArr1ooYm6xAr6xArr1ooYm6xArr1ooYr1ooYr1ooYm6xArr1ooYmr1ooYr1ooYm6xArr1ooYm6xArr1ooYm6xArm6xArr1ooYm6xr1ooYm6xArr1ooYmr1ooYr1ooYm6xArr1ooYm6xArr1ooYm6xArm6xArr1ooYm6xArr1ooYm6xAr6xArr1ooYm6xArArr1ooYm6xAr6xArr1ooYm6xArm6xArr1ooYm6xArr1ooYm6xArm6xArr1ooYm6xArr1ooYm6xAr6xArr1ooYm6xAr}")
    private String secret;

    // In case you want to use plain getters instead of lombok.
    public String getUri() {
        return Uri;
    }

    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public String getSecret() {
        return secret;
    }

}
