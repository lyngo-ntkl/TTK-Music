/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lyntk.dao.AccountDao;
import lyntk.dao.impl.AccountDaoImpl;
import lyntk.models.Account;

/**
 *
 * @author Dell
 */
@WebServlet(name = "LoginUsingCookieController", urlPatterns = {"/LoginUsingCookieController"})
public class LoginUsingCookieController extends HttpServlet {

    private static final String ERROR_PAGE = "login.jsp";
    private static final int ADMIN = 1;
    private static final String ADMIN_PAGE = "";
    private static final int USER = 2;
    private static final String USER_PAGE = "dashboard.jsp";

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
            Cookie[] cookies = request.getCookies();
            String email = "";
            String password = "";
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("email")){
                    email = cookie.getValue();
                }
                if(cookie.getName().equals("password")){
                    password = cookie.getValue();
                }
            }
            AccountDao accountDao = new AccountDaoImpl();
            Account account = accountDao.findAccountByEmailAndPassword(email, password);
            if (account != null) {
                account.setPassword("***");
                HttpSession session = request.getSession();
                session.setAttribute("USER", account);
                if(ADMIN == account.getRoleId()){
                    url = ADMIN_PAGE;
                } else if (USER == account.getRoleId()){
                    url = USER_PAGE;
                }
            }
        } catch (Exception e) {
            log("Error at LoginUsingCookieController: " + e);
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
