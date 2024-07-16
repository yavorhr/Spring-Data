package com.example.advquerying.services;

import java.util.List;

public interface ShampooService {

  List<String> findAllShampoosBySize(String size);
}
