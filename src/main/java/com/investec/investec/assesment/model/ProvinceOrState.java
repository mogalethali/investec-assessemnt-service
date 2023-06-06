package com.investec.investec.assesment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProvinceOrState {
    private String code;
    private String name;
}
