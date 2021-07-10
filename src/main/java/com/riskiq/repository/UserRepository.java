package com.riskiq.repository;

import com.riskiq.domain.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * CRUD operations implementation specifically for {@link com.riskiq.domain.User}
 *
 * @author riskiq
 * @created 1/17/18
 */
@Component
public class UserRepository extends CrudRepository<User, URL> {

    public UserRepository(URL path) {
        super(path);
    }

    @Override
    public long size() throws IOException {

        try {
            Stream<String> lines = Files.lines(Paths.get(getPath().toURI()));
            return lines.count();
        }
        catch (URISyntaxException ex) {
            System.out.println(ex);
            return 0;
        }
    }
}