/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lyntk.dao.AccountDao;
import lyntk.dao.impl.AccountDaoImpl;
import lyntk.models.Account;
import lyntk.utils.EncryptionUtil;

/**
 *
 * @author Dell
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private static final String ERROR_PAGE = "register.jsp";
    private static final String SUCCESS_PAGE = "login.jsp";
    private static final int ADMIN = 1;
    private static final int USER = 2;

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
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            if (password.equals(confirmPassword)) {
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                int roleId = USER;
                boolean activeStatus = true;
                AccountDao accountDao = new AccountDaoImpl();
                Account account = accountDao.findAccountByEmail(email);
                if (account == null) {
                    account = new Account(email, EncryptionUtil.encrypt(password), username, roleId, activeStatus);
                    accountDao.save(account);
                    url = SUCCESS_PAGE;
                } else {
                    request.setAttribute("WARNING", "Email has been registered");
                }
            } else {
                request.setAttribute("WARNING", "Password is not matching");
            }
        } catch (Exception e) {
            log("Error at RegisterController: " + e);
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
