package org.riwi.models;

import org.riwi.entities.course;
import org.riwi.entities.student;
import org.riwi.persistence.configDB.MySQLConfig;
import org.riwi.persistence.imodel.IModelCourse;
import org.riwi.persistence.imodel.IModelStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class modelCourse implements IModelCourse {

    @Override
    public course create(course request){
        Connection connect = MySQLConfig.connectDatabase();
        String sqlQuery = "INSERT INTO courses (name) values(?)";

        course course1 = new course();
        try{
            PreparedStatement preparedStatement = connect.prepareStatement(sqlQuery);

            preparedStatement.setString(1,request.getName());


            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }

        return course1;
    }

    @Override
    public course update(String query){
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
    public List<course> readAll(int size, int numberPage) {
        List<course> coursesEntities = new ArrayList<>();
        Connection connection = MySQLConfig.connectDatabase();
        try{
            String sql = "SELECT * FROM course LIMIT ? OFFSET ?; ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, size);
            preparedStatement.setInt(2, (numberPage-1)*size);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                course eachCourse = new course(
                        resultSet.getString("name")
                );
                coursesEntities.add(eachCourse);
            }
            preparedStatement.close();
            resultSet.close();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return coursesEntities;

    }
}
