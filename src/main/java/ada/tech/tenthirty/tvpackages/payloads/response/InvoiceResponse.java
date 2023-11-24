package ada.tech.tenthirty.tvpackages.payloads.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvoiceResponse {
  List<PackageResponse> listPackages;
}
