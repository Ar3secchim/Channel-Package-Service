package ada.tech.tenthirty.tvpackages.service;

import java.util.ArrayList;
import java.util.List;

import ada.tech.tenthirty.tvpackages.entity.Package;
import ada.tech.tenthirty.tvpackages.payloads.response.PackageResponse;
import ada.tech.tenthirty.tvpackages.repository.PackageRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

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

      PackageResponse packageResponse  = new PackageResponse();
      packageResponse.setPackageValue(response.getValue());
      packageResponse.setPackageId(packageRequest.getPackageId());
      packageResponse.setValueDeal(valuePromotion);

      responses.getListPackages().add(packageResponse);
    }
    return responses;
  }
}
