package ada.tech.tenthirty.tvpackages.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ada.tech.tenthirty.tvpackages.entity.Package;
import ada.tech.tenthirty.tvpackages.payloads.response.PackageResponse;
import ada.tech.tenthirty.tvpackages.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ada.tech.tenthirty.tvpackages.payloads.InvoiceRequest;
import ada.tech.tenthirty.tvpackages.payloads.PackageRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.InvoiceResponse;

@Service
@RequiredArgsConstructor
public class GetPackageValues {
  private final PackageRepository packageRepository;
  private  final  GetPromotions getPromotions;

  public InvoiceResponse  execute(List<PackageRequest>  invoiceRequest){

    InvoiceResponse responses = new InvoiceResponse(new ArrayList<>());

    for (PackageRequest packageRequest : invoiceRequest) {
      Package response = packageRepository.findById(packageRequest.getPackageId()).get();

      Integer valuePromotion = getPromotions.getPromotionPackage(packageRequest.getPackageId());
      BigDecimal discountAmount = calculateValueWithPromotion(valuePromotion, response.getValue());

      PackageResponse packageResponse  = new PackageResponse();
      packageResponse.setValue(discountAmount);
      packageResponse.setTransitionId(packageRequest.getPackageId());
      packageResponse.setValuePromotions(discountAmount);

      responses.getListPackages().add(packageResponse);
    }
    return responses;
  }

  public BigDecimal calculateValueWithPromotion(Integer valuePromotion, BigDecimal valuePackage){
    BigDecimal percentage = BigDecimal.valueOf(valuePromotion).divide(BigDecimal.valueOf(100));
    BigDecimal discountAmount = valuePackage.multiply(percentage);
    return valuePackage.subtract(discountAmount);
  }
}
