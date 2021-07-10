package com.riskiq.repository;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Base class to implement CRUD operation of data files
 *
 * @author riskiq
 * @created 1/17/18
 */
public abstract class CrudRepository <T, R> {

    private final R path;

    public CrudRepository(R path) {
        this.path = path;
    }

    public long size() throws IOException {
        return 0;
    }

    public R getPath() {
        return path;
    }
}