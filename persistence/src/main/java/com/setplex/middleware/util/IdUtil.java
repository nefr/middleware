package com.setplex.middleware.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ruslan Yatsevich
 */
public class IdUtil {

    public static int nextId() {
        // TODO: generate id in case of no autoincrement in database
        return ThreadLocalRandom.current().nextInt();
    }

    private IdUtil() {}
}
