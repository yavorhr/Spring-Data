package softuni.exam.util.impl;

import org.springframework.stereotype.Component;
import softuni.exam.util.XmlParse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class XmlParseImpl implements XmlParse {

    private JAXBContext jaxbContext;

    @SuppressWarnings("unchecked")
    @Override
    public <T> T fromFile(String filePath, Class<T> tClass) throws JAXBException, FileNotFoundException {
        jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new FileReader(filePath));

    }
}
