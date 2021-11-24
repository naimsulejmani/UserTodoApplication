module ict.kosovo.growth.usertodoapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;


    opens ict.kosovo.growth.usertodoapplication to javafx.fxml;
    opens ict.kosovo.growth.usertodoapplication.models to javafx.base;
    opens ict.kosovo.growth.administring to javafx.fxml;
    exports ict.kosovo.growth.usertodoapplication;
}