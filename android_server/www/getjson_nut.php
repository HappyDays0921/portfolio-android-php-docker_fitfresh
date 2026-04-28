getjson_nut
<?php  

$link=mysqli_connect("localhost","computernano","computer2024!", "computernano" );  
mysqli_query($link,'SET NAMES utf8');
if (!$link)  
{  
   echo "MySQL 접속 에러 : ";
   echo mysqli_connect_error();
   exit();  
}  

mysqli_set_charset($link,"utf8"); 


$sql="select * from h_nut";

$result=mysqli_query($link,$sql);
$data = array();   
if($result){  
   
   while($row=mysqli_fetch_array($result)){
       array_push($data, 
           array(
            'name'=>$row[0],
            //'사용자_이름'=>$row[0],
            
            'dayNumber'=>$row[1],
            //'일수'=>$row[1],
            
            'meal'=>$row[2],
            //'시간대'=>$row[2],
            
            'carboValue'=>$row[3],
            //'탄수화물'=>$row[3],
            
            'proteinValue'=>$row[4],
            //'단백질'=>$row[4],
            
            'fatValue'=>$row[5],
            //'지방'=>$row[5],
       ));
   }

   header('Content-Type: application/json; charset=utf8');
    $json = json_encode(array("webnautes"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
    echo $json;

}  
else{  
   echo "SQL문 처리중 에러 발생 : "; 
   echo mysqli_error($link);
} 



mysqli_close($link);  
  
?>