package ro.raluca.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"ro.raluca.repository"})
public class JpaConfiguration {

}
