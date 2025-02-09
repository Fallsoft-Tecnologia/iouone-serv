package br.com.iouone.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

    public static List<String> dividirStringReturnList(String input) {
        if (input == null || input.isEmpty()) {
            return List.of();
        }
        input = input.replaceAll("\n", "").trim();
        return Arrays.asList(input.split(";"));
    }
}
