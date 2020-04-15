package ua.lviv.iot.shoeStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class BootsFunction {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Functions_Boots", joinColumns = {
            @JoinColumn(name = "bootsFunction_id", nullable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "boots_id", nullable = false) })
    @JsonIgnoreProperties("bootsFunctions")
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

    public Set<Boots> getBoots() {
        return boots;
    }

    public void setBoots(Set<Boots> boots) {
        this.boots = boots;
    }

}
