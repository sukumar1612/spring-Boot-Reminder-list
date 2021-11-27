<html>

<head>
    <title>Input Box</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">

</head>

<body>
    <!---------------Main Box-->
    <div class="container">
        <div class="todoBlock">
            <!-- main title holder -->
            <div class="titleHolder">
                <h1>To Do List</h1>
            </div>
            <!-- todo list -->
            <div class="todoList">
                <!-- list holder -->
                <div class="listHolder" id="listHolder">
                    <ul class="list" id="lists">
                        <!-----------GetValue by Javascript-->
                    </ul>
                </div>
                <!-- form holder -->
                <div class="formHolder">
                    <div class="col big">
                        <input type="text" id="addInput" required>
                    </div>
                    <div class="col">
                        <button type="button" id="addBtn" class="btn-primary">Add Item</button>
                    </div>
                    <div class="col">
                        <button type="button" id="removeBtn" class="btn-primary">Hide List</button>
                    </div>
                    <form action="logout">
                        <div class="col">
                            <button type="submit" id="removeBtn" class="btn-primary">Logout</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="myscript.js"></script>
</body>

</html>