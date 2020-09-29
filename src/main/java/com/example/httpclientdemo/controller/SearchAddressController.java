package com.example.httpclientdemo.controller;

import com.example.httpclientdemo.domain.Address;
import com.example.httpclientdemo.service.SearchAddress;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class SearchAddressController {

    private final SearchAddress searchAddress;

    public SearchAddressController(SearchAddress searchAddress) {
        this.searchAddress = searchAddress;
    }

    @GetMapping("/{postalCode}")
    public ResponseEntity<Address> getAddress(@PathVariable("postalCode") String postalCode) {
        Address address = searchAddress.getAddress(postalCode);
        return ResponseEntity.ok(address);
    }
}
