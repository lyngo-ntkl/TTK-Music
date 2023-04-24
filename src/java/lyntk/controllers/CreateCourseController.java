/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.controllers;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import lyntk.dao.CourseDao;
import lyntk.dao.impl.CourseDaoImpl;
import lyntk.models.Course;

/**
 *
 * @author Dell
 */
@WebServlet(name = "CreateCourseController", urlPatterns = {"/CreateCourseController"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 2,
        maxRequestSize = 1024 * 1024 * 2 * 3
)
public class CreateCourseController extends HttpServlet {

    private static final String ERROR_PAGE = "error.html";
    private static final String SUCCESS_PAGE = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR_PAGE;
        try {
            String courseName = request.getParameter("courseName");
            String imagePath = request.getPart("image") != null ? uploadImage(request) : null;
            String description = request.getParameter("description");
            BigDecimal tuitionFee = new BigDecimal(request.getParameter("tuitionFee"));
            int categoryId = Integer.parseInt(request.getParameter("category"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Date startedDate = Date.valueOf(request.getParameter("startedDate"));
            Date endedDate = Date.valueOf(request.getParameter("endedDate"));
            String createdUserId = request.getParameter("createdUserId");
            Timestamp createdDate = Timestamp.valueOf(LocalDateTime.now());
            boolean activeStatus = true;
            Course course = new Course(courseName, imagePath, description, tuitionFee, categoryId, createdDate, startedDate, endedDate, createdDate, createdUserId, quantity, activeStatus);
            CourseDao courseDao = new CourseDaoImpl();
            if (courseDao.save(course)) {
                url = SUCCESS_PAGE;
            }
        } catch (Exception e) {
            log("Error at CreateCourseController: " + e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    private String uploadImage(HttpServletRequest request) throws IOException, ServletException {
        String applicationPath = request.getServletContext().getRealPath("");
        String fileDir = "image";
        String uploadFilePath = applicationPath + File.separator + fileDir;
        File file = new File(uploadFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileAccessPath = null;
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            if (part.getName().equals("image")) {
                String fileName = UUID.randomUUID().toString() + getFileExtension(part);
                fileAccessPath = fileDir + File.separator + fileName;
                part.write(uploadFilePath + File.separator + fileName);
            }
        }
        return fileAccessPath;
    }
    
    private String getFileExtension(Part part) {
        String extension = "";
        String contentDisposition = part.getHeader("content-disposition");
        String[] tokens = contentDisposition.split(";");
        for(String token: tokens){
            if(token.trim().startsWith("filename")){
                extension = token.substring(token.indexOf("."), token.length() - 1);
                break;
            }
        }
        return extension;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
