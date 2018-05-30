package ar.com.sourcesistemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class HvqApplication {

	public static void main(String[] args) {
		SpringApplication.run(HvqApplication.class, args);
	}

	@Configuration
	public static class PathMatchingConfigurationAdapter extends WebMvcConfigurerAdapter {
	 
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	configurer.favorPathExtension(false);
	}
	}
}
