package ada.tech.tenthirty.tvpackages.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ada.tech.tenthirty.tvpackages.payloads.InvoiceRequest;
import ada.tech.tenthirty.tvpackages.payloads.PackageRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.InvoiceResponse;
import ada.tech.tenthirty.tvpackages.payloads.response.PackageResponse;
import ada.tech.tenthirty.tvpackages.repository.PackageRepository;

@Service
public class GetPackageValues {
  @Autowired
  PackageRepository packageRepository;

  public InvoiceResponse execute(InvoiceRequest invoiceRequest){
    List<PackageRequest> listPackages = invoiceRequest.getListPackages();

    InvoiceResponse responses = new InvoiceResponse(new ArrayList<>());

    for (PackageRequest packageRequest : listPackages) {
      Optional<PackageResponse> response = packageRepository.findById(packageRequest.getSkuId());
      if (response.isPresent()) {
        responses.getListPackages().add(response.get());
      }
    }
    return responses;
  }
}