package org.riwi.models;

import org.riwi.entities.inscription;
import org.riwi.persistence.configDB.MySQLConfig;
import org.riwi.persistence.imodel.IModelInscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class modelInscription implements IModelInscription {
    @Override
    public inscription create(inscription request){
        Connection connect = MySQLConfig.connectDatabase();
        String sqlQuery = "INSERT INTO inscriptions (id_course, id_student) values(?,?)";

        inscription inscription1 = new inscription();
        try{
            PreparedStatement preparedStatement = connect.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, request.getId_Course());
            preparedStatement.setInt(2, request.getId_Student());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException(error.getMessage());
        }

        return inscription1;
    }

    @Override
    public inscription update(String query){
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
    public List<inscription> readAll(int size, int numberPage) {
        List<inscription> coursesEntities = new ArrayList<>();
        Connection connection = MySQLConfig.connectDatabase();
        try{
            String sql = "SELECT * FROM inscriptions LIMIT ? OFFSET ?; ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, size);
            preparedStatement.setInt(2, (numberPage-1)*size);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                inscription eachCourse = new inscription(
                        resultSet.getInt("id_course"),
                        resultSet.getInt("id_student")
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
