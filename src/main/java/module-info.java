module com.shevliakov.upsbatterycalculator {
  requires javafx.controls;
  requires javafx.fxml;
  requires MaterialFX;
  requires jakarta.persistence;
  requires org.hibernate.orm.core;
  requires mysql.connector.j;
  requires lombok;

  opens com.shevliakov.upsbatterycalculator to javafx.fxml;
  exports com.shevliakov.upsbatterycalculator;
}