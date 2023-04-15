<%@ page errorPage = "Qno10ErrorPage.jsp" %>

<html>
   <head>
      <title>Error Handling Example</title>
   </head>
   <body>
      <%
         // Throw an exception to invoke the custom error page
         int x = 5 / 0;
      %>
   </body>
</html>