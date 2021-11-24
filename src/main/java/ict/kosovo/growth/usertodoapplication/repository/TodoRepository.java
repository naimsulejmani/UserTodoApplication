package ict.kosovo.growth.usertodoapplication.repository;

import ict.kosovo.growth.usertodoapplication.models.TodoItem;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoRepository extends DataConnection implements CrudRepository<TodoItem, Integer>, ToObjectable<TodoItem> {

    private static TodoRepository instance = new TodoRepository();

    public static TodoRepository getInstance() {
        return instance;
    }

    private TodoRepository() {

    }

    @Override
    public boolean add(TodoItem item) {
        String query = "INSERT INTO dbo.TodoItems ( Name, Description, Deadline, isFinished, Color) VALUES (?,?,?,?,?)";
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
                statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDate(3, new Date(item.getDeadline().toEpochDay()));
            statement.setBoolean(4, item.isFinished());
            statement.setString(5, item.getColor().toString());
            return statement.executeUpdate() >= 0;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(TodoItem item) {
        return false;
    }

    @Override
    public boolean delete(TodoItem item) {
        return false;
    }

    @Override
    public boolean deleteById(Integer key) {
        return false;
    }

    @Override
    public TodoItem getById(Integer key) {
        return null;
    }

    @Override
    public List<TodoItem> getAll() {
        try (
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM dbo.TodoItems")
        ) {
            List<TodoItem> items = null;
            ResultSet resultSet = statement.executeQuery();
            items = new ArrayList<>();
            while (resultSet.next()) {
                items.add(toObject(resultSet));
            }

            return items;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public TodoItem toObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        String name = resultSet.getNString("Name");
        String description = resultSet.getNString("Description");
        LocalDate deadline = resultSet.getDate("deadline").toLocalDate();
        boolean isFinished = resultSet.getBoolean("IsFinished");
        Color color = null;
        if (resultSet.getString("Color") != null) {
            color = Color.valueOf(resultSet.getString("Color"));
        }

        return new TodoItem(id, name, description, deadline, isFinished, color);
    }
}
