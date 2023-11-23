package ada.tech.tenthirty.tvpackages.rest;

import ada.tech.tenthirty.tvpackages.payloads.HelloResponse;
import ada.tech.tenthirty.tvpackages.payloads.PackageRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.InvoiceResponse;
import ada.tech.tenthirty.tvpackages.service.GetPackageValues;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/")
@RequiredArgsConstructor
public class PackageController {
    private final GetPackageValues getPackageValues;

    @Operation(summary = "Get all packages")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "greeting accepted")
    })
    @GetMapping(value = "/")
    public HelloResponse sayHello(String name){
        return new HelloResponse("Hellou Word");
    }

    @PostMapping (value = "/value")
    public InvoiceResponse getPackageValues(@RequestBody List<PackageRequest> packages) {
        return getPackageValues.execute(packages);
    }
}
