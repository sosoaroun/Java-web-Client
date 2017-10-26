<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ynov.bank.language.lang" />

<form>
   <select id="language" name="language" onchange="submit()">
       <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
       <option value="fr" ${language == 'fr' ? 'selected' : ''}>Francais</option>
       <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
   </select>
</form>
        
<fmt:message key="amount"/>

<!DOCTYPE html>
<html lang="${language}">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${name}</title>
    </head>
    <body>
        <div class="container" style="margin-top: 80px;">