package xmlExercise.cardealer.model.Dto.seedDto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersWithNameAndImporterDto {

    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "is-importer")
    private boolean isImporter;

    public String getName() {
        return name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
