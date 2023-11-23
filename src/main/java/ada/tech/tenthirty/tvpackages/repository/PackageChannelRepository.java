package ada.tech.tenthirty.tvpackages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ada.tech.tenthirty.tvpackages.entity.PackageChannel;

@Repository
public interface PackageChannelRepository extends JpaRepository<PackageChannel, String>{
}
