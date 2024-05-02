module net.wermann.observerpatterndemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.wermann.observerpatterndemo.controller to javafx.fxml;
    exports net.wermann.observerpatterndemo;
}