package com.testsp;

//strategy de la harkonen
public class HarkonnenMessageDecoder implements MessageDecoder {

    private static final int SHIFT = 2;

    @Override
    public String decode(String message) {
        StringBuilder decodedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            char decodedChar;

            if (currentChar >= 32 && currentChar <= 126) {
                decodedChar = (char) (((currentChar - 32 - SHIFT + 95) % 95) + 32);
            } else {
                decodedChar = currentChar;
            }

            decodedMessage.append(decodedChar);
        }

        return decodedMessage.toString();
    }
}