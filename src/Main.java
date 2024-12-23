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
        // Scene Login
        Label loginTitle = new Label("Login Aplikasi Tiket Konser");
        loginTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2E86C1;");

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        emailField.setPromptText("Masukkan email Anda");

        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Masukkan password Anda");

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");

        Button registerButton = new Button("Daftar");
        registerButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");

        Label loginMessage = new Label();
        loginMessage.setStyle("-fx-text-fill: red;");

        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new Insets(20));
        loginLayout.getChildren().addAll(
                loginTitle, emailLabel, emailField,
                passwordLabel, passwordField,
                loginButton, registerButton, loginMessage
        );

        Scene loginScene = new Scene(loginLayout, 400, 300);

        // Scene Registrasi
        Label registerTitle = new Label("Daftar Akun Baru");
        registerTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2E86C1;");

        Label regEmailLabel = new Label("Email:");
        TextField regEmailField = new TextField();
        regEmailField.setPromptText("Masukkan email Anda");

        Label regPasswordLabel = new Label("Password:");
        PasswordField regPasswordField = new PasswordField();
        regPasswordField.setPromptText("Masukkan password Anda");

        Label confirmPasswordLabel = new Label("Konfirmasi Password:");
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Konfirmasi password Anda");

        Button submitRegisterButton = new Button("Daftar");
        submitRegisterButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");

        Button backToLoginButton = new Button("Kembali");
        backToLoginButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

        Label registerMessage = new Label();

        VBox registerLayout = new VBox(10);
        registerLayout.setPadding(new Insets(20));
        registerLayout.getChildren().addAll(
                registerTitle, regEmailLabel, regEmailField,
                regPasswordLabel, regPasswordField,
                confirmPasswordLabel, confirmPasswordField,
                submitRegisterButton, backToLoginButton, registerMessage
        );

        Scene registerScene = new Scene(registerLayout, 400, 400);

        // Scene Pemesanan Tiket
        Label title = new Label("Aplikasi Pemesanan Tiket Konser");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #2E86C1;");

        Label nameLabel = new Label("Nama Pelanggan:");
        TextField nameField = new TextField();
        nameField.setPromptText("Masukkan nama pelanggan");

        Label concertLabel = new Label("Pilih Konser:");
        ComboBox<String> concertComboBox = new ComboBox<>();
        concertComboBox.getItems().addAll("Konser Coldplay", "Konser BTS", "Konser Taylor Swift", "Konser Juicy Luicy", "Konser Bernadya", "Konser Daniel Caesar");
        concertComboBox.setStyle("-fx-background-color:rgb(184, 141, 253); -fx-text-fill: white; -fx-font-weight: bold;");

        Label categoryLabel = new Label("Pilih Kategori Tiket:");
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("VIP - Rp 2,000,000", "Gold - Rp 1,500,000", "Silver - Rp 1,000,000");
        categoryComboBox.setStyle("-fx-background-color:rgb(253, 255, 123); -fx-text-fill: white; -fx-font-weight: bold;");

        Label ticketLabel = new Label("Jumlah Tiket:");
        TextField ticketField = new TextField();
        ticketField.setPromptText("Masukkan jumlah tiket");

        Label totalPriceLabel = new Label("Total Harga: Rp 0");
        totalPriceLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #2E86C1;");

        Button buyButton = new Button("Beli Tiket");
        buyButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox ticketLayout = new VBox(15);
        ticketLayout.setPadding(new Insets(20));
        ticketLayout.getChildren().addAll(
                title, nameLabel, nameField, concertLabel, concertComboBox,
                categoryLabel, categoryComboBox,
                ticketLabel, ticketField,
                buyButton
        );

        Scene ticketScene = new Scene(ticketLayout, 450, 450);

     // Payment Method Scene
     Label paymentTitle = new Label("Metode Pembayaran");
     RadioButton mBankingPayment = new RadioButton("M-Banking");
     RadioButton eWalletPayment = new RadioButton("E-Wallet");
     ToggleGroup paymentGroup = new ToggleGroup();
     mBankingPayment.setToggleGroup(paymentGroup);
     eWalletPayment.setToggleGroup(paymentGroup);
     Button confirmPaymentMethod = new Button("Pilih Metode");
     confirmPaymentMethod.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");
     Button backToTicketButton = new Button("Kembali ke Pemesanan");
     backToTicketButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

     VBox paymentLayout = new VBox(15, paymentTitle, mBankingPayment, eWalletPayment, confirmPaymentMethod, backToTicketButton);
     paymentLayout.setPadding(new Insets(20));
     Scene paymentScene = new Scene(paymentLayout, 400, 300);

     // Sub-options Scene
     Label subOptionTitle = new Label("Pilih Penyedia Pembayaran");
     ComboBox<String> subOptionCombo = new ComboBox<>();
     Button confirmSubOption = new Button("Konfirmasi");
     confirmSubOption.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");
     Button backToPaymentButton = new Button("Kembali ke Metode Pembayaran");
    backToPaymentButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

     VBox subOptionLayout = new VBox(15, subOptionTitle, subOptionCombo, confirmSubOption, backToPaymentButton);
     subOptionLayout.setPadding(new Insets(20));
     Scene subOptionScene = new Scene(subOptionLayout, 400, 300);

     // Virtual Account Scene
     Label vaTitle = new Label("Nomor Virtual Account");
     TextArea vaDetails = new TextArea();
     vaDetails.setEditable(false);
     Button completePaymentButton = new Button("Sudah Melakukan Pembayaran");
     completePaymentButton.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-font-weight: bold;");
     Button changePaymentButton = new Button("Ubah Metode Pembayaran");
     changePaymentButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");
     Button cancelOrderButton = new Button("Batalkan Pesanan");
     cancelOrderButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white; -fx-font-weight: bold;");

     VBox vaLayout = new VBox(15, vaTitle, vaDetails, completePaymentButton, changePaymentButton, cancelOrderButton);
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
            subOptionCombo.setStyle("-fx-background-color:rgb(184, 141, 253); -fx-text-fill: white; -fx-font-weight: bold;");
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

       // Receipt Scene
   Label receiptTitle = new Label("Struk Pembelian Tiket");
   receiptTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2E86C1;");
   TextArea receiptArea = new TextArea();
   receiptArea.setEditable(false);
   Button backToMenuButton = new Button("Kembali ke Menu Utama");
   backToMenuButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");

   VBox receiptLayout = new VBox(15, receiptTitle, receiptArea, backToMenuButton);
   receiptLayout.setPadding(new Insets(20));
   Scene receiptScene = new Scene(receiptLayout, 400, 300);

       // Back to Main Menu Action
   backToMenuButton.setOnAction(e -> primaryStage.setScene(ticketScene));

   completePaymentButton.setOnAction(e -> {
       String name = nameField.getText();
       String concert = concertComboBox.getValue();
       String category = categoryComboBox.getValue();
       int ticketCount;
       try {
           ticketCount = Integer.parseInt(ticketField.getText());
       } catch (NumberFormatException ex) {
           vaDetails.setText("Jumlah tiket harus berupa angka!");
           return;
       }
   
       if (name == null || name.isEmpty() || concert == null || category == null) {
           vaDetails.setText("Pastikan semua field telah diisi dengan benar!");
           return;
       }
   
       int ticketPrice = category.contains("VIP") ? 2000000 :
                         category.contains("Gold") ? 1500000 : 1000000;
       int total = ticketCount * ticketPrice;
   
       String receipt = "==== Struk Pembelian Tiket ====" +
               "\nNama: " + name +
               "\nKonser: " + concert +
               "\nKategori: " + category +
               "\nJumlah Tiket: " + ticketCount +
               "\nTotal Harga: Rp " + total ;
   
       receiptArea.setText(receipt);
       primaryStage.setScene(receiptScene);
   });
    
     changePaymentButton.setOnAction(e -> primaryStage.setScene(paymentScene));
     cancelOrderButton.setOnAction(e -> primaryStage.setScene(ticketScene));

     backToTicketButton.setOnAction(e -> primaryStage.setScene(ticketScene));
     backToPaymentButton.setOnAction(e -> primaryStage.setScene(paymentScene));
     backToLoginButton.setOnAction(e -> primaryStage.setScene(loginScene));

        // Login Button Action
        loginButton.setOnAction(e -> {
            String email = emailField.getText();
            String password = passwordField.getText();

            if (userDatabase.containsKey(email) && userDatabase.get(email).equals(password)) {
                primaryStage.setScene(ticketScene);
                primaryStage.setTitle("Aplikasi Tiket Konser");
            } else {
                loginMessage.setText("Email atau Password salah!");
            }
        });

        // Register Button Action
        registerButton.setOnAction(e -> primaryStage.setScene(registerScene));

        // Back to Login Button Action
        backToLoginButton.setOnAction(e -> primaryStage.setScene(loginScene));

        // Submit Register Button Action
        submitRegisterButton.setOnAction(e -> {
            String email = regEmailField.getText();
            String password = regPasswordField.getText();
            String confirmPassword = confirmPasswordField.getText();

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                registerMessage.setText("Semua field harus diisi!");
                return;
            }

            if (!password.equals(confirmPassword)) {
                registerMessage.setText("Password dan konfirmasi tidak cocok!");
                return;
            }

            if (userDatabase.containsKey(email)) {
                registerMessage.setText("Email sudah terdaftar!");
                return;
            }

            userDatabase.put(email, password);
            registerMessage.setText("Registrasi berhasil!");
            primaryStage.setScene(loginScene);
        });

        // Set Initial Scene
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login Aplikasi Tiket Konser");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
