package com.corporate.apiidentitydocumentformatter.utils;

import com.corporate.apiidentitydocumentformatter.constants.DocumentTemplateConstants;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public final class DocumentFormatterUtils {

    public static String cpf(String s) {
        final String[] splited = s.split("");
        final String TEMPLATE = DocumentTemplateConstants.CPF;

        String firstThreeDigits = stream(splited, 0, 3);

        String secondThreeDigits = stream(splited, 3, 3);

        String thirdThreeDigits = stream(splited, 6, 3);

        String lastTwoDigits = stream(splited, 9, 2);

        return String.format(TEMPLATE, firstThreeDigits, secondThreeDigits, thirdThreeDigits, lastTwoDigits);
    }

    public static String rg(String s){
        final String[] splited = s.split("");
        final String TEMPLATE = DocumentTemplateConstants.RG;

        String firstTwoDigits = stream(splited, 0, 2);

        String secondThreeDigits = stream(splited, 2, 3);

        String thirdThreeDigits = stream(splited, 5, 3);

        String lastDigit = stream(splited, 8, 1);

        return String.format(TEMPLATE, firstTwoDigits, secondThreeDigits, thirdThreeDigits, lastDigit);
    }

    private static String stream(String[] splited, int skip, int limit) {
        return Arrays.stream(splited)
                .skip(skip)
                .limit(limit)
                .collect(Collectors.joining());
    }
}
