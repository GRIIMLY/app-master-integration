package co.premier.security.audit;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String>{

	private static final Logger logger = LoggerFactory.getLogger(AuditorAwareImpl.class);

	
	@Override
	public Optional<String> getCurrentAuditor() {
		String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.debug("Usuario loggeado: ".concat(usuario));
		return Optional.of(usuario);
	}
	

}
