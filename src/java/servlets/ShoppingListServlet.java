package servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author 808360
 */

public class ShoppingListServlet extends HttpServlet {
    
    ArrayList<String> arrItems = new ArrayList<>(); 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Hello doGet method");
        
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        System.out.println("01.GET_GetAction : " + action);
        
        if (action != null && action.equals("logout")) {
            System.out.println("02.GET_ActionNotNull : " + action);
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/ShoppingList");
            //getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        System.out.println("Bye end of doGet method");
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("Hello doPost method");
        
        HttpSession session = request.getSession();
                
        String action = request.getParameter("action");
        System.out.println("01.POST_GetAction : " + action);
        
        if(action != null) {
            
            System.out.println("02.POST_ActionOrNotNull : " + action);
            
            switch (action) {
                case "register" : {
                    System.out.println("03. Hello register");
                                        
                    String username = request.getParameter("username");
                    System.out.println("04.POST_GetUsername : " + username);
                    
                    session.setAttribute("username", username);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    
                    break;                    
                }
                
                case "add" : {
                    System.out.println("05. Hello Add");
                    
                    String addItem = request.getParameter("addItem");
                    System.out.println("05.POST_GetAddItem : " + addItem);
                    
                    arrItems.add(addItem);
                        
                    session.setAttribute("arrItems", arrItems);
                    System.out.println("06.POST_SetSessionArrItems : " + session.getAttribute("arrItems"));
                        
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    
                    break;
                }
                
                case "delete" : {
                    System.out.println("07. Hello Delete");
                    
                    String deleteItem = request.getParameter("deleteItem");
                    System.out.println("08.POST_GetDeleteItem : " + deleteItem);
                    
                    int index = arrItems.indexOf(deleteItem);
                    System.out.println("09.POST_GetIndexOf : " + index);
                    
                    arrItems.remove(index);
                    System.out.println("10.POST_GetSessionArrItems : " + session.getAttribute("arrItems"));
                    
                    session.setAttribute("arrItems", arrItems);
                    getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                    
                    break;
                }                
            } 
        }
    }
}
