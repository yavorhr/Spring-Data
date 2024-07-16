package com.example.advquerying.services;

import com.example.advquerying.entities.Size;

import java.util.List;

public interface ShampooService {

  List<String> findAllShampoosBySize(String size);

  List<String> findAllShampoosBySizeOrLabel(Size medium, long labelId);
}
