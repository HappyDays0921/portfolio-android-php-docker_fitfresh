<?php

$con=mysqli_connect("localhost","tipshare","share2024!","tipshare");
mysqli_query($con,'SET NAMES utf8');
if (!$link)  
{  
   echo "MySQL 접속 에러 : ";
   echo mysqli_connect_error();
   exit();  
}  
mysqli_set_charset($link,"utf8"); 
$sql = "select * from Uplaod_info"

$results = mysqli_query($link,$sql);
data = array();
if($results){
    while($row = mysqli_fetch_array($results)){
        array_push($data,
        array('userID'=>$row[0],
        'subject'=>$row[1],
        'article'=>$row[2],
        'upload_time'=>$row[3],
        'like_cnt'=>$row[4],
        'article_nmb'=>$row[5]
    ));
    }
    header('Content-Type: application/json; charset=utf8');
    $json = json_encode(array("response"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
    echo $json;
}
else{
    echo "SQL문 처리중 에러 발생 : "; 
    echo mysqli_error($link);
}




?>