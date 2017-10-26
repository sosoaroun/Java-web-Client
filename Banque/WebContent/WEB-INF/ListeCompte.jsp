<%@include file="header.jsp" %>


<a href="Name"> <input type="button" value="Retour Client"> </a>
	<p>Liste des comptes de ${client.nom} ${client.prenom}</p>
	<div>
	
		<table border="1">
        <tr>
            <td>Numero</td>
            <td>libelle</td>
            <td>clientID</td>
            <td>Nombre de transaction</td>
        </tr>
        <c:forEach var="compte" items="${client.comptes}">
			<tr>
	     		<td>${compte.numero}</td>
		        <td>${compte.libelle}</td>
				<td>${compte.client}</td>
				<td>${compte.transactions.size()}</td>
				<td><a href="ServletTransaction?id=${compte.numero}">Voir les transactions</a></td>
			</tr>        
        </c:forEach>
    </table> 		
    
   	<form name="formCompte" method="post" action="AfficheCompte?id=${client.clientID}">
		Libelle du Compte : <input type="text" name="libelle">
		<input type="submit">
	</form>


	</div>
<%@include file="footer.jsp" %>