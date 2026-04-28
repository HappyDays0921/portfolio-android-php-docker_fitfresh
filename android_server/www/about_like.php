<?php
    $con = mysqli_connect("localhost", "tipshare", "share2024!", "tipshare");
    mysqli_query($con,'SET NAMES utf8');

    //$userID = $_POST["userID"];
    $subject = $_POST["subject"];
    $article = $_POST["article"];
    $like_cnt = $_POST["like_cnt"];
    //DATABASE UPDATE
    //LIKE 개수 추가
    $sql = mysqli_prepare($con,"UPDATE Upload_info SET like_cnt = ($like_cnt+1) where 
    subject = ? and article =? and like_cnt =?");
    mysqli_stmt_bind_param($sql,"sss",$subject,$article,$like_cnt);
    mysqli_stmt_execute($sql);

//    mysqli_stmt_store_result($sql);
//    echo json_encode($sql);
    /*
    mysqli_stmt_bind_result($sql,
$userID,$subject,$article,$upload_time,$like_cnt,$article_nmb);
*/


?>