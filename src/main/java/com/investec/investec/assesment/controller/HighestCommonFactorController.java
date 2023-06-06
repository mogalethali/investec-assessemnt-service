package com.investec.investec.assesment.controller;

import com.investec.investec.assesment.service.HighestCommonFactor;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiOperation(value = "Investect Controller", tags = "Investect Controller" )
@RequestMapping("/api/v1/highest")
public class HighestCommonFactorController {
    @Autowired
    HighestCommonFactor highestCommonFactor;

    @PostMapping("/number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find Highest Common Factor Controller",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "412", description = "Precondition failed")
    })
    @Operation(summary = "Highest Common Factor")
    public int findHighestCommonFactorController(int[] numbers) {
        return  highestCommonFactor.highestCommonFactor(numbers);
    }
}
