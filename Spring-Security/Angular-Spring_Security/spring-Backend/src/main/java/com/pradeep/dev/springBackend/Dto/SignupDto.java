package com.pradeep.dev.springBackend.Dto;

public record SignupDto(String firstName,
                        String lastName,
                        String login,
                        char[] password) {
}
