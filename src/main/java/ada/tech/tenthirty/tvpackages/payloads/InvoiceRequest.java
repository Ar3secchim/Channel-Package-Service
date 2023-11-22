package ada.tech.tenthirty.tvpackages.payloads;

import java.util.List;

import lombok.Data;

@Data
public class InvoiceRequest {
  List<PackageRequest> listPackages;
}
