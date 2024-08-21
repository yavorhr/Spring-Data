package com.example.realdeal.service.impl;

import com.example.realdeal.service.PictureService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {
  @Override
  public boolean areImported() {
    return false;
  }

  @Override
  public String readPicturesFromFile() throws IOException {
    return null;
  }

  @Override
  public String importPictures() throws IOException {
    return null;
  }
}
