package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.Promotion;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPromotions {
  private final WebClientService httpCustom;

  public Integer getPromotionPackage(String idPackage) {
    Promotion promotionResponse = httpCustom.getPromotions(idPackage);

    if (promotionResponse != null) {
      return promotionResponse.getValuePromotions();
    }
    return null;
  }
}
