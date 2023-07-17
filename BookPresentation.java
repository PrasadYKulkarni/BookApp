package Demo;

import DAO.BookDAO;
import DTO.BookDTO;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class BookPresentation {
    static Scanner sc1=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("SELECT MODE OF OPERATION");
        System.out.println("1: ADD NEW BOOK");
        System.out.println("2: DELETE BOOK");
        System.out.println("3: VIEW BOOKS");
        int choice= sc1.nextInt();
        switch (choice){
            case 1: addBooks();
            break;
            case 2: deleteBooks();
            break;
            case 3: viewBooks();
            break;
            default:
                System.out.println("INVALID CHOICE");
        }
    }
    private static void addBooks(){
        System.out.println("ENTER BOOK ID");
        int id= sc1.nextInt();
        System.out.println("ENTER BOOK NAME");
        String name= sc1.next();
        System.out.println("ENTER BOOK PRICE");
        double price= sc1.nextDouble();
        //add data into dto obect
        BookDTO d1=new BookDTO();
        d1.setbookId(id);
        d1.setbookName(name);
        d1.setbookPrice(price);
        //call method from dao class
        BookDAO b1=new BookDAO();
        int count=b1.insertBooks(d1);
        System.out.println(count+" BOOK INSERTED SUCCESSFULLY");
    }
    private static void deleteBooks(){
        System.out.println("ENTER ID");
        int bId= sc1.nextInt();
        BookDTO d2=new BookDTO();
        d2.setbookId(bId);

        BookDAO b2=new BookDAO();
        int count=b2.deleteBooks(d2);
        System.out.println("BOOK DELETED SUCCESSFULLY");

    }
    private static void viewBooks() {
        BookDAO d3=new BookDAO();
        ArrayList<BookDTO> booklist=d3.displayBooks();

        System.out.println("BOOKID\tBOOKNAME\tBOOKPRICE");
        for (BookDTO d1: booklist){
            System.out.println(d1);
        }
        }
    }




