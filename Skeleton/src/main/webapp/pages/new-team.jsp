<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />


<h1>Create a Team here</h1>


<form:form method="post" modelAttribute="createTeam" action="createTeam" id="createTeam" cssClass="form-horizontal"  autocomplete="off">
    <fieldset>
        <legend>Enter the Team Information</legend>

        <c:set var="teamNameErrors"><form:errors path="teamName"/></c:set>
        <div class="control-group<c:if test="${not empty teamNameErrors}"> error</c:if>">
            <label class="control-label" for="field-teamName">Team Name</label>
            <div class="controls">
                <form:input path="teamName" id="field-teamName" tabindex="2" maxlength="35" placeholder="Team Name"/>
                <form:errors path="teamName" cssClass="help-inline" element="span"/>
            </div>
        </div>

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Create Team</button>
            <button type="button" class="btn">Cancel</button>
        </div>
    </fieldset>
</form:form>




	<c:if test="${page_error != null }">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Error!</h4>
                ${page_error}
        </div>
    </c:if>


<c:import url="template/footer.jsp" />
