/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 829942
 */
public class ShoppingListServlet extends HttpServlet {

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
        
        if(request.getParameter("action") != null){
            if(request.getParameter("action").equals("register")){
                HttpSession session=request.getSession(true);
                session.setAttribute("username", request.getParameter("username"));
                request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
            else if(request.getParameter("action").equals("add")){
                if(request.getParameter("addItem").equals("")){ 
                }
                else{
                    ArrayList<String> array = new ArrayList<String>();
                    if((ArrayList<String>) request.getSession().getAttribute("items") != null){
                        array = (ArrayList<String>) request.getSession().getAttribute("items");
                    }

                    boolean bFind = false;

                    for(int i = 0 ; i < array.size() ; i++){
                        if(array.get(i).equals(request.getParameter("addItem"))){
                            bFind = true;
                            break;
                        }
                    }
                    if(!bFind){
                        array.add(request.getParameter("addItem"));
                    }

                    request.getSession().setAttribute("items", array);
                }
                request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
            else if(request.getParameter("action").equals("delete")){
                ArrayList<String> array = new ArrayList<String>();
                if((ArrayList<String>) request.getSession().getAttribute("items") != null){
                    array = (ArrayList<String>) request.getSession().getAttribute("items");
                }
                array.remove(request.getParameter("radioButton"));
                request.getSession().setAttribute("items", array);
                request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                
            }
            else if(request.getParameter("action").equals("logout")){
                request.getSession().invalidate();
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        }
        else{
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }   
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
 //       request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
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
