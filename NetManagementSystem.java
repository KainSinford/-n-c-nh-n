package doancanhan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NetManagementSystem { // hệ thống quản lí quán nets

    private JFrame frame;
    private ArrayList<String> computers = new ArrayList<>();
    private ArrayList<String> seats = new ArrayList<>();
    private ArrayList<String> customers = new ArrayList<>();//khách
    private int totalSeats = 40; // tổng số ghế trong quán
    private int remainingSeats = 40; // só ghế còn tồn tại trong quán 
    private ArrayList<String> hiredSeats = new ArrayList<>();

    public NetManagementSystem() {
        initialize();
    }

    public static void main(String[] args) { //hàm main
        EventQueue.invokeLater(() -> {
            try {
                NetManagementSystem window = new NetManagementSystem();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize() {
        // chỉnh sửa và thiết lập vị trí,kích thước khung
        frame = new JFrame("Net Management System");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        // khởi tạo các nút
        JButton btnAddComputer = new JButton("Add Computer");
        JButton btnAddCustomer = new JButton("Add Customer");
        JButton btnAddSeat = new JButton("Add Seat");
        JButton btnPaidSeats = new JButton("Paid Seats");
        JButton btnListAllSeats = new JButton("List All Seats");
        JButton btnListUsedSeats = new JButton("List Used Seats");
        JButton btnListAvailableSeats = new JButton("List Available Seats");
        JButton btnTotalSeats = new JButton("Total Seats");

        // thêm cacsc nút vào trong khung
        frame.getContentPane().add(btnAddComputer);
        frame.getContentPane().add(btnAddCustomer);
        frame.getContentPane().add(btnAddSeat);
        frame.getContentPane().add(btnPaidSeats);
        frame.getContentPane().add(btnListAllSeats);
        frame.getContentPane().add(btnListUsedSeats);
        frame.getContentPane().add(btnListAvailableSeats);
        frame.getContentPane().add(btnTotalSeats);

        // các nút hoạc động
        btnAddComputer.addActionListener(e -> {
            String computer = JOptionPane.showInputDialog("Enter Computer Title:");
            if (computer != null && !computer.trim().isEmpty()) {
                computers.add(computer);
                JOptionPane.showMessageDialog(frame, "Computer \"" + computer + "\" added successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Computer title cannot be empty!");
            }
        });
        // thêm khách hàng
        btnAddCustomer.addActionListener(e -> {
            String customer = JOptionPane.showInputDialog("Enter Customer Name:");
            if (customer != null && !customer.trim().isEmpty()) {
                customers.add(customer);
                JOptionPane.showMessageDialog(frame, "Customer \"" + customer + "\" added successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Customer name cannot be empty!");
            }
        });
        //thêm chỗ ngòi
        btnAddSeat.addActionListener(e -> {
            if (remainingSeats > 0) {
                String seat = JOptionPane.showInputDialog("Enter Seat Name (example : 'Seat 12'):");
                if (seat != null && !seat.trim().isEmpty()) {
                    seats.add(seat);
                    hiredSeats.add(seat);
                    remainingSeats--;
                    JOptionPane.showMessageDialog(frame, "Seat \"" + seat + "\" added successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Seat name cannot be empty!");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "No more seats available!");
            }
        });
        // ghế đã trả tiền 
        btnPaidSeats.addActionListener(e -> {
            if (!hiredSeats.isEmpty()) {
                String message = "Paid Seats:\n" + String.join("\n", hiredSeats);
                JOptionPane.showMessageDialog(frame, message, "Paid Seats", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "No seats have been hired yet.");
            }
        });
        // hiện thị các ghế 
        btnListAllSeats.addActionListener(e -> {
            if (!seats.isEmpty()) {
                String message = "All Seats:\n" + String.join("\n", seats);
                JOptionPane.showMessageDialog(frame, message, "All Seats", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "No seats have been added yet.");
            }
        });
        // hiển thị các ghế đã có người sử dụng 
        btnListUsedSeats.addActionListener(e -> {
            if (!hiredSeats.isEmpty()) {
                String message = "Used Seats:\n" + String.join("\n", hiredSeats);
                JOptionPane.showMessageDialog(frame, message, "Used Seats", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "No seats are currently in use.");
            }
        });
        // hiển thị ghế còn trống 
        btnListAvailableSeats.addActionListener(e -> {
            int availableSeats = totalSeats - hiredSeats.size();
            JOptionPane.showMessageDialog(frame, "Available Seats: " + availableSeats, "Available Seats", JOptionPane.INFORMATION_MESSAGE);
        });
        // hiển htij tổng số ghế
        btnTotalSeats.addActionListener(e -> {
            String message = "Computers in the store:\n"
                    + "Total computers: " + computers.size() + "\n"
                    + "Total seats: " + totalSeats + "\n"
                    + "Remaining seats: " + remainingSeats;
            JOptionPane.showMessageDialog(frame, message, "Total Seats", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
