package com.investec.investec.assesment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.investec.investec.assesment.service.HighestCommonFactor;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class HighestCommonFactorTest {

    @Autowired
    HighestCommonFactor highestCommonFactor;
    ObjectMapper mapper = new ObjectMapper();
    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void highestCommonFactorTest(){
        int[] numbers = {54,24};
        int highestCommonFactorTest = highestCommonFactor.highestCommonFactor(numbers);
        log.info("highestCommonFactorTest: " + highestCommonFactorTest);
        Assert.assertEquals(6,highestCommonFactorTest);
    }
}
