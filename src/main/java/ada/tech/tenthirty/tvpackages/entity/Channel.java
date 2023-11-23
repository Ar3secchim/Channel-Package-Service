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
@Entity
@Table(name = "channels")
public class Channel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;

  @Column(name="channel_id")
  private String channelId;

  @ManyToOne
  @JoinColumn(name = "package_id")
  private Package Package;

  @Column(name="identifier")

  @Column(name="transaction_id")
  private String transactionId;

  @ManyToOne
  @JoinColumn(name = "package_id")
  private PackageChannel PackageChannel;

  private Integer identifier;
  private String name;

  @Enumerated(EnumType.STRING)
  private Category category;
}
