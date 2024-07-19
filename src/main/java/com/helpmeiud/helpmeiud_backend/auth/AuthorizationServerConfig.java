package com.helpmeiud.helpmeiud_backend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

/**
 * proceso de autenticación por OAuth2: login, etc.
 * todo lo relacionado con el login, autenticación con oauth2, creación del token
 * validación del token, toda esa parte
 *
 * @author JULIOCESARMARTINEZ
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${security.jwt.client-service}")
    private String client;

    @Value("${security.jwt.password-service}")
    private String secret;

    @Value("${security.jwt.scope-read}")
    private String read;

    @Value("${security.jwt.scope-write}")
    private String write;

    @Value("${security.jwt.grant-password}")
    private String grantPassword;

    @Value("${security.jwt.grant-refresh}")
    private String grantRefresh;

    @Value("${security.jwt.token-validity-seconds}")
    private Integer accessTime;

    @Value("${security.jwt.refresh-validity-seconds}")
    private Integer refreshTime;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenMoreInfo tokenMoreInfo;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenMoreInfo, accessTokenConverter()));
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(tokenEnhancerChain);//
    }

    /*permisos para rutas de acceso*/
    // ruta de login debe ser publica (servicio de autenticación)
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .passwordEncoder(passwordEncoder)//---- 2
                .tokenKeyAccess("permitAll()")//permisos usuarios anónimos o no //---1
                .checkTokenAccess("isAuthenticated()");//chequea o valida el token; permiso a endpoint que valida token
        // acceden solo usuarios autenticados //------1
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()// tipo de almacenamiento
                .withClient(client)// creamos cliente
                .secret(passwordEncoder.encode(secret))//contraseña y codificamos
                .scopes(read, write)// scope: permisos que va tener la app
                .authorizedGrantTypes(grantPassword, grantRefresh)//tipo de concesión del token, como se va a obtener (hay otros mas)
                // refresh token obtiene token de acceso renovado y poder continuar en los recursos antes que caduque el token
                .accessTokenValiditySeconds(accessTime)//tiempo de validez o cuando caduca
                .refreshTokenValiditySeconds(refreshTime);// tiempo para el refresh token
        // aqui puedes crear credenciales y demas parametros para más apps
    }


    /**
     * se encarga de crear el token y almacenarlo
     * pero JWtAccess trabaja con el, entonces se pone opcional
     * pero lo hacemos explicitamente
     *
     * @return
     */
    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    // ponemos de tipo de dato siempre la interface genérica
    // retorna un bean
    // traduce la información del token
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        //*-----1
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();// por defacto tiene un token storag
        //------ 2-------------------------
        jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVATE);// clave secreta
        jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLIC);
        //------ 1
        return new JwtAccessTokenConverter();// crea un
    }
}
