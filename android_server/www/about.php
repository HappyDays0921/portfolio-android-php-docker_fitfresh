<?php
    $con = mysqli_connect("localhost", "tipshare", "share2024!", "tipshare");
        mysqli_query($con,'SET NAMES utf8');

    $userID = $_POST["userID"];
    $subject = $_POST["subject"];
    $article = $_POST["article"];
    //$upload_time = $_POST[""];
    //$like_cnt = $_POST[""];
    //$article_nmb = $_POST[""];
    
    //userID, subject, article로 비교해서 같은거 가지고 오기
    $sql = mysqli_prepare($con,"SELECT * FROM Upload_info where userID = ? and subject = ? and article = ?");
    mysqli_stmt_bind_param($sql,"sss",$userID,$subject,$article);
    mysqli_stmt_execute($sql);

    //받는거는 다 받아와야함
    //받을거 : userID, subject, article, upload_time, like_cnt, article_nmb
    mysqli_stmt_store_result($sql);
    mysqli_stmt_bind_result($sql,
    $userID,$subject,$article,$upload_time,$like_cnt,$article_nmb);
    
    $response = array();
    
    while(mysqli_stmt_fetch($sql)){
        $response["upload_time"] = $upload_time;
        $response["like_cnt"]=$like_cnt;
    }
    echo json_encode($response);

?>