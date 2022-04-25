package entity;

import com.mysql.cj.jdbc.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    //first name, last name, address, email, date of birth, picture, information whether he has medical insurance or not.

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column()
    private String address;
    @Column(nullable = false)
    private Date dateOfBirth;
    @Column
    private String picture;
    @Column(columnDefinition = "TEXT")
    private String information;
    @Column(nullable = false)
    private Boolean medicalInsurance;

    @OneToMany(mappedBy = "patient")
    private Set<Visitation> visitations;

    @OneToMany(mappedBy = "patient")
    private Set<Diagnose> diagnoses;

    @OneToMany(mappedBy = "patient")
    private Set<Medicament> medicaments;

    public Patient() {
        this.visitations = new HashSet<>();
        this.diagnoses = new HashSet<>();
        this.medicaments = new HashSet<>();
    }

    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPicture() {
        return picture;
    }

    public String getInformation() {
        return information;
    }

    public Boolean getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setMedicalInsurance(Boolean medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }
}
