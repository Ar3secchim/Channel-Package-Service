package ada.tech.tenthirty.tvpackages.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ada.tech.tenthirty.tvpackages.payloads.InvoiceRequest;
import ada.tech.tenthirty.tvpackages.payloads.PackageRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.InvoiceResponse;

@Service
public class GetPackageValues {
  @Autowired
  PackageRepository packageRepository;

  public InvoiceResponse  execute(List<PackageRequest>  invoiceRequest){

    InvoiceResponse responses = new InvoiceResponse(new ArrayList<>());

    for (PackageRequest packageRequest : invoiceRequest) {
      PackageChannel response = packageRepository.findById(packageRequest.getPackageId()).get();

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
}
