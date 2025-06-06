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


    public static String pegarNomeSobrenome(String nome) {
        String[] partes = nome.split(" ");
        if (partes.length >= 2) {
            return partes[0] + " " + partes[1];
        } else {
            return nome;
        }



    }

    public static List<String> dividirStringReturnListVirgula(String input) {
        if (input == null || input.isEmpty()) {
            return List.of();
        }
        input = input.replaceAll("\n", "").trim();
        return Arrays.asList(input.split(","));
    }
}
