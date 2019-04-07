package classes;

import java.util.Date;

public class Card extends Payment {

    // region variables
    private String holderName;
    private int id;
    private int cvv;
    private Date expDate; //todo Joda Time
    private CardType cardType;
    // region variables

    // region Constructor
    public Card(float amount, String holderName, int id, int cvv, Date expDate, CardType cardType) {
        super(amount);

        this.holderName = holderName;
        setId(id);
        setCvv(cvv);
        setExpDate(expDate);
        this.cardType = cardType;
    }
    // endregion Constructor

    // region accessors

    public String getHolderName() {
        return holderName;
    }

    public int getId() {
        return id;
    }

    public int getCvv() {
        return cvv;
    }

    public Date getExpDate() {
        return (Date) expDate.clone(); // todo might be a waste of memory
    }

    public CardType getCardType() {
        return cardType;
    }
    // endregion accessors

    // region mutators

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setId(int id) {
        //todo implement
        throw new UnsupportedOperationException();
    }

    public void setCvv(int cvv) {
        //todo implement
        throw new UnsupportedOperationException();
    }

    public void setExpDate(Date expDate) {
        //todo implement
        throw new UnsupportedOperationException();
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    // endregion mutators

    protected void logPayment() {
        //todo implement
        throw new UnsupportedOperationException();
    }

    protected void printReceipt() {
        //todo implement
        hardwareRep.printReceipt("");
        throw new UnsupportedOperationException();
    }

    protected void performTransaction() {
        //todo implement
        throw new UnsupportedOperationException();
    }
}
