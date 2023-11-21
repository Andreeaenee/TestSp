package com.testsp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageReader messageReader;
    private final MessageDecoderFactory messageDecoderFactory;

    public MessageController() {
        this.messageReader = new MessageReader();
        this.messageDecoderFactory = new MessageDecoderFactory();
    }

    @GetMapping("/decode")
    public List<String> getDecodedMessages() {
        List<String> decodedMessages = null;
        try {
            List<Message> messages = messageReader.readMessagesFromFile("src/messages.json");
            decodedMessages = decodeAllMessages(messages);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return decodedMessages;
    }

    private List<String> decodeAllMessages(List<Message> messages) {
        List<String> decodedMessages = new ArrayList<>();
        for (Message message : messages) {
            MessageDecoder decoder = messageDecoderFactory.getMessageDecoder(message.getHouse());
            String decodedMessage = decoder.decode(message.getMessage());
            decodedMessages.add(decodedMessage);
        }
        return decodedMessages;
    }
}
