package DTO;

public class BookDTO {
    private int bookId;
    private String bookName;
    private double bookPrice;

    public int getbookId() {
        return bookId;
    }

    public void setbookId(int bookId) {
        this.bookId = bookId;
    }

    public String getbookName() {
        return bookName;
    }

    public void setbookName(String bookName) {
        this.bookName = bookName;
    }

    public double getbookPrice() {
        return bookPrice;
    }

    public void setbookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return bookId+"\t\t"+bookName+"\t\t"+bookPrice;
    }
}


