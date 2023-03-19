package com.jsd.filemanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonParsingTest {

    private ClassLoader cl = JsonParsingTest.class.getClassLoader();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testJsonParsing() throws IOException {
        try (InputStream inputStream = cl.getResourceAsStream("testdata/test.json")) {
            Person person = objectMapper.readValue(inputStream, Person.class);

            assertEquals("Dmitry", person.getName());
            assertEquals(32, person.getAge());

            Map<String, Object> books = person.getBooks();
            assertEquals(2, books.size());

            List<String> liuCixinBooks = Arrays.asList("The Dark Forest", "Death's End ");
            assertEquals(liuCixinBooks, books.get("Liu Cixin"));

            assertEquals("Marabou Stork Nightmares ", books.get("Irvine Welsh"));

            List<String> music = person.getMusic();
            assertEquals(2, music.size());
            assertEquals("Iron Maiden", music.get(0));
            assertEquals("Tool", music.get(1));
        }
    }
}
