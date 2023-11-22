package ada.tech.tenthirty.tvpackages.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ada.tech.tenthirty.tvpackages.payloads.response.PackageResponse;

@Repository
public interface PackageRepository extends JpaRepository<PackageResponse,String>{
}