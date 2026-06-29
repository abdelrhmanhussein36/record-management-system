

public class expose {

    private int id;
    private float amount;
    private String descr;

    public expose(float amount, String descr, int id) {
        this.amount = amount;
        this.descr = descr;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getId() {
        return id;
    }

    public float getAmount() {
        return amount;
    }

    public String getDescr() {
        return descr;
    }
}