package com.investec.investec.assesment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.investec.investec.assesment.exception.*;
import com.investec.investec.assesment.model.*;
import com.investec.investec.assesment.service.AddressService;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTests {

    @Autowired
    AddressService addressService;
    ObjectMapper mapper = new ObjectMapper();
    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void prettyPrintAddressTest() throws JsonProcessingException {
        String addressResponse = addressService.prettyPrintAddress(getAddress());
        log.info("=========addressResponse======"+addressResponse);
        Assert.assertTrue(addressResponse.contains(getAddress().getPostalCode()));
    }
    @Test
    public void prettyPrintListOfAddressTest() throws JsonProcessingException {
        String addressResponse = addressService.prettyPrintAddressList(getAddressList());
        log.info("=========addressResponse======"+addressResponse);
        Assert.assertTrue(addressResponse.contains(getAddress().getPostalCode()));
    }

    @Test
    public void validateAddressWithContryAddressLineAllValidSuccessful() throws ProvinceNotFoundException, AddressException, CountryNotFoundException, AddressLineDetailsNotFoundException, PostalCodeNotFoundException {
        addressService.validateAddress(getAddress());
    }

    @Test(expected=AddressLineDetailsNotFoundException.class)
    public void validateAddressNoSAWithoutAddressLineValidFail() throws ProvinceNotFoundException, AddressException, CountryNotFoundException, AddressLineDetailsNotFoundException, PostalCodeNotFoundException {
        addressService.validateAddress(getAddressTwo());
    }

    @Test
    public void validateAddressThreeSuccessful() throws ProvinceNotFoundException, AddressException, CountryNotFoundException, AddressLineDetailsNotFoundException, PostalCodeNotFoundException {
        addressService.validateAddress(getAddressThree());
    }

    private List<Address> getAddressList(){
        List<Address>  list = new ArrayList<>();
        list.add(getAddress());
        list.add(getAddressTwo());
        list.add(getAddressThree());

        return list;
    }



    private Address getAddress(){
        return Address.builder()
                .addressLineDetail(AddressLineDetail.builder()
                        .line1("Address 1")
                        .line2("Line 2")
                        .build())
                .cityOrTown("City 1")
                .country(Country.builder()
                        .code("ZA")
                        .name("South Africa")
                        .build())
                .lastUpdated("2015-06-21T00:00:00.000Z")
                .id("1")
                .type(Type.builder()
                        .code("1")
                        .name("Physical Address")
                        .build())
                .provinceOrState(ProvinceOrState.builder()
                        .code("5")
                        .name("Eastern Cape")
                        .build())
                .postalCode("1234")
                .build();
    }

    private Address getAddressTwo(){
        return Address.builder()
                .cityOrTown("City 2")
                .country(Country.builder()
                        .code("LB")
                        .name("Lebanon")
                        .build())
                .lastUpdated("2017-06-21T00:00:00.000Z")
                .id("2")
                .type(Type.builder()
                        .code("2")
                        .name("Postal Address")
                        .build())
                .postalCode("2345")
                .build();
    }

    private Address getAddressThree(){
        return Address.builder()
                .addressLineDetail(AddressLineDetail.builder()
                        .line1("Address 3")
                        .line2("")
                        .build())
                .cityOrTown("City 3")
                .country(Country.builder()
                        .code("ZA")
                        .name("South Africa")
                        .build())
                .lastUpdated("2018-06-13T00:00:00.000Z")
                .id("3")
                .suburbOrDistrict("Suburb 3")
                .type(Type.builder()
                        .code("5")
                        .name("Business Address")
                        .build())
                .provinceOrState(ProvinceOrState.builder()
                        .code("5")
                        .name("Eastern Cape")
                        .build())
                .postalCode("3456")
                .build();
    }
}
