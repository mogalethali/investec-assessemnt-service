package com.investec.investec.assesment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressLineDetail {
    private String line1;
    private String line2;
}
