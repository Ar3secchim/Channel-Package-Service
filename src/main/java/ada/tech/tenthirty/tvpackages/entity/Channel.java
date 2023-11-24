package ada.tech.tenthirty.tvpackages.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

  @Column(name="channel_id")
  private String channelId;

  @ManyToOne
  @JoinColumn(name = "package_id")
  private Package Package;

  @Column(name="identifier")
  private Integer identifier;

  @Column(name="name")
  private String name;

  @Enumerated(EnumType.STRING)
  private Category category;
}
