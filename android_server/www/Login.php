<?php
/*
function encrypt($txt,$key=''){
    if(!$key) $key = "test-key";
    return base64_encode(openssl_encrypt($txt,"AES-256-CBC",$key,true,str_repeat(chr(0),16)));
}
*/

//$con = mysqli_connect("localhost", "computernano", "computer2024!", "computernano");
$con = mysqli_connect("db","user","password","appdb");
    mysqli_query($con,'SET NAMES utf8');

    //앱에서 id 입력받는 부분
    $userID = $_POST["userID"];
    $userPassword = $_POST["userPassword"];
    //앱에서 입력받은 비밀번호 암호화
    //$userPassword = encrypt($userPassword);

    //sql문
    $loginStatement = mysqli_prepare(
        $con, "SELECT * FROM user WHERE userID = ? AND userPassword = ?");
    //$loginStatement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID = ? AND userPassword = ?");

    //값 입력, 위에 sql에서 사용될 userID랑 userPassword에 사용될 값을 바인딩
    mysqli_stmt_bind_param($loginStatement, "ss", $userID, $userPassword);
    //sql실행
    mysqli_stmt_execute($loginStatement);
//
    mysqli_stmt_store_result($loginStatement);
    mysqli_stmt_bind_result($loginStatement, $userID, $userPassword, $userName, $userAge);
 
    $loginResponse= array();
    $loginResponse["success"] = false;

    while(mysqli_stmt_fetch($loginStatement)) {
        $loginResponse["success"] = true;
        $loginResponse["userID"] = $userID;
        $loginResponse["userPassword"] = $userPassword;
        $loginResponse["userName"] = $userName;
        $loginResponse["userAge"] = $userAge;

    }


    
    echo json_encode($loginResponse);



?>
 