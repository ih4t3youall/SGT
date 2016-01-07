package ar.com.sgt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ar.com.sgt")
public class SpringConfiguration extends WebMvcConfigurerAdapter {
	//definicion del servlet de spring, aca va toda la configuracion especifica del servlet
	@Bean(name="HelloWorld")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/jsp/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	/*
     * Configuracion ResourceHandlers para direcciones estaticas como los jsp o los js 
     * se accede desde el jsp con la siguiente linea <link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
     *  notese el <c:url ...
     *  se cambia el /** por la carpeta que queiras ejemplo /resources/**
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
    }
}