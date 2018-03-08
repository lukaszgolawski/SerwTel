package panelactiveorders.controller.databasetools;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "CUSTOMERS")
public class Orders {
    @Id
    @GeneratedValue
    @Column(name="ID_ORDER")
    private int idOrder;
    @Column(name = "ID_CUSTOMER")
    private int idCustomer;
    @Column(name="MODEL_PHONE")
    private String modelPhone;
    @Column(name="PROBLEM")
    private String problem;
    @Column(name="STATUS")
    private String status;
    @Column(name="START_DATE")
    private java.sql.Timestamp startDate;
    @Column(name="FINISH_DATE")
    private java.sql.Date finishDate;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}
