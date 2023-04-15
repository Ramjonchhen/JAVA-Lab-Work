<%@ page isErrorPage = "true" %>

<html>
   <head>
      <title>Show Error Page</title>
   </head>
   <body>
      <h1>Error Occured!!!</h1>
      <h1>Error Message: <%= exception.getMessage() %></h1>
      <p>Here is the exception stack trace: </p>
      <div>
      	<pre>
			<% exception.printStackTrace(response.getWriter()); %>
		</pre>
      </div>
   </body>
</html>