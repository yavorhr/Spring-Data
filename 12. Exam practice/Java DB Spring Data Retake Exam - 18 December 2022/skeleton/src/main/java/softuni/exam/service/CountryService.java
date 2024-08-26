package softuni.exam.service;


import softuni.exam.models.entity.Country;

import java.io.IOException;

public interface CountryService {

    boolean areImported();

    String readCountriesFileContent() throws IOException;

    String importCountries() throws IOException;

    Country findCountryById(Long id);
}
