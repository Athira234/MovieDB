<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style type="text/css">
body {
	counter-reset: Serial;
}

table {
	border-collapse: separate;
}

tr td:first-child:before {
	counter-increment: Serial;
	content: counter(Serial);
}
</style>
<body>
	<center>
		<U>WATCH LIST</U> <br> <br> 
		<table border=1>
			<th>Sl.No</th>
			<th>Movie Name</th>
			<th>Date Added</th>
			<c:forEach items="${movies}" var="movies" varStatus="status">
					<tr>
					<td></td>
					<td><c:out value="${movies.movieTitle}" /></td>
					<td><c:out value="${watchList[status.index].dateAdded}" /></td>
				</tr>
          </c:forEach>
			
		</table>
		<A href="watchlist/items">Add Movie to WatchList</A><br><br>
		 
		</center>
</body>

</html>