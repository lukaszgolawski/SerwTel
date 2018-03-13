package panelactiveorders.controller.databasetools;


import panelcustomerslist.controller.databasetools.Customers;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "ID_ORDER")
    private int idOrder;
    @Column(name = "MODEL_PHONE", nullable = false)
    private String modelPhone;
    @Column(name = "PROBLEM", nullable = false)
    private String problem;
    @Column(name = "STATUS", nullable = false)
    private String status;
    @Column(name = "START_DATE", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private java.util.Date startDate;
    @Column(name = "FINISH_DATE")
    @Temporal(value = TemporalType.DATE)
    private java.util.Date finishDate;
    @ManyToOne
    @JoinColumn(name = "ID_CUSTOMER", nullable = false)
    private Customers customers;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getModelPhone() {
        return modelPhone;
    }

    public void setModelPhone(String modelPhone) {
        this.modelPhone = modelPhone;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
}
