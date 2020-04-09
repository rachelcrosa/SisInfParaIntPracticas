<%--author: rachelcrosa  --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Practica 2 - Ejercicio 2</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
      <form action ="p2ej2.jsp" method="get">
        Numero:<input type="text" name="numero"><br>
        <br>
        <input type="submit" value="calcular">
        <%
            String cadena = request.getParameter("numero");
        %>
        <% try{

              int valor = Integer.parseInt(cadena);
            if (valor < 0 ) throw new NumberFormatException();%>
              <table border="1" style="margin: 0 auto;">
                <% out.print("<tr bgcolor=black><td><font color=white><b>Divisores de " + valor + "</b></font></td></tr>");
                        for(int i = 1; i <= valor; i++){
                          if(valor%i==0){
                            out.print("<tr><td><center>" + i + "</center></td></tr>");
                          }
                        }%>
              </table>
              <%}catch(NumberFormatException e){%>
                <br><br>
                <p>El dato introducido no es válido</p>
              <%}%>
       </form>
    </body>
</html>
