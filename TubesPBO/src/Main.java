import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {
    private Map<String, String> userDatabase = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        // Login Scene
        Label loginTitle = new Label("Login Aplikasi Tiket Konser");
        TextField emailField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Daftar");
        Label loginMessage = new Label();

        VBox loginLayout = new VBox(10, loginTitle, new Label("Email:"), emailField, 
                                    new Label("Password:"), passwordField, loginButton, registerButton, loginMessage);
        loginLayout.setPadding(new Insets(20));
        Scene loginScene = new Scene(loginLayout, 400, 300);

        // Ticket Booking Scene
        Label concertLabel = new Label("Pilih Konser:");
        ComboBox<String> concertComboBox = new ComboBox<>();
        concertComboBox.getItems().addAll("Konser Coldplay", "Konser BTS", "Konser Taylor Swift");

        Label categoryLabel = new Label("Pilih Kategori Tiket:");
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("VIP - Rp 2,000,000", "Gold - Rp 1,500,000", "Silver - Rp 1,000,000");

        Label ticketLabel = new Label("Jumlah Tiket:");
        TextField ticketField = new TextField();

        Button buyButton = new Button("Beli Tiket");
        VBox ticketLayout = new VBox(15, concertLabel, concertComboBox, categoryLabel, categoryComboBox, 
                                     ticketLabel, ticketField, buyButton);
        ticketLayout.setPadding(new Insets(20));
        Scene ticketScene = new Scene(ticketLayout, 450, 450);

        // Payment Method Scene
        Label paymentTitle = new Label("Metode Pembayaran");
        RadioButton mBankingPayment = new RadioButton("M-Banking");
        RadioButton eWalletPayment = new RadioButton("E-Wallet");
        ToggleGroup paymentGroup = new ToggleGroup();
        mBankingPayment.setToggleGroup(paymentGroup);
        eWalletPayment.setToggleGroup(paymentGroup);
        Button confirmPaymentMethod = new Button("Pilih Metode");

        VBox paymentLayout = new VBox(15, paymentTitle, mBankingPayment, eWalletPayment, confirmPaymentMethod);
        paymentLayout.setPadding(new Insets(20));
        Scene paymentScene = new Scene(paymentLayout, 400, 300);

        // Sub-options Scene
        Label subOptionTitle = new Label("Pilih Penyedia Pembayaran");
        ComboBox<String> subOptionCombo = new ComboBox<>();
        Button confirmSubOption = new Button("Konfirmasi");

        VBox subOptionLayout = new VBox(15, subOptionTitle, subOptionCombo, confirmSubOption);
        subOptionLayout.setPadding(new Insets(20));
        Scene subOptionScene = new Scene(subOptionLayout, 400, 300);

        // Virtual Account Scene
        Label vaTitle = new Label("Nomor Virtual Account");
        TextArea vaDetails = new TextArea();
        vaDetails.setEditable(false);
        Button backToTicketScene = new Button("Kembali ke Pemesanan");
        backToTicketScene.setOnAction(e -> primaryStage.setScene(ticketScene));

        VBox vaLayout = new VBox(15, vaTitle, vaDetails, backToTicketScene);
        vaLayout.setPadding(new Insets(20));
        Scene vaScene = new Scene(vaLayout, 400, 300);

        // Navigation Logic
        buyButton.setOnAction(e -> primaryStage.setScene(paymentScene));

        confirmPaymentMethod.setOnAction(e -> {
            RadioButton selectedPayment = (RadioButton) paymentGroup.getSelectedToggle();
            if (selectedPayment != null) {
                String method = selectedPayment.getText();
                subOptionTitle.setText("Pilih Penyedia " + method);

                if (method.equals("M-Banking")) {
                    subOptionCombo.getItems().setAll("Bank BCA", "Bank Mandiri", "Bank BNI", "Bank BRI");
                } else {
                    subOptionCombo.getItems().setAll("ShopeePay", "GoPay", "Dana", "Ovo");
                }

                primaryStage.setScene(subOptionScene);
            }
        });

        confirmSubOption.setOnAction(e -> {
            String subOption = subOptionCombo.getValue();
            if (subOption != null) {
                String vaNumber = "VA-" + (int) (Math.random() * 1000000000);
                vaDetails.setText("Penyedia: " + subOption + "\nNomor Virtual Account: " + vaNumber);
                primaryStage.setScene(vaScene);
            }
        });

        loginButton.setOnAction(e -> {
            primaryStage.setScene(ticketScene);
            primaryStage.setTitle("Aplikasi Pemesanan Tiket Konser");
        });

        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login Aplikasi Tiket Konser");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
