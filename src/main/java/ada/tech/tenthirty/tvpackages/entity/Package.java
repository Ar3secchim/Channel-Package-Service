package ada.tech.tenthirty.tvpackages.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

  @Column(name="package_id")
  private String packageId;

  @Column(name="value")
  private BigDecimal value;

  @Column(name="list_channel")
  @OneToMany(mappedBy = "Package")
  private List<Channel> listChannel;
}
