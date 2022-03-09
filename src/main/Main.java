package main;

import util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = JdbcConnection.getConnection();
            System.out.println(connection.getCatalog());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter office information");
            System.out.println("City:");
            String city = scanner.nextLine();
            System.out.println("Phone:");
            String phone = scanner.nextLine();
            System.out.println("Address:");
            String address = scanner.nextLine();
            System.out.println("Country");
            String country = scanner.nextLine();
            System.out.println("Postal Code");
            String postalCode = scanner.nextLine();
            System.out.println("Territory");
            String territory = scanner.nextLine();

            /*String insertOffice = "INSERT INTO offices(city, phone, addressLIne1, country, postalCode, territory)" +
                    " VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement pstm = connection.prepareStatement(insertOffice);
            pstm.setString(1, city);
            pstm.setString(2, phone);
            pstm.setString(3, address);
            pstm.setString(4, country);
            pstm.setString(5, postalCode);
            pstm.setString(6, territory);

            boolean isInserted = pstm.execute();
            if (isInserted) {
                System.out.println("Shtimi u krye me sukses");
            } else {
                System.out.println("Shtimi nuk u krye");
            }*/
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
