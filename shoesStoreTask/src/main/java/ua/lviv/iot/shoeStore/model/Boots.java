package ua.lviv.iot.shoeStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Boots extends AbstractShoes {

    private double hightfShaftlnSM;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bootsProducer_id")
    @JsonIgnoreProperties("boots")
    private BootsProducer bootsProducer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Functions_Boots", joinColumns = {
            @JoinColumn(name = "boots_id", nullable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "bootsFunction_id", nullable = false) })
    @JsonIgnoreProperties("boots")
    private Set<BootsFunction> bootsFunctions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getHightfShaftlnSM() {
        return hightfShaftlnSM;
    }

    public void setHightfShaftlnSM(double hightfShaftlnSM) {
        this.hightfShaftlnSM = hightfShaftlnSM;
    }

    public BootsProducer getBootsProducer() {
        return bootsProducer;
    }

    public void setBootsProducer(BootsProducer bootsProducer) {
        this.bootsProducer = bootsProducer;
    }

    public Set<BootsFunction> getBootsFunctions() {
        return bootsFunctions;
    }

    public void setBootsFunctions(Set<BootsFunction> bootsFunctions) {
        this.bootsFunctions = bootsFunctions;
    }

    public Boots(int sizeEURstandart, double priceInUAH, String assignment, Sex sex, String brand, String color,
            String materialOfVamp, String materialOfLining, Heels heels, String toecapType, double hightfShaftlnSM) {
        super(sizeEURstandart, priceInUAH, assignment, sex, brand, color, materialOfVamp, materialOfLining, heels,
                toecapType);
        this.hightfShaftlnSM = hightfShaftlnSM;
    }

    public String getHeaders() {
        return super.getHeaders() + "," + "hightfShaftlnSM";
    }

    public String toCSV() {
        return super.toCSV() + "," + getHightfShaftlnSM();
    }

    public Boots() {
        super(0, 0.0, null, null, null, null, null, null, new Heels(null, 0.0), null);
        this.hightfShaftlnSM = 0.0;
    }

}
