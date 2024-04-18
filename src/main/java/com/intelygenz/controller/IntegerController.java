package com.intelygenz.controller;

import com.intelygenz.service.IntegerSortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/integers")
public class IntegerController {

    @Autowired
    private IntegerSortingService integerSortingService;

    @GetMapping("/sorted/{id}")
    public ResponseEntity<List<Integer>> getSortedIntegers(@PathVariable long id) {
        List<Integer> sortedIntegers = integerSortingService.sortIntegers(id);

        return ResponseEntity.ok(sortedIntegers);
    }
}
