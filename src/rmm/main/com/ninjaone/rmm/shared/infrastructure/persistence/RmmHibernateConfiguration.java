package com.ninjaone.rmm.shared.infrastructure.persistence;

import com.ninjaone.shared.infrastructure.config.Parameter;
import com.ninjaone.shared.infrastructure.config.ParameterNotExist;
import com.ninjaone.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class RmmHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter config;

    public RmmHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("rmm-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("rmm-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        String CONTEXT_NAME = "rmm";
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("rmm-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("RMM_DATABASE_HOST"),
            config.getInt("RMM_DATABASE_PORT"),
            config.get("RMM_DATABASE_NAME"),
            config.get("RMM_DATABASE_USER"),
            config.get("RMM_DATABASE_PASSWORD")
        );
    }
}
