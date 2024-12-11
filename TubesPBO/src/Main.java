import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Header
        Label title = new Label("Aplikasi Pemesanan Tiket Konser");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #2E86C1;");

        // Pilihan Konser
        Label concertLabel = new Label("Pilih Konser:");
        ComboBox<String> concertComboBox = new ComboBox<>();
        concertComboBox.getItems().addAll("Konser Coldplay", "Konser BTS", "Konser Taylor Swift");

        // Pilihan Kategori
        Label categoryLabel = new Label("Pilih Kategori Tiket:");
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll("VIP - Rp 2,000,000", "Gold - Rp 1,500,000", "Silver - Rp 1,000,000");

        // Jumlah Tiket
        Label ticketLabel = new Label("Jumlah Tiket:");
        TextField ticketField = new TextField();
        ticketField.setPromptText("Masukkan jumlah tiket");

        // Harga Per Kategori
        Label priceLabel = new Label("Harga Kategori: ");

        // Total Harga
        Label totalLabel = new Label("Total Harga: Rp 0");

        // Tombol Beli
        Button buyButton = new Button("Beli Tiket");
        buyButton.setStyle("-fx-background-color: #1ABC9C; -fx-text-fill: white; -fx-font-weight: bold;");
        buyButton.setOnAction(e -> {
            try {
                // Mengambil jumlah tiket
                int jumlah = Integer.parseInt(ticketField.getText());
                int hargaPerTiket = 0;

                // Menentukan harga berdasarkan kategori
                String selectedCategory = categoryComboBox.getValue();
                if (selectedCategory != null) {
                    if (selectedCategory.contains("VIP")) hargaPerTiket = 2000000;
                    else if (selectedCategory.contains("Gold")) hargaPerTiket = 1500000;
                    else if (selectedCategory.contains("Silver")) hargaPerTiket = 1000000;
                }

                // Mengambil pilihan konser
                String selectedConcert = concertComboBox.getValue();

                // Validasi input
                if (selectedConcert == null || selectedCategory == null) {
                    totalLabel.setText("Pilih konser dan kategori terlebih dahulu!");
                } else {
                    // Hitung total harga
                    int total = jumlah * hargaPerTiket;
                    totalLabel.setText("Total Harga: Rp " + total);
                }
            } catch (NumberFormatException ex) {
                totalLabel.setText("Masukkan jumlah tiket yang tidak valid.");
            }
        });

        // Layout
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
                title,
                concertLabel, concertComboBox,
                categoryLabel, categoryComboBox,
                ticketLabel, ticketField,
                buyButton, priceLabel, totalLabel
        );

        // Scene dan Stage
        Scene scene = new Scene(layout, 450, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aplikasi Tiket Konser");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}