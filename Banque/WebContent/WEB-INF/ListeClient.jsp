<%@include file="header.jsp" %>
	<p>BADOW BADOW BADOW BENG</p>
	<div>
		<p>Nom du client : 
			<c:out value="${name}" />
		</p>
		<p>Nom du client :  ${prenom} </p>
		
		<p>Les clients :  ${liste_c.get(1)} </p>
		
		<table border="1">
        <tr>
            <td>ID Client</td>
            <td>nom</td>
            <td>prenom</td>
            <td>login</td>
            <td>mdp</td>
        </tr>
        <c:forEach var="client" items="${liste_c}">
            <tr>      
                <td>${client.clientID}</td>
                <td>${client.nom}</td>
                <td>${client.prenom}</td>
                <td>${client.login}</td> 
                <td>${client.passwd}</td>
                <td><a href="AfficheCompte?id=${client.clientID}">Voir les comptes</a></td> 
            </tr>
        </c:forEach>
    </table> 
		
	</div>
<%@include file="footer.jsp" %>