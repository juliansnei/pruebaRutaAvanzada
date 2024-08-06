package org.riwi.models;

import org.riwi.persistence.imodel.IModelStudent;
import org.riwi.entities.student;
import org.riwi.persistence.configDB.MySQLConfig;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class modelStudent implements IModelStudent {
    @Override
    public student create(student request){
        Connection connect = MySQLConfig.connectDatabase();
        String sqlQuery = "INSERT INTO student (age,name,email,status) values(?,?,?,?)";

        student student1 = new student();
        try{
            PreparedStatement preparedStatement = connect.prepareStatement(sqlQuery);

            preparedStatement.setDouble(1,request.getAge());
            preparedStatement.setString(2, request.getName());
            preparedStatement.setString(3, request.getEmail());
            preparedStatement.setBoolean(4,request.isStatus());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }

        return student1;
    }

    @Override
    public student update(String query){
        Connection connect = MySQLConfig.connectDatabase();
        try{
            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }
        return null;
    }

    @Override
    public List<student> readAll(int size, int numberPage) {
        List<student> studentEntities = new ArrayList<>();
        Connection connection = MySQLConfig.connectDatabase();
        try{
            String sql = "SELECT * FROM student LIMIT ? OFFSET ?; ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, size);
            preparedStatement.setInt(2, (numberPage-1)*size);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                student eachStudent = new student(
                        resultSet.getDouble("age"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("status")
                );
                studentEntities.add(eachStudent);
            }
            preparedStatement.close();
            resultSet.close();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return studentEntities;

    }
}
