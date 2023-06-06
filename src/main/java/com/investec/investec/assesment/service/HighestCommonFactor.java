package com.investec.investec.assesment.service;


import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class HighestCommonFactor {


        public int highestCommonFactor(int[] numbers) {
            int highestCommonFactor = numbers[0];

            for (int i = 1; i < numbers.length; i++) {
                highestCommonFactor = calculateHighestCommonFactor(highestCommonFactor, numbers[i]);
            }

            return highestCommonFactor;
        }

        private int calculateHighestCommonFactor(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return calculateHighestCommonFactor(b, a % b);
            }
        }
    }
