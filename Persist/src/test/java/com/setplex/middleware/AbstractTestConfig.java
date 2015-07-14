package com.setplex.middleware;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ruslan Yatsevich
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(classes = AbstractTestDS.class),
        @ContextConfiguration(locations = "classpath:spring-persistence.xml")
})
public abstract class AbstractTestConfig extends AbstractTestDS {

    @BeforeClass
    public static void setUp() {
        db = builder.build();
    }

    @AfterClass
    public static void tearDown() {
        db.shutdown();
    }
}
