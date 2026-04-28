<?php 
    //$con = mysqli_connect("localhost", "computernano", "computer2024!", "computernano");

    $con = mysqli_connect("db","user","password","appdb");
    $userID = $_POST["userID"];
   
    $statement = mysqli_prepare($con, "SELECT userID FROM user WHERE userID = ?");
    mysqli_stmt_bind_param($statement, "s", $userID);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID);


    $response = array();
    $response["success"] = true;
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"]=false;
        $response["userID"]=$userID;
    }
   
    echo json_encode($response);
    
?>