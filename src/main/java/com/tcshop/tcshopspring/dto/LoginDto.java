package com.tcshop.tcshopspring.dto;

public class LoginDto {
    private String identifier;
    private String password;

    public LoginDto() {
    }

    public LoginDto(String identifier, String password) {
        this.identifier = identifier;
        this.password = password;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}