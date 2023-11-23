package ada.tech.tenthirty.tvpackages.repository;

import ada.tech.tenthirty.tvpackages.entity.PackageChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PackageRepository extends JpaRepository<PackageChannel,String>{
}
