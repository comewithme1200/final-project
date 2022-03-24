package com.example.finalproject.core.user;

public interface EncryptSerivce {
    String encryptPassword(String plainPassword);

    boolean checkPassword(String checkPassword, String encryptedPassword);
}
