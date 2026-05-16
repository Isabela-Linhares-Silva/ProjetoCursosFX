module com.aula.projetocursosfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;

    opens com.aula.projetocursosfx to javafx.fxml;
    exports com.aula.projetocursosfx;
    exports com.aula.projetocursosfx.controller;
    opens com.aula.projetocursosfx.controller to javafx.fxml;
}