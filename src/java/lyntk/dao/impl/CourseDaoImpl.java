/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import lyntk.dao.CourseDao;
import lyntk.models.Course;
import lyntk.utils.DatabaseUtil;

/**
 *
 * @author Dell
 */
public class CourseDaoImpl implements CourseDao {
    private static final String SEARCH_BY_COURSE_NAME = "SELECT course_id, course_name, description FROM courses WHERE course_name LIKE ?";
    private static final String SEARCH_BY_COURSE_NAME_ORDER_BY_STARTED_DATE_FOR_PAGINATION = 
            "SELECT course_id, course_name, image, description, tuition_fee, category_id, quantity, created_date, started_date, ended_date, last_updated_date, last_updated_user_id, active_status "
            + "FROM courses "
            + "WHERE course_name LIKE ? "
            + "ORDER BY started_date "
            + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    private static final String SEARCH_BY_CATEGORY = "SELECT course_id, course_name, description FROM courses WHERE category_id = ?";
    private static final String SAVE = "INSERT INTO courses(course_id, course_name, image, description, tuition_fee, category_id, quantity, created_date, started_date, ended_date, last_updated_date, last_updated_user_id, active_status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    @Override
    public List<Course> search(String searchKey, String type) throws SQLException, NamingException{
        List<Course> result = null;
        if("Category".equals(type)){
            result = searchByCategory(searchKey);
        } else {
            result = searchByCourseName(searchKey);
        }
        return result;
    }
    
    private List<Course> searchByCourseName(String searchKey) throws SQLException, NamingException{
        List<Course> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseUtil.getDatabaseConnection();
            if(connection != null){
                preparedStatement = connection.prepareStatement(SEARCH_BY_COURSE_NAME);
                preparedStatement.setString(1, "%" + searchKey + "%");
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    
                }
            }
        } finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return result;
    }
    
    private List<Course> searchByCategory(String searchKey) throws SQLException, NamingException{
        List<Course> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseUtil.getDatabaseConnection();
            if(connection != null){
                preparedStatement = connection.prepareStatement(SEARCH_BY_CATEGORY);
                preparedStatement.setString(1, searchKey);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    
                }
            }
        } finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return result;
    }
    
    public List<Course> searchByCourseNameOrderByStartedDateForPagination(String searchKey, int offset, int numberOfRecords) throws SQLException, NamingException{
        List<Course> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseUtil.getDatabaseConnection();
            if(connection != null){
                preparedStatement = connection.prepareStatement(SEARCH_BY_COURSE_NAME_ORDER_BY_STARTED_DATE_FOR_PAGINATION);
                preparedStatement.setString(1, "%" + searchKey + "%");
                preparedStatement.setInt(1, offset);
                preparedStatement.setInt(1, numberOfRecords);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    
                }
            }
        } finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return result;
    }
    
    @Override
    public boolean save(Course course) throws SQLException, NamingException{
        boolean check = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DatabaseUtil.getDatabaseConnection();
            if(connection != null){
                preparedStatement = connection.prepareStatement(SAVE);
                preparedStatement.setString(1, course.getCourseId());
                preparedStatement.setString(2, course.getCourseName());
                preparedStatement.setString(3, course.getImage());
                preparedStatement.setString(4, course.getDescription());
                preparedStatement.setBigDecimal(5, course.getTuitionFee());
                preparedStatement.setInt(6, course.getCategoryId());
                preparedStatement.setInt(7, course.getQuantity());
                preparedStatement.setObject(8, course.getCreatedDate());
                preparedStatement.setObject(9, course.getStartedDate());
                preparedStatement.setObject(10, course.getEndedDate());
                preparedStatement.setObject(11, course.getLastUpdatedDate());
                preparedStatement.setString(12, course.getLastUpdatedUserId());
                preparedStatement.setBoolean(13, course.isActive());
                check = preparedStatement.executeUpdate() > 0;
            }
        } finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return check;
    }
}
