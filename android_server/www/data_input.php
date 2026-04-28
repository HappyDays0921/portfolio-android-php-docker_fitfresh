data_input
<?php

//$con=mysqli_connect("localhost","computernano","computer2024!","computernano");
$con = mysqli_connect("db","user","password","appdb");
mysqli_query($con,'SET NAMES utf8');

$name = $_POST["name"];
$test_time = $_POST["time"];
$age = $_POST["age"];
$carbo = $_POST["carbo"];
$protein = $_POST["protein"];
$fat = $_POST["fat"];

/*$name="jiu";
$time="2";
$age="2";
$carbo="0.21";
$protein="1.5";
$fat="21.5";*/

//데이터 넣으려는 test
/*$input_Data = mysqli_prepare($con,"INSERT INTO test_input VALUES(?,?,?,?,?,?)");
mysqli_stmt_bind_param($input_Data,"ssssss",$name,$time,$age,$carbo,$protein,$fat);*/
//$vitamin,$calcium,$pho,$iron,$na,$potassium);

//mysqli_stmt_execute($input_Data);
//$response=array();

/* $statement = mysqli_prepare($con,"INSERT INTO tst0316 VALUE(?,?,?,?,?,?)");
mysqli_stmt_bind_param($statement,"ssssss",$name,$time,$age,$carbo,$protein,$fat);
mysqli_stmt_execute($statement); */
//echo json_encode($response);

$statement=mysqli_prepare($con,"INSERT INTO test_input VALUES (?,?,?,?,?,?)");
mysqli_stmt_bind_param($statement,"ssssss",$name,$test_time,$age,$carbo,$protein,$fat) or die(mysqli_error($con));
mysqli_stmt_execute($statement) or die(mysqli_error($con));;

?>