package com.setplex.middleware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author Ruslan Yatsevich
 */

@Configuration
public abstract class AbstractTestDS {

    protected static EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("db/schema.sql").addScript("db/data.sql");
    protected static EmbeddedDatabase db;

    @Bean
    public DataSource dataSource() {
        return db;
    }
}
