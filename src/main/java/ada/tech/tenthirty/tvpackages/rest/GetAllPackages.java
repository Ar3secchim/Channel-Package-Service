package ada.tech.tenthirty.tvpackages.rest;

import ada.tech.tenthirty.tvpackages.entity.Package;
import ada.tech.tenthirty.tvpackages.repository.PackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllPackages {
  private final PackageRepository packageRepository;

  public List<Package> execute(){
    return packageRepository.findAll();
  }
}
