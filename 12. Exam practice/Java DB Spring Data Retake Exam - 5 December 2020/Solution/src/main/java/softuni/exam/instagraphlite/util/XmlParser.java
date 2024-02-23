package softuni.exam.instagraphlite.util;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface XmlParser {

    //Unmarshall : подаваме пътя до файла, от който ще четем и DtoClass, към който ще намапваме инфото от файла
    <T> T fromFile (String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException;


}
