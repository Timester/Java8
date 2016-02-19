package net.talqum.learning.util;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public static User fromCrendentials(Credential c) {
        return new User(c.getUsername());
    }
}
