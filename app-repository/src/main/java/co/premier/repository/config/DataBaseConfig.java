package co.premier.repository.config;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", basePackages = { "co.premier.repository.entity" })
@PropertySources({ @PropertySource("classpath:db-properties.properties") })
public class DataBaseConfig {
	
	@Value("${jdbc.url}")
	private String nameDataSource;

	@Primary
	@Bean(name = "dataSource")
	//@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() throws NamingException{
		return (DataSource) new JndiTemplate().lookup(nameDataSource);
//		try {
//			Context initialContex = new InitialContext();
//		    System.out.println("value of datasource"+nameDataSource);
//			//return DataSourceBuilder.create().build();
//		    return (DataSource)(initialContex.lookup(nameDataSource));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {

		return builder.dataSource(dataSource).packages("co.premier.repository.entity").persistenceUnit("MS_DB").build();
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);

	}
}
