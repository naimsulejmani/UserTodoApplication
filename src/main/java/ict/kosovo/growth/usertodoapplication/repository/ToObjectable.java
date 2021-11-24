package ict.kosovo.growth.usertodoapplication.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ToObjectable<T> {
    T toObject(ResultSet resultSet) throws SQLException;
}
