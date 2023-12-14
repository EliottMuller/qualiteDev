<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulaire de création d'utilisateur</title>
<link rel="stylesheet" href="/_00_ASBank2023/style/style.css" />
<script src="/_00_ASBank2023/js/jquery.js"></script>
<script src="/_00_ASBank2023/js/jsChangementPwd.js"></script>
</head>

<body>

	<div class="btnLogout">
		<s:form name="myForm" action="logout" method="POST">
			<s:submit name="Retour" value="Logout" />
		</s:form>
	</div>
	<h1>Changer de mot de passe</h1>
	<s:form id="myForm" name="myForm" action="ajoutUtilisateur"
		method="POST">
		<s:textfield label="Ancien mot de passe" name="oldPwd" />
		<s:textfield label="Nouveau mot de passe" name="newPwd" disabled="true" />
		<s:textfield label="Confirmer le mot de passe" name="newPwdConf" disabled="true" />
		<s:submit name="submit" disabled="true" />
	</s:form>
	<s:form name="myForm" action="retourTableauDeBordManager" method="POST">
		<s:submit name="Retour" value="Retour" />
	</s:form>

	<s:if test="(result == \"SUCCESS\")">
		<div class="success">
			<s:property value="message" />
		</div>
	</s:if>
	<s:else>
		<div class="failure">
			<s:property value="message" />
		</div>
	</s:else>
</body>
<jsp:include page="/JSP/Footer.jsp" />
</html>