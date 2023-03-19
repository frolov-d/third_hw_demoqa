package com.jsd.filemanagement;

import java.util.List;
import java.util.Map;

public class Person {

    private String name;
    private int age;
    private Map<String, Object> books;
    private List<String> music;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Object> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Object> books) {
        this.books = books;
    }

    public List<String> getMusic() {
        return music;
    }

    public void setMusic(List<String> music) {
        this.music = music;
    }
}
