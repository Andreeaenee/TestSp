package com.testsp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MessageReader {
    public List<Message> readMessagesFromFile(String filePath) throws IOException {
        return new ObjectMapper().readValue(new File(filePath), new TypeReference<List<Message>>() {});
    }
}
