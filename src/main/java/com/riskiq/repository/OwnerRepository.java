package com.riskiq.repository;

import com.riskiq.domain.ServiceOwner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class OwnerRepository extends CrudRepository<ServiceOwner, URL>{


    public OwnerRepository(URL path) {
        super(path);
    }


    public List<ServiceOwner> owners() throws IOException {

        try {
            Stream<String> lines = Files.lines(Paths.get(getPath().toURI()));
            List<ServiceOwner> result = lines.map(s -> {
                String[] parts = s.split(", ");
                ServiceOwner owner = new ServiceOwner();

                owner.setServiceName(parts[0]);
                owner.setOwner(parts[1]);

                return owner;
            }).collect(Collectors.toList());
            return result;
        }
        catch (URISyntaxException ex) {
            System.out.println(ex);
            return new ArrayList<>();
        }
    }
}
