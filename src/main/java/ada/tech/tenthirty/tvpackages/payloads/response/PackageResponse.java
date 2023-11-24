package ada.tech.tenthirty.tvpackages.payloads.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PackageResponse{
  private String packageId;
  private BigDecimal packageValue;
  private Integer valueDeal;
}
