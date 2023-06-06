package com.investec.investec.assesment.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.investec.investec.assesment.exception.*;
import com.investec.investec.assesment.model.Address;
import com.investec.investec.assesment.model.AddressType;
import com.investec.investec.assesment.model.CountryCode;
import jakarta.annotation.PostConstruct;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class AddressService {
    private static  final String NUMBERIC_REGIX="[0-9]+";
    private ObjectMapper defaultMapper;
    protected ObjectMapper prettyMapper;
    protected DefaultPrettyPrinter prettyPrinter;

    @PostConstruct
    public void init() {
        prettyMapper = new ObjectMapper();
    }

    /**
     * @param address
     * @return
     * @throws JsonProcessingException
     */
    public String prettyPrintAddress(Address address) throws JsonProcessingException {
        String jsonBody = prettyMapper.writeValueAsString(address);
        log.info(jsonBody);
        return jsonBody;

    }

    public String prettyPrintAddressList(List<Address> address) throws JsonProcessingException {
        String jsonBody = prettyMapper.writeValueAsString(address);
        log.info(jsonBody);
        return jsonBody;

    }
   public void prettyPrintAddressByType(Address address) throws JsonProcessingException {
        String jsonBody= prettyMapper.writeValueAsString(address);
        switch (address.getType().getName()) {
            case "Business Address"-> log.info("BUSINESS_ADDRESS :"+address);
            case "Physical Address" -> log.info("PHYSICAL_ADDRESS : "+address);
            case "Postal Address"-> log.info("POSTAL_ADDRESS : "+address);
            default-> log.info("Unknown");
        }
    }

    /**
     *
     * @param address
     * @throws AddressException
     * @throws PostalCodeNotFoundException
     * @throws ProvinceNotFoundException
     * @throws AddressLineDetailsNotFoundException
     * @throws CountryNotFoundException
     */
    public void validateAddress(Address address) throws AddressException, PostalCodeNotFoundException, ProvinceNotFoundException, AddressLineDetailsNotFoundException, CountryNotFoundException {
        validatePostalCode(address);
        countryValidation(address);
        isProvinceAvailable(address);
        addressLineValidation(address);
    }
    /**
     * @param jsonBody
     * @return
     * @throws JsonProcessingException
     */
    public Address deserialiseAddress(String jsonBody) throws JsonProcessingException {
        return (Address) defaultMapper.readValue(jsonBody, Address.class);

    }


    /**
     *
     * @param address
     * @return
     * @throws AddressException
     * @throws PostalCodeNotFoundException
     */
    private boolean validatePostalCode(Address address) throws AddressException, PostalCodeNotFoundException {
        if (address != null) {
            if (address.getPostalCode() != null) {
                if ( address.getPostalCode().matches(NUMBERIC_REGIX)){
                    return true;
                }
                throw PostalCodeNotFoundException.builder().message("Postal code provided is not numeric only").build();
            }
            log.info("Postal code is null");
            throw PostalCodeNotFoundException.builder().message("Postal code field is null").build();

        }
        throw AddressException.builder().message("Address not provided").build();
    }

    /**
     *
     * @param address
     * @return
     * @throws AddressException
     * @throws CountryNotFoundException
     */
    private boolean countryValidation(Address address) throws AddressException, CountryNotFoundException {
        if (address != null) {
            if (address.getCountry() != null) {
                if (address.getCountry().getName() != null) {
                    return true;
                }
                log.info("Country Name is null");
                throw CountryNotFoundException.builder().message("Country Name is null").build();
            }
            log.info("Country object is null");
            throw CountryNotFoundException.builder().message("Country not provided").build();
        }
        throw AddressException.builder().message("Address not provided").build();
    }

    /**
     *
     * @param address
     * @return
     * @throws ProvinceNotFoundException
     * @throws AddressException
     */
    private boolean isProvinceAvailable(Address address) throws ProvinceNotFoundException, AddressException {

        try {
            if (address!=null){
                if (address.getCountry().getCode().equals(CountryCode.ZA.name())){
                    if (address.getProvinceOrState()!=null) {
                        return true;
                    }
                    log.info("Province not provided");
                    throw ProvinceNotFoundException.builder().message("Province not provided").build();
                }else
                    return true;
            }
            log.info("Address not provided");
            throw  AddressException.builder().message("Address not provided").build();

        }catch (AddressException addressException){
            throw AddressException.builder().message("Address not provided").build();
        }catch (ProvinceNotFoundException provinceNotFoundException){
            throw ProvinceNotFoundException.builder().message("Province not provided").build();
        }
    }


    /**
     *
     * @param address
     * @return
     * @throws AddressLineDetailsNotFoundException
     */
    private boolean addressLineValidation(Address address) throws AddressLineDetailsNotFoundException {
        if (address != null) {
            if (address.getAddressLineDetail() != null) {
                if (address.getAddressLineDetail().getLine1() != null || address.getAddressLineDetail().getLine2() != null)
                    return true;
            }
        }
        log.info("getAddressLineDetail Has no line1 or line 2");
        throw AddressLineDetailsNotFoundException.builder().message("Address Details not provided").build();

    }

}
