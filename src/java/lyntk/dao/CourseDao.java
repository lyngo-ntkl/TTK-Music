/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.dao;

import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import lyntk.models.Course;

/**
 *
 * @author Dell
 */
public interface CourseDao {
    boolean save(Course course) throws SQLException, NamingException;
    List<Course> search(String searchKey, String type) throws SQLException, NamingException;
    List<Course> searchByCourseNameOrderByStartedDateForPagination(String searchKey, int offset, int numberOfRecords) throws SQLException, NamingException;
}
