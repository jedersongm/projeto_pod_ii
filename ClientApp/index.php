<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        // put your code here
        ?>
        <h3>Seridó Mania</h3>
        <form action="cadastro.php" method="POST">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required/>
            <br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required/>
            <br>
            <button type="submit" value="Cadastrar">Cadastar</button>
        </form>
    </body>
</html>
