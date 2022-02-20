
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/JohariWindow//CSS/styles.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Johari window results:</h1>
        <h5>Window ID: ${johari_window_id}</h5>
        
        <div class="divTable" style="border: 1px solid #000;">
	<div class="divTableBody">
		<div class="divTableRow">
			<div class="divTableCell">-------</div>
			<div class="divTableCell">You Know</div>
			<div class="divTableCell">You don't know</div>
		</div>
		<div class="divTableRow">
			<div class="divTableCell">Others know</div>
			<div class="divTableCell">ARENA: ${arena_traits}</div>
			<div class="divTableCell">BLIND SPOT: ${blindspot_traits}</div>
		</div>
		<div class="divTableRow">
			<div class="divTableCell">Others don't know</div>
			<div class="divTableCell">FACADE: ${facade_traits}</div>
			<div class="divTableCell">UNKNOWN </div>
		</div>
	</div>
</div>
    </body>
</html>
