<?php
//서버연결
$con = mysqli_connect("db","user","password","appdb");
    mysqli_query($con,'SET NAMES utf8');

//받기
$userName = $_POST["userName"];
//$userName = $_Post["userName"];
/*
$carbo = $_POST["carbo"];
$protein = $_POST["protein"];
$fat=$_POST["fat"];
*/

//$statement = mysqli_prepare($con, "SELECT * FROM test_input WHERE carbo = ? AND protein = ? AND fat = ?");
/*$statement = mysqli_prepare($con, "SELECT carbo, fat, protein FROM test_input
 WHERE carbo = ? AND protein = ? AND fat = ?"); 
*/

$statement = mysqli_prepare($con, "SELECT * FROM test_input WHERE userName = ?");
mysqli_stmt_bind_param($statement, "s",$userName);
mysqli_stmt_execute($statement);

mysqli_stmt_store_result($statement);
mysqli_stmt_bind_result($statement,$userName,$test_time,$age,$carbo,$protein,$fat);



//mysqli_stmt_bind_param($statement, "sss", $carbo, $protein,$fat);
//mysqli_stmt_execute($statement);

//mysqli_stmt_store_result($statement);
//mysqli_stmt_bind_result($statement,$carbo, $protein,$fat);

$Response= array();
$Response["success"] = false;

while(mysqli_stmt_fetch($statement)) {
    
    $Response["success"] = true;
    $Response["userName"]=$userName;
    //$Response["time"]=$time;
    $Response["test_time"]=$test_time;
    $Response["age"]=$age;
    $Response["carbo"] = $carbo;
    $Response["protein"] = $protein;
    $Response["fat"] = $fat;

    //$Response["username"] = $username;
    /*$Response["carbo"] = $carbo;
    $Response["protein"] = $protein;
    $Response["fat"] = $fat;
    $Response["userID"]=$userID;
    */
}
echo json_encode($Response);
?>