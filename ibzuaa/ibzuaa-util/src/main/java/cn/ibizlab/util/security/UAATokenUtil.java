package cn.ibizlab.util.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.SneakyThrows;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
//@ConditionalOnExpression("${ibiz.enablePermissionValid:false}||'${ibiz.auth.service:SimpleTokenUtil}'.equals('UAATokenUtil')")
public class UAATokenUtil implements AuthTokenUtil, Serializable {

    private static final long serialVersionUID = -3301605591108950415L;
    private Clock clock = DefaultClock.INSTANCE;

    @Value("${ibiz.jwt.secret:ibzsecret}")
    private String secret;

    @Value("${ibiz.jwt.expiration:7200000}")
    private Long expiration;

    @Value("${ibiz.jwt.header:Authorization}")
    private String tokenHeader;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token) {
        PublicKey publicKey = getPublicKey(getPublicKeyString());
        return Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(clock.now());
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = clock.now();
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.RS256, getPrivateKey(getPrivateKeyString()))
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        AuthenticationUser user = (AuthenticationUser) userDetails;
        final Date created = getIssuedAtDateFromToken(token);
        return (!isTokenExpired(token) );
    }

    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration);
    }

    @SneakyThrows
    private String getPrivateKeyString(){
        String key="";
        String usrHome = System.getProperty("user.home")+"/.ibzrt";
        File priKeyFile=new File(usrHome,"ibzrt_rsa");
        if(!priKeyFile.exists())
        {
            key = IOUtils.toString(this.getClass().getResourceAsStream("/keypair/ibzrt_rsa"));
        }
        else{
            key = IOUtils.toString(new FileInputStream(priKeyFile));
        }
        return key;
    }

    @SneakyThrows
    private String getPublicKeyString(){
        String key="";
        String usrHome = System.getProperty("user.home")+"/.ibzrt";
        File pubKeyFile=new File(usrHome,"ibzrt_rsa.pub");
        if(!pubKeyFile.exists())
        {
            key = IOUtils.toString(this.getClass().getResourceAsStream("/keypair/ibzrt_rsa.pub"));
        }
        else{
            key = IOUtils.toString(new FileInputStream(pubKeyFile));
        }
        return key;
    }

    /**
     * 获取PublicKey对象
     * @param publicKeyBase64
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    @SneakyThrows
    public PublicKey getPublicKey(String publicKeyBase64) {
        byte[] byteKey = Base64.decodeBase64(publicKeyBase64);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(byteKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(x509EncodedKeySpec);
    }

    /**
     * 获取PrivateKey对象
     * @param privateKeyBase64
     * @return
     */
    @SneakyThrows
    private PrivateKey getPrivateKey(String privateKeyBase64) {
        byte[] byteKey = Base64.decodeBase64(privateKeyBase64);
        PKCS8EncodedKeySpec x509EncodedKeySpec = new PKCS8EncodedKeySpec(byteKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(x509EncodedKeySpec);
    }
}

