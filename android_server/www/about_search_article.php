<?php
    $con = mysqli_connect("localhost", "tipshare", "share2024!", "tipshare");
        mysqli_query($con,'SET NAMES utf8');

    //subject : 글 번호
    //article : 글 내용
    $subject = $_POST["subject"];
    $article = $_POST["article"];
    //$subject = "1";
    //$article = "돈 많이 벌구 행복하게 살고 싶당";

    
    //userID, subject, article로 비교해서 같은거 가지고 오기
    
    $sql = mysqli_prepare($con,"SELECT * FROM Upload_info where subject = ? and article = ?");
    mysqli_stmt_bind_param($sql,"ss",$subject,$article);
    mysqli_stmt_execute($sql);
/*
    $sql = mysqli_prepare($con,"SELECT * FROM Upload_info where article = ?");
    mysqli_stmt_bind_param($sql,"s",$article);
    mysqli_stmt_execute($sql);
  */
    //받는거는 다 받아와야함
    //받을거 : userID, subject, article, upload_time, like_cnt, article_nmb
    mysqli_stmt_store_result($sql);
    mysqli_stmt_bind_result($sql,
    $userID,$subject,$article,$upload_time,$like_cnt,$article_nmb);
    
    $response = array();
    while(mysqli_stmt_fetch($sql)){
        $response["userID"] = $userID;
        $response["article"]=$article;
        $response["upload_time"] = $upload_time;
        $response["like_cnt"]=$like_cnt;
    }
    echo json_encode($response);

?>