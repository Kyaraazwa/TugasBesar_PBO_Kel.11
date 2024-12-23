import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class LoginAndRegister {

    private Map<String, String> userDatabase = new HashMap<>();
    private Scene loginScene;

    public LoginAndRegister(Stage primaryStage) {
        initializeScenes(primaryStage);
    }

    private void initializeScenes(Stage primaryStage) {
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

        loginScene = new Scene(loginLayout, 400, 300);
    }     

    // Method untuk mendapatkan scene login
    public Scene getLoginScene() {
        return loginScene;
    }


}