<?php


//$con=mysqli_connect("localhost","computernano","computer2024!","computernano");
$con = mysqli_connect("db","user","password","appdb");
mysqli_query($con,'SET NAMES utf8');

$userID=$_POST["userID"];
$userPassword=$_POST["userPassword"];
$userName=$_POST["userName"];
$userAge=$_POST["userAge"];

//암호화 함수
/*
function encrypt($txt,$key=''){
    if(!$key) $key = "test-key";
    return base64_encode(openssl_encrypt($txt,"AES-256-CBC",$key,true,str_repeat(chr(0),16)));
}
$userPassword = encrypt($userPassword);
*/

$statement=mysqli_prepare($con,"INSERT INTO user VALUES (?,?,?,?)");
mysqli_stmt_bind_param($statement,"sssi",$userID,$userPassword,$userName,$userAge);
mysqli_stmt_execute($statement);

$response=array();
$response["success"]=true;

echo json_encode($response);


?>