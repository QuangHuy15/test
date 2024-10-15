<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        display: flex;
        justify-content: space-between; /* Distribute items to left and right */
        align-items: center; /* Vertically center the items */
        padding: 20px; /* Add some padding to the body */
    }
    
    .left-content {
        font-size: 20px;
        font-weight: bold;
    }
    
    button {
        height: 50px;
        width: 300px;
        outline: none;
        border: 1px solid #dadce0;
        padding: 10px;
        border-radius: 5px;
        font-size: inherit;
        color: #202124;
        transition: all 0.3s ease-in-out;
        cursor: pointer;
    }
</style>
</head>
<body>
	<div class="left-content">
		Trang chủ của admin
	</div>

	<button type="button" id="btn-logout"
		onclick="window.location.href='${pageContext.request.contextPath}/logout'">Logout</button>

</body>
</html>