package ada.tech.tenthirty.tvpackages.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ada.tech.tenthirty.tvpackages.entity.PackageChannel;
import ada.tech.tenthirty.tvpackages.payloads.InvoiceRequest;
import ada.tech.tenthirty.tvpackages.payloads.PackageRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.InvoiceResponse;
import ada.tech.tenthirty.tvpackages.repository.PackageChannelRepository;

@Service
public class GetPackageValues {
  @Autowired
  PackageChannelRepository packageRepository;

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
