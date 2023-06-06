package com.investec.investec.assesment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String id;
    private String cityOrTown;
    private String postalCode;
    private String lastUpdated;
    private String suburbOrDistrict;
    private Type type;
    private AddressLineDetail addressLineDetail;
    private ProvinceOrState provinceOrState;
    private Country country;


}
