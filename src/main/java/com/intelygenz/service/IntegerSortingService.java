package com.intelygenz.service;

import com.intelygenz.repository.IntegerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IntegerSortingService {

    @Autowired
    IntegerRepository integerRepository;

    public List<Integer> sortIntegers(Long id){

        String stringOfNumbers = integerRepository.findIntegersById(id);

        String[] numberArray = stringOfNumbers.split(",");

        List<Integer> integerList = Arrays.stream(numberArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        integerList.sort((a, b) -> {
            int onesInA = Integer.bitCount(a);
            int onesInB = Integer.bitCount(b);
            if (onesInA != onesInB) {
                return Integer.compare(onesInA, onesInB);
            }
            return Integer.compare(a, b);
        });
        return integerList;
    }
}