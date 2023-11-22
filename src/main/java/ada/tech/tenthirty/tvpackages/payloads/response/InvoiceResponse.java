package ada.tech.tenthirty.tvpackages.payloads.response;

import java.util.List;

import ada.tech.tenthirty.tvpackages.entity.PackageChannel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvoiceResponse {
  List<PackageChannel> listPackages;
}
