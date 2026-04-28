<?php


$con=mysqli_connect("localhost","computernano","computer2024!","computernano");
mysqli_query($con,'SET NAMES utf8');

$name=$_POST["name"];
$carbo=$_POST["carbo"];
$protein=$_POST["protein"];
$fat=$_POST["fat"];
$meal=$_POST["meal"];
$age=$_POST["age"];


$statement=mysqli_prepare($con,"INSERT INTO USER VALUES (?,?,?,?,?,?)");
mysqli_stmt_bind_param($statement,"ssssss",$name,$carbo,$protein,$fat,$meal,$age);
mysqli_stmt_execute($statement);

$response=array();
$response["success"]=true;

echo json_encode($response);


?>