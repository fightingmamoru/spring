<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>File Upload by ajax Test</title>

	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery-1.8.3.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/jquery/jquery.form.min.js"/>"></script>

	<script type="text/javascript">

		function fnSave()
		{
			$("#updateForm").ajaxForm({
				success : function(result) {
					alert('성공');
				},
				error : function(e) {
					alert('에러');
				}
			});

			$("#updateForm").attr('action', '/helloMyBatis/updateFormAjax').submit();

		}
	</script>
</head>
<body>
	<h2>File Upload by ajax Test</h2>
	<form:form  id="updateForm" name="updateForm" method="post" enctype="multipart/form-data">
		<div>
			seq <input id="seq" name="seq" type="text" />
			<br/>
			title <input id="title" name="title" type="text" />
			<br/>
			file <input id="uploadFile" name="uploadFile" type="file" />
			<br/>
		</div>
	</form:form>

	<input type="button"id="btnSave" onclick="fnSave();" value="업로드">
</body>
</html>
