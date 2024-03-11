package com.todo.utils.commons;

import java.util.Base64;

public class HelperUtils {
    private HelperUtils() {
    }

    public static boolean isBlankOrNull(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public static boolean notBlankOrNull(String str) {
        return !isBlankOrNull(str);
    }

    public static String encodeToBase64(String data) {
        try {
            return Base64.getEncoder().encodeToString(data.getBytes());
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static String decodeBase64(String encodedData) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedData);
            return new String(decodedBytes);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
