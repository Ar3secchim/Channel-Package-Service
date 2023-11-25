package ada.tech.tenthirty.tvpackages.rest;

import ada.tech.tenthirty.tvpackages.entity.Package;
import ada.tech.tenthirty.tvpackages.payloads.PackageRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.InvoiceResponse;
import ada.tech.tenthirty.tvpackages.service.GetAllPackages;
import ada.tech.tenthirty.tvpackages.service.GetPackageValues;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/")
@RequiredArgsConstructor
public class PackageController {
    private final GetPackageValues getPackageValues;
    private final GetAllPackages getAllPackages;

    @PostMapping (value = "/value")
    public InvoiceResponse getPackageValues(@RequestBody List<PackageRequest> packages) {
        return getPackageValues.execute(packages);
    }

    @GetMapping (value = "/list")
    public List<Package> getAllPackage() {
        return getAllPackages.execute();
    }
}
