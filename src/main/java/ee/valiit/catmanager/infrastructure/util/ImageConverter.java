package ee.valiit.catmanager.infrastructure.util;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class ImageConverter {

    public byte[] stringToByte(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        if (value.contains(",")) {
            value = value.split(",")[1];
        }
        try {
            return Base64.getDecoder().decode(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public String byteToString(byte[] value) {
        if (value == null || value.length == 0) {
            return null;
        }
        return Base64.getEncoder().encodeToString(value);
    }
}