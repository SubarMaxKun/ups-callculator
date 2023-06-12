module com.shevliakov.upsbatterycalculator {
  requires javafx.controls;
  requires javafx.fxml;
  requires MaterialFX;

  opens com.shevliakov.upsbatterycalculator to javafx.fxml;
  exports com.shevliakov.upsbatterycalculator;
}