package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.Promotion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WebClientService {
  private final RestTemplate restTemplate;

  public WebClientService() {
    this.restTemplate = new RestTemplate();
  }

  public Promotion getPromotions(String idPackage) {

    String URL = UriComponentsBuilder.fromHttpUrl("http://localhost:3000")
            .path("promotions/" + idPackage)
            .toUriString();

    try {
      ResponseEntity<Promotion> response = restTemplate.getForEntity(URL, Promotion.class);

      if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
        return response.getBody();
      }else {
        System.out.println("error");
      }
    } catch (ResponseStatusException ex) {
      throw new ResponseStatusException(ex.getStatusCode(), ex.getMessage());
    }
    return null;
  }
}
