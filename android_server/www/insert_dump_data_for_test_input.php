insert_dump_data_for_test_input
<?php
$con = mysqli_connect("localhost","computernano","computer2024!","computernano");
mysqli_query($con,'SET NAMES utf8');

$name = "com";
$time ="1";
$age = "11";
$protein = "76.4";
$carbo = "260.1";
$fat = "60.16";

//
$input_Data = mysqli_prepare($con,"INSERT INTO input VALUE (?,?,?,?,?,?)");
mysqli_stmt_bind_param($input_Data,"ssssss",$name,$time,$age,$carbo,$protein,$fat);

mysqli_stmt_execute($input_Data);

$response= array();
$response["success"]=true;
echo json_encode($response);


?>