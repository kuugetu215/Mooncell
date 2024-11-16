package utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtUtils {
    private static final String SIGN = "karazuki"; // 签名

    public static String getToken(Map<String, String > payload) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);  // 7天过期

        // 创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        // 设置payload
        payload.forEach((k,v) -> {
            builder.withClaim(k, v);
        });

        String token = builder.withExpiresAt(instance.getTime())  // 指定令牌过期时间
                .sign(Algorithm.HMAC256(SIGN));// 签名

        return token;
    }

    public static DecodedJWT decode(String token){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SIGN)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT;
    }
}
