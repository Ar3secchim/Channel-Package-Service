package ada.tech.tenthirty.tvpackages.rest;

import ada.tech.tenthirty.tvpackages.payloads.HelloResponse;
import ada.tech.tenthirty.tvpackages.payloads.InvoiceRequest;
import ada.tech.tenthirty.tvpackages.payloads.response.InvoiceResponse;
import ada.tech.tenthirty.tvpackages.service.GetPackageValues;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Operation(summary = "Get value from package")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "package is available"),
            @ApiResponse(responseCode = "404", description = "package not found"),
    })
    @GetMapping(value = "/package/value")
    public InvoiceResponse getPackageValues(@RequestBody InvoiceRequest invoiceRequest){
        return getPackageValues.execute(invoiceRequest);
    }
}
