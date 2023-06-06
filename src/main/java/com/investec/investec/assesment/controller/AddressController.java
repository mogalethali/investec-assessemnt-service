package com.investec.investec.assesment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.investec.investec.assesment.exception.*;
import com.investec.investec.assesment.model.Address;
import com.investec.investec.assesment.service.AddressService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiOperation(value = "Investect AddressController Controller", tags = "Investect AddressController Controller" )
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/prettyPrintAddress")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pretty Print Address Controller",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "412", description = "Precondition failed")
    })
    @Operation(summary = "pretty Print Address")
    public String prettyPrintAddress(@RequestBody Address request) throws JsonProcessingException {
        return  addressService.prettyPrintAddress(request);
    }


    @PostMapping("/prettyPrintAddressList")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pretty Print Address List Controller",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "412", description = "Precondition failed")
    })
    @Operation(summary = "pretty Print Address List")
    public String prettyPrintAddressList(@RequestBody List<Address> request) throws JsonProcessingException {
        return  addressService.prettyPrintAddressList(request);
    }

    @PostMapping("/validate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Validate Address Controller",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "412", description = "Precondition failed")
    })
    @Operation(summary = "Validate Address ")
    public void validateAddress(@RequestBody Address request) throws  ProvinceNotFoundException, AddressException, CountryNotFoundException, AddressLineDetailsNotFoundException, PostalCodeNotFoundException {
          addressService.validateAddress(request);
    }


    @PostMapping("/addressType")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "prettyPrintAddressByType  Controller",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "412", description = "Precondition failed")
    })
    @Operation(summary = "prettyPrintAddressByType Address ")
    public void prettyPrintAddressByType(@RequestBody Address request) throws ProvinceNotFoundException, AddressException, CountryNotFoundException, AddressLineDetailsNotFoundException, PostalCodeNotFoundException, JsonProcessingException {
        addressService.prettyPrintAddressByType(request);
    }
}

