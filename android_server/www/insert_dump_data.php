insert_dump_data
<?php
$con = mysqli_connect("localhost","computernano","computer2024!","computernano");
mysqli_query($con,'SET NAMES utf8');

//사용자id
$userID = "tst20316";
//일
$date =2;
//아점저
$meal = "아침";
//1.단백질
$protein = 76.4;
//2.탄수화물
$carbo = 260.1;
//3.지방
$fat = 60.16;/*
//4.비타민
$vitamin = 50;
//5.칼슘
$calcium = 785;
//6.인
$pho = 80;
//7.철
$iron = 10;
//8.나트륨
$na = 20;
//9.칼륨
$potassium = 35;
*/

$input_Data = mysqli_prepare($con,"INSERT INTO h_nut VALUES(?,?,?,?,?,?)");
mysqli_stmt_bind_param($input_Data,"sisddd",
$userID,$date,$meal,$carbo,$protein,$fat);
//$vitamin,$calcium,$pho,$iron,$na,$potassium);

mysqli_stmt_execute($input_Data);

$response = array();
$response["success"] = ":)";

echo json_encode($response);

?>