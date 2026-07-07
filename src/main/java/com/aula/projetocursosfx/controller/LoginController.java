package com.aula.projetocursosfx.controller;

import com.aula.projetocursosfx.db.DB;
import com.aula.projetocursosfx.model.dao.UsuarioDao;
import com.aula.projetocursosfx.model.dao.impl.UsuarioDaoJDBC;
import com.aula.projetocursosfx.model.entities.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailLogin;

    @FXML
    private PasswordField senhaLogin;

    @FXML
    private Rectangle cardLogin;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView imagemFundo;

    @FXML
    private void onCadastrarTelaClicked() throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/aula/projetocursosfx/controller/cadastro-view.fxml"));

        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    private void onLoginClicked() throws IOException {

        String email = emailLogin.getText().trim();
        String senha = senhaLogin.getText().trim();

        UsuarioDao dao = new UsuarioDaoJDBC(DB.getConnection());

        Usuario usuario = dao.autenticar(email, senha);

        if (usuario != null) {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/aula/projetocursosfx/controller/main-view.fxml"));

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 1200, 700));
            stage.setTitle("AcademiSys");
            stage.show();

        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("E-mail ou senha inválidos.");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() {

        DropShadow shadow = new DropShadow();
        shadow.setRadius(25);
        shadow.setOffsetY(6);
        shadow.setColor(Color.rgb(0, 0, 0, 0.25));

        cardLogin.setEffect(shadow);

        imagemFundo.fitHeightProperty().bind(root.heightProperty());

        imagemFundo.fitWidthProperty().bind(root.widthProperty().subtract(770));
    }

    @FXML
    private void mouseEntrouBotao() {
        loginButton.setStyle(
                "-fx-background-color:#1D4ED8;" +
                        "-fx-background-radius:8;" +
                        "-fx-cursor: hand;"
        );

        loginButton.setCursor(Cursor.HAND);
    }

    @FXML
    private void mouseSaiuBotao() {
        loginButton.setStyle(
                "-fx-background-color:#2563EB;" +
                        "-fx-background-radius:8;"
        );

        loginButton.setCursor(Cursor.DEFAULT);
    }
}