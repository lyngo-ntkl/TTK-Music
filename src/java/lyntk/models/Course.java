/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

/**
 *
 * @author Dell
 */
public class Course {
    private final String courseId;
    private String courseName;
    private String image;
    private String description;
    private BigDecimal tuitionFee;
    private int categoryId;
    private Timestamp createdDate;
    private Date startedDate;
    private Date endedDate;
    private Timestamp lastUpdatedDate;
    private String lastUpdatedUserId;
    private int quantity;
    private boolean active;

    public Course() {
        this.courseId = UUID.nameUUIDFromBytes((this.courseName + this.createdDate).getBytes()).toString();
    }

    public Course(String courseId) {
        this.courseId = courseId;
    }

    public Course(String courseName, String image, String description, BigDecimal tuitionFee, int categoryId, Timestamp createdDate, Date startedDate, Date endedDate, Timestamp lastUpdatedDate, String lastUpdatedUserId, int quantity, boolean active) {
        this.courseId = UUID.nameUUIDFromBytes((this.courseName + this.createdDate).getBytes()).toString();
        this.courseName = courseName;
        this.image = image;
        this.description = description;
        this.tuitionFee = tuitionFee;
        this.categoryId = categoryId;
        this.createdDate = createdDate;
        this.startedDate = startedDate;
        this.endedDate = endedDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedUserId = lastUpdatedUserId;
        this.quantity = quantity;
        this.active = active;
    }

    public Course(String courseId, String courseName, String image, String description, BigDecimal tuitionFee, int categoryId, Timestamp createdDate, Date startedDate, Date endedDate, Timestamp lastUpdatedDate, String lastUpdatedUserId, int quantity, boolean active) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.image = image;
        this.description = description;
        this.tuitionFee = tuitionFee;
        this.categoryId = categoryId;
        this.createdDate = createdDate;
        this.startedDate = startedDate;
        this.endedDate = endedDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.lastUpdatedUserId = lastUpdatedUserId;
        this.quantity = quantity;
        this.active = active;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(BigDecimal tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getEndedDate() {
        return endedDate;
    }

    public void setEndedDate(Date endedDate) {
        this.endedDate = endedDate;
    }

    public Timestamp getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedUserId() {
        return lastUpdatedUserId;
    }

    public void setLastUpdatedUserId(String lastUpdatedUserId) {
        this.lastUpdatedUserId = lastUpdatedUserId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
