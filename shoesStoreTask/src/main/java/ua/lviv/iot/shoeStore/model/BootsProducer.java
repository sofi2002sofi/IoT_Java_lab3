package ua.lviv.iot.shoeStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"bootsProducer\"")
public class BootsProducer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String name;

    private String headquarters;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("bootsProducer")
    private Set<Boots> boots;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public Set<Boots> getBoots() {
        return boots;
    }

    public void setBoots(Set<Boots> boots) {
        this.boots = boots;
    }

    public BootsProducer() {

    }
}
