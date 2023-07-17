package DAO;

import DTO.BookDTO;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class BookDAO {
    static Connection con = null;

    static {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql@123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int insertBooks(BookDTO d1) {
        PreparedStatement pstmt=null;
        int count = 0;
        String query = "insert into book_info values(?,?,?)";
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, d1.getbookId());
            pstmt.setString(2, d1.getbookName());
            pstmt.setDouble(3, d1.getbookPrice());
            count= pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

    }

    public int deleteBooks(BookDTO d2) {
        PreparedStatement pstmt=null;
        int count = 0;

        String query2 = "delete from book_info where bookId=?";
        try {
            pstmt = con.prepareStatement(query2);
            pstmt.setInt(1, d2.getbookId());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public ArrayList<BookDTO> displayBooks(){

            Statement stmt = null;
            ResultSet rs = null;
            ArrayList<BookDTO> bookList = new ArrayList<>();
            String query = "select * from book_info";
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    double price = rs.getDouble(3);
                    //store data into DTO class object
                    BookDTO d1 = new BookDTO();
                    d1.setbookId(id);
                    d1.setbookName(name);
                    d1.setbookPrice(price);
                    //add object into list
                    bookList.add(d1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return bookList;

        }
    }



