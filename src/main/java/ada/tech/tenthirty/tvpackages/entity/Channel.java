package ada.tech.tenthirty.tvpackages.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "channels")
public class Channel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(name="sku_id")
  private String skuId;

  @Column(name="identifier")
  private Integer identifier;

  @Column(name="name")
  private String name;

  @Enumerated
  private Category category;
}
