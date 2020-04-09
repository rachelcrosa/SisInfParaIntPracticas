/**
 * @author rachelcrosa
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Serverlet"})
public class Serverlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Practica 2 - Ejercicio 1</title>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"Serverlet\" method=\"post\">");
            out.println("<table>");
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<td>DNI: </td>");
            out.println("<td><input type=\"text\" name=\"dni\"></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>NIF: ");
            if(esNumero(request.getParameter("dni"))){
                int numero= Integer.parseInt(request.getParameter("dni"));
                if(numero <= 99999999 && numero >= 0){
                    out.println(numero + " " + letraDni(numero));
                }else{
                  out.println("¡El número introducido es erróneo!");
                }
            }else{
              out.println("¡El parámetro introducido es erróneo!");
            }
            out.println("</td>");
            out.println("<td></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type=\"submit\" value=\"calcular\"></td>");
            out.println("<td></td>");
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    private char letraDni(int num){
        String cadena="TRWAGMYFPDXBNJZSQVHLCKE";
        char c;
        int mod;

        mod=num%23;
        c=cadena.charAt(mod);

        return c;
    }

    private boolean esNumero(String dni){
        try{
            Integer.parseInt(dni);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
