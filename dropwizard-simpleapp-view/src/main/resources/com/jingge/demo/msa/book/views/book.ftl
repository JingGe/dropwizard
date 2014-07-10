<!DOCTYPE html>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<table class="table table-bordered">
    <tr>
        <th>ID</th>
        <th>ISDN</th>
        <th>Name</th>
        <th>Description</th>
        <th>Edition</th>
    </tr>
    <tr class="success">
        <td>${book.id?html}</td>
        <td>${book.isdn?html}</td>
        <td>${book.name?html}</td>
        <td>${book.description?html}</td>
        <td>${book.edition?html}</td>
    </tr>
</table>

</body>
</html>
