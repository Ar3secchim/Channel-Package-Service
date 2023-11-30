package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.Promotion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

@Configuration
@Service
public class PromotionsService {
  private String URL; 

  @Bean
  WebClient webClient(){
      return WebClient.builder().baseUrl(URL)
              .build();
  }

  public Promotion getPromotions(String idPackage) {
    URL = "http://localhost:3000/promotions" + idPackage;

    try {
      WebClient webClient = webClient();
    
      Promotion promotion = webClient.get()
              .uri(uriBuilder -> uriBuilder.path("/{idPackage}").build(idPackage))
              .retrieve()
              .onStatus(
                      status -> !status.is2xxSuccessful(),
                      response -> {
                          throw new ResponseStatusException(response.statusCode(), "Error retrieving promotions");
                      }
              )
              .bodyToMono(Promotion.class)
              .block();

      if (promotion != null) {
          return promotion;
      } else {
          System.out.println("Error: Promotion is null");
      }
    } catch (ResponseStatusException ex) {
      throw new ResponseStatusException(ex.getStatusCode(), ex.getMessage());
    }
    return null;
  }
}
