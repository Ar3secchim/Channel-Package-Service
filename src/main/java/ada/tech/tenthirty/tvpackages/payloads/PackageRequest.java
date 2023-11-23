package ada.tech.tenthirty.tvpackages.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PackageRequest {
  private String packageId;
}
