package ada.tech.tenthirty.tvpackages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ada.tech.tenthirty.tvpackages.entity.PackageChannel;

@Service
public interface PackageChannelRepository extends JpaRepository<PackageChannel, String>{
}
