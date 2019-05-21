package co.premier.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import co.premier.repository.entity.ServicioEntity;
import co.premier.utiles.dto.ServicioDTO;

@Configuration
public class MapperConfig {

	@Bean(name = "genericMapper")
	@Primary
	public ModelMapper getModelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration()
		.setSkipNullEnabled(true);
		return mapper;
	}
	
	@Bean(name = "servicioAppMapper")
	public ModelMapper getModelMapperServicio() {
		ModelMapper mapper = new ModelMapper();
		PropertyMap<ServicioEntity, ServicioDTO> map = new PropertyMap<ServicioEntity, ServicioDTO>() {
			@Override
			protected void configure() {				
				map().setIdAplicacion(source.getAplicacion().getId());
			}
		};
		mapper.addMappings(map);
		return mapper;
	}
	
}
