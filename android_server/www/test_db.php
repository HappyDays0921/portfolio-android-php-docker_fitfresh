test_db
<?php

$con = mysqli_connect("localhost", "computernano", "computer2024!", "computernano");
mysqli_query($con,'SET NAMES utf8');


//데이터삽입부분
$userID = $_POST["ID"];
$userPassword = $_POST["PW"];
$input_Data = mysqli_prepare($con, "INSERT INTO login_test VALUES(?,?)");


//데이터 삽입부분
//$userID = "asdf";
//$userPassword = "qwe";
//$input_Data = mysqli_prepare($con, "INSERT INTO login_test VALUES(?,?)");

mysqli_stmt_bind_param($input_Data,"ss",$userID,$userPassword);
mysqli_stmt_execute($input_Data);

$response=array();
$response["success"]=true;

echo json_encode($response);


?>