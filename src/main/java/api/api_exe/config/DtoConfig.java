package api.api_exe.config;

import api.api_exe.dto.ResponseDto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DtoConfig {
    
    @Bean
    public ResponseDto responseDto(){
        return new ResponseDto();
    }
}
