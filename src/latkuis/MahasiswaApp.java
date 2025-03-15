package latkuis;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;


public class MahasiswaApp {
    public static void main(String[] args) {
    showLoginForm();
    }
    
 private static void showLoginForm() {
        JFrame frame = new JFrame("Login Page");
        frame.setSize(2200, 2200);
        frame.setLocationRelativeTo(null);        
        frame.setAlwaysOnTop(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 5, 5));
        
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        
        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(new JLabel());
        frame.add(loginButton);
        
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            
            if (username.equals("123230109") && password.equals("ifkelasg")) {
                JOptionPane.showMessageDialog(frame, "Login Berhasil!");
                frame.dispose();
                showLandingPage();
            } else {
                JOptionPane.showMessageDialog(frame, "Login Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        frame.setVisible(true);
    }
    
    private static void showLandingPage() {
        JFrame frame = new JFrame("Halaman Input Nilai");
        frame.setLocationRelativeTo(null);        
        frame.setAlwaysOnTop(false);
        frame.setLayout(null);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(8, 2, 5, 5));
        
        JLabel nameLabel = new JLabel("Nama:");
        JTextField nameField = new JTextField();
        JLabel nimLabel = new JLabel("NIM:");
        JTextField nimField = new JTextField();
        JLabel tugasLabel = new JLabel("Nilai Tugas:");
        JTextField tugasField = new JTextField();
        JLabel kuisLabel = new JLabel("Nilai Kuis:");
        JTextField kuisField = new JTextField();
        
        JRadioButton teoriButton = new JRadioButton("Teori", true);
        JRadioButton praktikumButton = new JRadioButton("Praktikum");
        ButtonGroup Tipekelas = new ButtonGroup();
        Tipekelas.add(teoriButton);
        Tipekelas.add(praktikumButton);
        
        String[] mataKuliah = {"PBO", "SCPK", "Algo Lanjut"};
        JComboBox comboBox = new JComboBox(mataKuliah);
        
        JButton submitButton = new JButton("Submit");
        JButton logoutButton = new JButton("Logout");
        
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(nimLabel);
        frame.add(nimField);
        frame.add(tugasLabel);
        frame.add(tugasField);
        frame.add(kuisLabel);
        frame.add(kuisField);
        frame.add(new JLabel("Kelas:"));
        frame.add(teoriButton);
        frame.add(new JLabel());
        frame.add(praktikumButton);
        frame.add(new JLabel("Mata Kuliah:"));
        frame.add(comboBox);
        frame.add(submitButton);
        frame.add(logoutButton);
        
        submitButton.addActionListener(e -> {
            try {
                String nama = nameField.getText();
                String nim = nimField.getText();
                double nilaiTugas = Double.parseDouble(tugasField.getText());
                double nilaiKuis = Double.parseDouble(kuisField.getText());
                String kelas = teoriButton.isSelected() ? "Teori" : "Praktikum";
                String matkul = (String) comboBox.getSelectedItem();
                
                double totalNilai = kelas.equals("Teori") ? (0.3 * nilaiTugas) + (0.7 * nilaiKuis) : (0.7 * nilaiTugas) + (0.3 * nilaiKuis);
                
                String hasil = (totalNilai > 85) ? "PASS" : "NOT PASS";
                
                JOptionPane.showMessageDialog(frame,
                        "Nama: " + nama + 
                        "\nNIM: " + nim +
                        "\nMata Kuliah: " + matkul +
                        "\nTipe Kelas: " + kelas + 
                        "\nTotal Nilai: " + totalNilai + 
                        "\nHasil: " + hasil);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        logoutButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin logout?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                frame.dispose();
                showLoginForm();
            }
        });
        
        frame.setVisible(true);
        
    }
}

