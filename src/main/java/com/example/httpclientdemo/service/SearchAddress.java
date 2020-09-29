package com.example.httpclientdemo.service;

import com.example.httpclientdemo.domain.Address;

public interface SearchAddress {

    Address getAddress(String postalCode);
}
