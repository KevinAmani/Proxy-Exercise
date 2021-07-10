package com.riskiq.repository;

import com.google.common.io.Resources;
import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

/**
 * @author riskiq
 * @created 1/17/18
 */
public class UserRepositoryTest {

    @Test
    public void testGetSize() throws Exception {

        UserRepository userRepository = new UserRepository(Resources.getResource("testGetSize.txt"));
        long size = userRepository.size();
        assertEquals(size, 12);
    }
}