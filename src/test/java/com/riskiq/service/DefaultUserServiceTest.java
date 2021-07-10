package com.riskiq.service;

import com.google.common.io.Resources;
import com.riskiq.cache.MetricsCache;
import com.riskiq.repository.OwnerRepository;
import com.riskiq.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@Component
public class DefaultUserServiceTest {

    private static final Logger log = LoggerFactory.getLogger(DefaultUserService.class.getSimpleName());

    private DefaultUserService defaultUserService;

    @Before
    public void setupClass() {
        UserRepository userRepository = new UserRepository(Resources.getResource("userData.txt"));
        OwnerRepository ownerRepository = new OwnerRepository(Resources.getResource("userData.txt"));

        defaultUserService = new DefaultUserService();
        defaultUserService.setUserRepository(userRepository, ownerRepository);
    }

    @Test
    public void test_getLines() throws IOException, InterruptedException {

//        TimeUnit.SECONDS.sleep(60);

        defaultUserService.init();

        defaultUserService.recordLines();

        long lines = MetricsCache.getInstance().getLines();

        assertEquals(lines, 2);


    }


    @Test
    public void test_getOwner() throws IOException, InterruptedException {

        defaultUserService.init();

        defaultUserService.recordOwner();

        String owner = MetricsCache.getInstance().getOwner("A");

        Assert.assertTrue(owner.equals("A1"));
    }




}
