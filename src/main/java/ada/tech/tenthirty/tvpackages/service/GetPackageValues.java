package ada.tech.tenthirty.tvpackages.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ada.tech.tenthirty.tvpackages.entity.PackageChannel;
import ada.tech.tenthirty.tvpackages.payloads.InvoiceRequest;
import ada.tech.tenthirty.tvpackages.payloads.PackageRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.InvoiceResponse;
import ada.tech.tenthirty.tvpackages.repository.PackageChannelRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetPackageValues {
  private final PackageChannelRepository packageRepository;

  public InvoiceResponse execute(InvoiceRequest invoiceRequest){
    List<PackageRequest> listPackages = invoiceRequest.getListPackages();

    InvoiceResponse responses = new InvoiceResponse(new ArrayList<>());

    for (PackageRequest packageRequest : listPackages) {
      PackageChannel response = packageRepository.findById(packageRequest.getSkuId()).get();
      responses.getListPackages().add(response);
    }
    return responses;
  }
}
