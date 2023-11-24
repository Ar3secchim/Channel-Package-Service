package ada.tech.tenthirty.tvpackages.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="packages")
public class Package {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(name="sku_id")
  private String skuId;

  @Column(name="name")
  private String name;

  @Column(name="value")
  private BigDecimal value;

  @OneToMany
  @JoinColumn(name="list_channels")
  private List<Channel> listChannels;
}
