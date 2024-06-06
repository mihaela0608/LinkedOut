package bg.softuni.linkedout.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class Config {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {

                if(mappingContext.getSource() != null) {
                    LocalDate parse = LocalDate
                            .parse(mappingContext.getSource(),
                                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    return parse;
                }
                return null;
            }
        });
        return modelMapper;
    }
}
