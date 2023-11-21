package com.testsp;

public class MessageDecoderFactory {
    public MessageDecoder getMessageDecoder(String house) {
        if ("atreides".equalsIgnoreCase(house)) {
            return new AtreidesMessageDecoder();
        } else if ("harkonnen".equalsIgnoreCase(house)) {
            return new HarkonnenMessageDecoder();
        }
        return null;
    }
}