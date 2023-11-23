package ada.tech.tenthirty.tvpackages.service;

import java.util.ArrayList;
import java.util.List;

import ada.tech.tenthirty.tvpackages.payloads.response.PackageResponse;
import ada.tech.tenthirty.tvpackages.repository.PackageRepository;
import org.springframework.stereotype.Service;

import ada.tech.tenthirty.tvpackages.payloads.InvoiceRequest;
import ada.tech.tenthirty.tvpackages.payloads.PackageRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.InvoiceResponse;

@Service
public class GetPackageValues {
  private final PackageRepository packageRepository;

  public GetPackageValues(PackageRepository packageRepository) {
    this.packageRepository = packageRepository;
  }

  public InvoiceResponse execute(InvoiceRequest invoiceRequest){
    List<PackageRequest> listPackages = invoiceRequest.getListPackages();

    InvoiceResponse responses = new InvoiceResponse(new ArrayList<>());

    for (PackageRequest packageRequest : listPackages) {
      PackageResponse response = packageRepository.findById(packageRequest.getSkuId()).get();
      responses.getListPackages().add(response);
    }
    return responses;
  }
}
