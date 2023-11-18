package ada.tech.tenthirty.tvpackages.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI defaultOpenApiConfig(){
        return new OpenAPI()
                .info(new Info().title("TV Packages- Service package")
                        .description("Service Packages")
                        .version("0.0.1"));
    }
}
