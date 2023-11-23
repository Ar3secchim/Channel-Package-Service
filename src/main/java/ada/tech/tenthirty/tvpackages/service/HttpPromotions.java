package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.Promotion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HttpPromotions {
  private final RestTemplate restTemplate;

  public HttpPromotions() {
    this.restTemplate = new RestTemplate();
  }

  public Promotion getPromotions(String idPackage) {

    String URL = "localhost:servicePromotions/promotions" + idPackage;

    try {
      ResponseEntity<Promotion> response = restTemplate.getForEntity(URL, Promotion.class);

      if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
        response.getBody();
      }
    } catch (ResponseStatusException ex) {
      throw new ResponseStatusException(ex.getStatusCode(), ex.getMessage());
    }
    return null;
  }
}
