<%@include file="header.jsp" %>
<a href="AfficheCompte?id=${compte.getClient()}"> <input type="button" value="Retour Compte"> </a>
	<div>
	
		<table border="1">
        <tr>
            <td>TransacID</td>
            <td>Date</td>
            <td>Libelle</td>
            <td>Montant Transaction</td>
            <td>compte attache</td>
        </tr>
        		<c:forEach var="transaction" items="${compte.transactions}">
        			<c:if test = "${transaction.compte_t.numero == compte.numero}">
					<tr>
				        <td>${transaction.transacID}</td>
						<td>${transaction.date}</td>
						<td>${transaction.libelle}</td>
						<td>${transaction.montant}</td>
						<td>${compte.numero}</td>
					</tr>
				</c:if>
        </c:forEach>
    </table> 
    

<form name="formTransaction" method="post" action="ServletTransaction?id=${compte.numero}">
Libelle de la transaction : <input type="text" name="libelle">
Montant de la transaction : <input type="number" name="montant">
<input type="submit">
</form>
		
	</div>
<%@include file="footer.jsp" %>