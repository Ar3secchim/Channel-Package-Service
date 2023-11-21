package ada.tech.tenthirty.tvpackages.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Channel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  private String skuId;
  private Integer identifier;
  private String name;
  private Category category;
}
