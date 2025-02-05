package br.com.iouone.util;

import java.util.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class JwtUtil {

    public static Map<String, Object> decodeJwt(String token) {
        try {
            String[] parts = token.split("\\."); // JWT tem três partes: Header, Payload, Signature
            String payload = new String(Base64.getUrlDecoder().decode(parts[1])); // Decodifica o Payload
            
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(payload, Map.class); // Converte para um Map
        } catch (Exception e) {
            throw new RuntimeException("Erro ao decodificar JWT", e);
        }
    }

    public static String getUserIdFromToken(String token) {
        return String.valueOf(decodeJwt(token).get("id")); // Pega o campo "id" do JWT
    }
}
