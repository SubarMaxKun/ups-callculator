module com.shevliakov.upsbatterycalculator {
  requires javafx.controls;
  requires javafx.fxml;
  requires MaterialFX;
  requires jakarta.persistence;
  requires org.hibernate.orm.core;
  requires mysql.connector.j;
  requires lombok;
  requires java.naming;

  opens com.shevliakov.upsbatterycalculator to javafx.fxml;
  opens com.shevliakov.upsbatterycalculator.entity to org.hibernate.orm.core;
  exports com.shevliakov.upsbatterycalculator;
}