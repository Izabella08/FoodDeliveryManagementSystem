package presentation;

import businessLayer.BaseProduct;
import businessLayer.DeliveryService;
import businessLayer.MenuItem;
import businessLayer.Order;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class AdministratorView extends JFrame{

    JButton backButton;
    JButton importProducts;
    JButton addProduct;
    JButton deleteProduct;
    JButton modifyProduct;
    JButton generateReport;
    JButton generateReport2;
    JButton generateReport3;
    JButton generateReport4;
    JLabel productTitle;
    JTextField titleText;
    JLabel rating;
    JTextField ratingText;
    JLabel calories;
    JTextField caloriesText;
    JLabel protein;
    JTextField proteinText;
    JLabel fat;
    JTextField fatText;
    JLabel sodium;
    JTextField sodiumText;
    JLabel price;
    JTextField priceText;
    JLabel type;
    JTextField typeText;
    BaseProduct productBaseProduct;
    DefaultTableModel defaultTableModel;
    JTable jTable;
    DeliveryService service;
    JLabel hour1;
    JTextField hour1Text;
    JLabel hour2;
    JTextField hour2Text;
    JLabel repeat;
    JTextField repeatText;
    DeliveryService deliveryService = new DeliveryService();


    public AdministratorView(){
        this.setSize(1700, 750);
        this.setTitle("FOOD DELIVERY MANAGEMENT SYSTEM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(2, 200, 220));

        JLabel title = new JLabel("ADMINISTRATOR");
        title.setBounds(500, 5, 300, 70);
        title.setForeground(new Color(0, 0, 0));
        title.setBackground(new Color(2, 200, 220));
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setVisible(true);
        this.add(title);

        productTitle =new JLabel("Title:");
        productTitle.setBounds(300,80,100,40);
        productTitle.setFont(new Font("Aerial",Font.BOLD,25));
        productTitle.setForeground(Color.BLACK);
        this.add(productTitle);
        titleText=new JTextField();
        titleText.setBounds(420,90,170,25);
        this.add(titleText);

        rating=new JLabel("Rating:");
        rating.setBounds(300,120,100,40);
        rating.setFont(new Font("Aerial",Font.BOLD,25));
        rating.setForeground(Color.BLACK);
        this.add(rating);
        ratingText=new JTextField();
        ratingText.setBounds(420,130,170,25);
        this.add(ratingText);

        calories=new JLabel("Calories:");
        calories.setBounds(300,150,100,70);
        calories.setFont(new Font("Aerial",Font.BOLD,20));
        calories.setForeground(Color.BLACK);
        this.add(calories);
        caloriesText=new JTextField();
        caloriesText.setBounds(420,170,170,25);
        this.add(caloriesText);

        protein=new JLabel("Protein:");
        protein.setBounds(300,200,100,40);
        protein.setFont(new Font("Aerial",Font.BOLD,25));
        protein.setForeground(Color.BLACK);
        this.add(protein);
        proteinText=new JTextField();
        proteinText.setBounds(420,210,170,25);
        this.add(proteinText);

        fat=new JLabel("Fat:");
        fat.setBounds(300,240,100,40);
        fat.setFont(new Font("Aerial",Font.BOLD,25));
        fat.setForeground(Color.BLACK);
        this.add(fat);
        fatText=new JTextField();
        fatText.setBounds(420,250,170,25);
        this.add(fatText);

        sodium=new JLabel("Sodium:");
        sodium.setBounds(300,280,100,40);
        sodium.setFont(new Font("Aerial",Font.BOLD,25));
        sodium.setForeground(Color.BLACK);
        this.add(sodium);
        sodiumText=new JTextField();
        sodiumText.setBounds(420,290,170,25);
        this.add(sodiumText);

        price=new JLabel("Price:");
        price.setBounds(300,320,100,40);
        price.setFont(new Font("Aerial",Font.BOLD,25));
        price.setForeground(Color.BLACK);
        this.add(price);
        priceText=new JTextField();
        priceText.setBounds(420,330,170,25);
        this.add(priceText);

        type=new JLabel("Type:");
        type.setBounds(300,360,100,40);
        type.setFont(new Font("Aerial",Font.BOLD,25));
        type.setForeground(Color.BLACK);
        this.add(type);
        typeText=new JTextField();
        typeText.setBounds(420,370,170,25);
        this.add(typeText);

        hour1=new JLabel("Hour1:");
        hour1.setBounds(300,400,100,40);
        hour1.setFont(new Font("Aerial",Font.BOLD,25));
        hour1.setForeground(Color.BLACK);
        this.add(hour1);
        hour1Text=new JTextField();
        hour1Text.setBounds(420,410,170,25);
        this.add(hour1Text);

        hour2=new JLabel("Hour2:");
        hour2.setBounds(300,440,100,40);
        hour2.setFont(new Font("Aerial",Font.BOLD,25));
        hour2.setForeground(Color.BLACK);
        this.add(hour2);
        hour2Text=new JTextField();
        hour2Text.setBounds(420,450,170,25);
        this.add(hour2Text);

     /*   repeat=new JLabel("Repeat:");
        repeat.setBounds(300,480,100,40);
        repeat.setFont(new Font("Aerial",Font.BOLD,25));
        repeat.setForeground(Color.BLACK);
        this.add(repeat);
        repeatText=new JTextField();
        repeatText.setBounds(420,490,170,25);
        this.add(repeatText);*/

        importProducts = new JButton("Import products");
        importProducts.setBounds(20,70,250,50);
        importProducts.setBackground(new Color(0, 0, 0));
        importProducts.setFont(new Font("Arial",Font.BOLD,25));
        importProducts.setForeground(Color.WHITE);
        importProducts.setFocusable(false);
        importProducts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==importProducts){

                }
            }
        });
        this.add(importProducts);

        addProduct = new JButton("Add new product");
        addProduct.setBounds(20,150,250,50);
        addProduct.setBackground(new Color(0, 0, 0));
        addProduct.setFont(new Font("Arial",Font.BOLD,25));
        addProduct.setForeground(Color.WHITE);
        addProduct.setFocusable(false);
        addProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addProduct){
                    String prName = titleText.getText();
                    Float prRating = Float.parseFloat(ratingText.getText());
                    int prCalories = Integer.parseInt(caloriesText.getText());
                    int prProtein = Integer.parseInt(proteinText.getText());
                    int prFat = Integer.parseInt(fatText.getText());
                    int prSodium = Integer.parseInt(sodiumText.getText());
                    int prPrice = Integer.parseInt(priceText.getText());
                    //Float prType = Float.parseFloat(typeText.getText());
                    BaseProduct newPr = new BaseProduct(prName,prRating, prCalories, prProtein, prFat, prSodium,prPrice);
                    service.createNewProduct(newPr);
                }
            }
        });
        this.add(addProduct);

        deleteProduct = new JButton("Delete product");
        deleteProduct.setBounds(20,230,250,50);
        deleteProduct.setBackground(new Color(0, 0, 0));
        deleteProduct.setFont(new Font("Arial",Font.BOLD,25));
        deleteProduct.setForeground(Color.WHITE);
        deleteProduct.setFocusable(false);
        deleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==deleteProduct){

                }
            }
        });
        this.add(deleteProduct);

        modifyProduct = new JButton("Edit product");
        modifyProduct.setBounds(20,310,250,50);
        modifyProduct.setBackground(new Color(0, 0, 0));
        modifyProduct.setFont(new Font("Arial",Font.BOLD,25));
        modifyProduct.setForeground(Color.WHITE);
        modifyProduct.setFocusable(false);
        modifyProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==modifyProduct){

                }
            }
        });
        this.add(modifyProduct);

        generateReport = new JButton("Generate report 1");
        generateReport.setBounds(20,390,250,50);
        generateReport.setBackground(new Color(0, 0, 0));
        generateReport.setFont(new Font("Arial",Font.BOLD,25));
        generateReport.setForeground(Color.WHITE);
        generateReport.setFocusable(false);
        generateReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==generateReport){
                    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime h1 = LocalDateTime.parse(hour1Text.getText(), format);
                    LocalDateTime h2 = LocalDateTime.parse(hour2Text.getText(), format);
                   /* try {
                        deliveryService.generateReport1(h1, h2);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }*/

                }
            }
        });
        this.add(generateReport);

        generateReport2 = new JButton("Generate report 2");
        generateReport2.setBounds(20,470,250,50);
        generateReport2.setBackground(new Color(0, 0, 0));
        generateReport2.setFont(new Font("Arial",Font.BOLD,25));
        generateReport2.setForeground(Color.WHITE);
        generateReport2.setFocusable(false);
        generateReport2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==generateReport2){
                   // deliveryService.generateReport2(5);
                }
            }
        });
        this.add(generateReport2);

        generateReport3 = new JButton("Generate report 3");
        generateReport3.setBounds(20,550,250,50);
        generateReport3.setBackground(new Color(0, 0, 0));
        generateReport3.setFont(new Font("Arial",Font.BOLD,25));
        generateReport3.setForeground(Color.WHITE);
        generateReport3.setFocusable(false);
        generateReport3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==generateReport3){
                    //deliveryService.generateReport3(6, 100);
                }
            }
        });
        this.add(generateReport3);

        generateReport4 = new JButton("Generate report 4");
        generateReport4.setBounds(20,630,250,50);
        generateReport4.setBackground(new Color(0, 0, 0));
        generateReport4.setFont(new Font("Arial",Font.BOLD,25));
        generateReport4.setForeground(Color.WHITE);
        generateReport4.setFocusable(false);
        generateReport4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==generateReport4){
                    LocalDateTime time = LocalDateTime.now();
                    //deliveryService.generateReport4(time);
                }
            }
        });
        this.add(generateReport4);

        backButton=new JButton("Back");
        backButton.setBounds(1300,10,150,30);
        backButton.setBackground(new Color(0, 0,0));
        backButton.setFont(new Font("Aerial", Font.BOLD,20));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==backButton)
                {
                    dispose();
                    MainFrame v=new MainFrame();
                }
            }
        });
        this.add(backButton);

        JPanel jPanel;
        jPanel = new JPanel();
        jPanel.setBorder(new EtchedBorder());
        this.add(jPanel);
        jPanel.setLayout(null);
        jPanel.setBounds(600,100,900,500);
        jPanel.setBackground(Color.WHITE);
        jPanel.setVisible(true);

        productBaseProduct = new BaseProduct();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Title");
        defaultTableModel.addColumn("Rating");
        defaultTableModel.addColumn("Calories");
        defaultTableModel.addColumn("Protein");
        defaultTableModel.addColumn("Fat");
        defaultTableModel.addColumn("Sodium");
        defaultTableModel.addColumn("Price");

        List<BaseProduct> baseProductList;
        baseProductList = productBaseProduct.readCsvFile();

        for (BaseProduct bp:baseProductList) {
            String  name = bp.getTitle();
            String  rating = Float.toString(bp.getRating());
            String  calories = Integer.toString(bp.getCalories());
            String protein = Integer.toString(bp.getProtein());
            String fat = Integer.toString(bp.getFat());
            String sodium = Integer.toString(bp.getSodium());
            String price = Integer.toString(bp.getPrice());
            defaultTableModel.addRow(new Object[]{name,rating,calories,protein,fat,sodium,price});
        }

        jTable = new JTable(defaultTableModel);
        jTable.setVisible(true);
        jTable.setBounds(0,0,500,500);
        jTable.setForeground(new Color(0, 0,0));
        jTable.setFont(new Font("Arial",Font.BOLD,20));
        JScrollPane sp=new JScrollPane(jTable);
        sp.setBounds(0,0,900,500);
        jPanel.add(sp);

        this.setVisible(true);
    }
}
