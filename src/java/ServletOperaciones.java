/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.*;

/**
 *
 * @author HP-PC
 */
public class ServletOperaciones extends HttpServlet {
    double NUMERO1, NUMERO2=0, k=1;
    double RESU=0;
    
    String OPERACION, MSJ="";
    
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
        response.setContentType("text/html;charset=UTF-8");
        NUMERO1=Integer.parseInt(request.getParameter("numero1"));
        NUMERO2=Integer.parseInt(request.getParameter("numero2"));
        OPERACION=request.getParameter("operacion");
        
        
        if(OPERACION.equals("+")){
            RESU=NUMERO1+NUMERO2;
            MSJ="";
        }
        else
        if(OPERACION.equals("-")){
            RESU=NUMERO1-NUMERO2;
            MSJ="";
            
        }
        else
        if(OPERACION.equals("*")){
            RESU=NUMERO1*NUMERO2;
            MSJ="";
        }
        else
        if(OPERACION.equals("/")){
            if((NUMERO2==0)){
                MSJ="UN NUMERO NO SE PUEDE DIVIDIR ENTRE 0";
                RESU=0;}
            else
            RESU=NUMERO1/NUMERO2;
            MSJ="";
            
        }
        else
        if(OPERACION.equals("sen")){
            RESU=(Math.sin(Math.toRadians(NUMERO1)));
            MSJ="";

        }
        else
        if(OPERACION.equals("cos")){if(NUMERO1==90 || NUMERO2==270)
            {RESU=0;
                MSJ="El COSENO DE 90 O 270 SE INDETERMINA";}
        else{
            
             RESU=(Math.cos(Math.toRadians(NUMERO1)));
             MSJ="";}
        }
        else
        if(OPERACION.equals("tan")){
            if(NUMERO1==90 || NUMERO2==270)
            {RESU=0;
                MSJ="LA TANGENTE DE 90 O 270 SE INDETERMINA";}
            else{
             RESU=(Math.tan(Math.toRadians(NUMERO1)));
             MSJ="";}
        }
        else
        if(OPERACION.equals("potencia")){
            if(NUMERO2==0)
            {RESU=1;
            MSJ="";}
            else
            {
                RESU=Math.pow(NUMERO1, NUMERO2);
                MSJ="";
            }
        }
        else
        if(OPERACION.equals("cuadrado")){
            RESU=NUMERO1*NUMERO1;
            MSJ="";
        }
        else
        if(OPERACION.equals("doble")){
            RESU=NUMERO1+NUMERO1;
            MSJ="";
        }
        else if(OPERACION.equals("")){
            RESU=0;
            MSJ="SELECCIONE UNA OPERACION";
        }
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<link rel='stylesheet' href='MiCSS.css'>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletOperaciones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado:" +RESU+ "</h1>");
            out.println("<h2>" +MSJ+ "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
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
