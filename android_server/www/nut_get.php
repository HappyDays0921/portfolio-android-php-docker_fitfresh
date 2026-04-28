nut_get
<?php
$con = mysqli_connect("localhost","computernano","computer2024!","computernano");
mysqli_query($con,'SET NAMES utf8');

//사용자id
$userID = $_POST[""];
//일
$date =$_POST[""];
//아점저
$meal = $_POST[""];
//1.단백질
$protein = $_POST[""];
//2.탄수화물
$carbo = $_POST[""];
//3.지방
$fat = $_POST[""];
/*
//4.비타민
$vitamin = $_POST[""];
//5.칼슘
$calcium = $_POST[""];
//6.인
$pho = $_POST[""];
//7.철
$iron = $_POST[""];
//8.나트륨
$na = $_POST[""];
//9.칼륨
$potassium = $_POST[""];
*/

$input_Data = mysqli_prepare($con,"INSERT INTO h_nut VALUES(?,?,?,?,?,?)");
mysqli_stmt_bind_param($input_Data,"sisiii",
$userID,$date,$meal,$protein,$carbo,$fat);
//$vitamin,$calcium,$pho,$iron,$na,$potassium);

mysqli_stmt_execute($input_Data);

$response = array();
$response["success"] = true;

echo json_encode($response);

?>