package by.company.kindergartens.models;

import javax.persistence.*;

@Entity
@Table(name="info")
public class Information {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nursery_group, younger_group, middle_group, senior_group;
    private String nursery, younger, middle, senior;

    @OneToOne(mappedBy = "info", cascade = CascadeType.ALL)
    private Kindergarten kinder1;

    public Kindergarten getKinder1() {
        return kinder1;
    }

    public void setKinder1(Kindergarten kinder1) {
        this.kinder1 = kinder1;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getNursery_group() {
        return nursery_group;
    }

    public void setNursery_group(String nursery_group) {
        this.nursery_group = nursery_group;
    }

    public String getYounger_group() {
        return younger_group;
    }

    public void setYounger_group(String younger_group) {
        this.younger_group = younger_group;
    }

    public String getMiddle_group() {
        return middle_group;
    }

    public void setMiddle_group(String middle_group) {
        this.middle_group = middle_group;
    }

    public String getSenior_group() {
        return senior_group;
    }

    public void setSenior_group(String senior_group) {
        this.senior_group = senior_group;
    }

    public String getNursery() {
        return nursery;
    }

    public void setNursery(String nursery) {
        this.nursery = nursery;
    }

    public String getYounger() {
        return younger;
    }

    public void setYounger(String younger) {
        this.younger = younger;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    public Long getId() {
        return id;
    }
}
