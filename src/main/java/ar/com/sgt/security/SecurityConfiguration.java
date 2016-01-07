package ar.com.sgt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
//	el quelifier se utiliza para hacer un autowired de un bean especifico, en este caso se esta inyectando un customUserDetailService que implementa
//	userDetailService en la variable userDetailService , si no estuviera el qualifier inyectaria una instancia de UserDetailService en lugar de la custom
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	private CustomSuccessHandler customSuccessHandler;
//	comment  el user detail service se utiliza para dar o no acceso a un usuario al sistema.
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	
	
//	comment los permisos de ingreso por role en la linea 44 se le agrega un customSuccessHandler que es para redireccionar
//	a cada usuario dependiendo su rol a la pagina que corresponda
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests()
	  	.antMatchers("/", "/home").permitAll()
	  	.antMatchers("/admin/**").access("hasRole('ADMIN')")
	  	.antMatchers("/operario/**").access("hasRole('OPERARIO')")
	  	.antMatchers("reportes/*").access("hasRole('USUARIO')")
	  	.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
	  	.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
	  	.usernameParameter("ssoId").passwordParameter("password")
	  	.and().csrf()
	  	.and().exceptionHandling().accessDeniedPage("/Access_Denied");
	}
}
