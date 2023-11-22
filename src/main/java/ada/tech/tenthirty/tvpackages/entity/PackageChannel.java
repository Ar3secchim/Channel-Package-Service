package ada.tech.tenthirty.tvpackages.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageChannel{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String skuId;
  private String name; 
  private List<Channel> listChannels;  
  private BigDecimal value;
}
