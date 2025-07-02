package org.example;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthManagerTest {

    private AuthManager authManager;
    private UserRepository userRepository;
    private HashLib hashLib;

    private User validUser;

    @Before
    public void setUp() {
        userRepository = mock(UserRepository.class);
        hashLib = mock(HashLib.class);
        authManager = new AuthManager(userRepository, hashLib);

        validUser = new User("test@example.com", "hashedPassword123");
        when(userRepository.findByEmail("test@example.com")).thenReturn(validUser);
        when(hashLib.hashFunc("password123")).thenReturn("hashedPassword123");
        when(hashLib.hashFunc("wrongPassword")).thenReturn("wrongHashedPassword");
        when(userRepository.findByEmail("notfound@example.com")).thenReturn(null);
        when(userRepository.findByEmail("error@example.com")).thenThrow(new RuntimeException("Error")); // this an demo exception
    }

    @Test
    public void testLogin_Success() {
        boolean result = authManager.login("test@example.com", "password123");
        assertTrue(result);
    }

    @Test
    public void testLogin_Failure_WrongPassword() {
        boolean result = authManager.login("test@example.com", "wrongPassword");
        assertFalse(result);
    }

    @Test
    public void testLogin_Failure_UserNotFound() {
        boolean result = authManager.login("notfound@example.com", "password123");
        assertFalse(result);
    }

    @Test(expected = RuntimeException.class)
    public void testLogin_ExceptionHandling() {
        authManager.login("error@example.com", "password123");
    }
}
