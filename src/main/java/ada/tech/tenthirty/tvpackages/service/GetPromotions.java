package ada.tech.tenthirty.tvpackages.service;

import ada.tech.tenthirty.tvpackages.entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetPromotions {
  private final HttpPromotions httpCustom;

  @Autowired
  public GetPromotions(HttpPromotions httpCustom) {
    this.httpCustom = httpCustom;
  }

  public Integer getPromotionPackage(String idPackage) {
    Promotion promotionResponse = httpCustom.getPromotions(idPackage);

    if (promotionResponse != null) {
      return promotionResponse.getValuePromotions();
    }
    return null;
  }
}
