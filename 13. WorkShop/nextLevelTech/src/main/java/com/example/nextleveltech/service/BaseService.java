package com.example.nextleveltech.service;

import java.io.IOException;

public interface BaseService {

  boolean areFilesImported();

  String getXmlDataForImport() throws IOException;

}
