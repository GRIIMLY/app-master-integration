/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.holding.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Nicolas Sierra
 */
@Configuration
public class GeneralConfig {
	
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
    
}
