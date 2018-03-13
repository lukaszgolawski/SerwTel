package panelcustomerslist.controller.databasetools;

import panelactiveorders.controller.databasetools.Orders;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customers {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "NIP")
    private String nip;
    @Column(name = "STREET")
    private String street;
    @Column(name = "PCODE")
    private String pcode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "TELNUM", nullable = false)
    private String telnum;
    @OneToMany(mappedBy = "customers")
    private List<Orders> orders;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
