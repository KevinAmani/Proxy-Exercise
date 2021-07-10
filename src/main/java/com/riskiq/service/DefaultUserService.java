package com.riskiq.service;

import com.riskiq.cache.MetricsCache;
import com.riskiq.domain.ServiceOwner;
import com.riskiq.repository.OwnerRepository;
import com.riskiq.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * Simple service to demonstrate usage of UserRepository
 *
 * @author riskiq
 * @created 1/17/18
 */
@Service
public class DefaultUserService {

    private static final Logger log = LoggerFactory.getLogger(DefaultUserService.class.getSimpleName());

    private UserRepository userRepository;

    private OwnerRepository ownerRepository;

    private MetricsCache cache = MetricsCache.getInstance();

    @Autowired
    public void setUserRepository(UserRepository userRepository, OwnerRepository ownerRepository) {

        this.userRepository = userRepository;
        this.ownerRepository = ownerRepository;

    }

    @PostConstruct
    void init() {
        try {
            log.info("User file path = {}", userRepository.getPath());
            log.info("User file size = {}", userRepository.size());
        }
        catch (IOException ex) {
            log.error("Error getting file size {}", ex);
        }
    }

    public void recordLines () throws IOException {

        Long lines = userRepository.size();

        cache.setLines(lines);
    }

    public void recordOwner() throws IOException {

        List<ServiceOwner> lines = ownerRepository.owners();

        for (ServiceOwner owner : lines) {
            cache.setOwner(owner.getServiceName(), owner.getOwner());
        }


    }


}