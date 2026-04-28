nut_out
<?php
$con = mysqli_connect("localhost","computernano","computer2024!","computernano");

$userID = "com";

//카운트 갯수
$count_num = 0;
//1.단백질
$sum_protein = 0;
//2.탄수화물
$sum_carbo = 0;
//3.지방
$sum_fat = 0;
//4.비타민
$sum_vitamin = 0;
//5.칼슘
$sum_calcium = 0;
//6.인
$sum_pho = 0;
//7.철
$sum_iron = 0;
//8.나트륨
$sum_na = 0;
//9.칼륨
$sum_potassium = 0;


$sql = "SELECT 사용자ID FROM healthdata_nut";
$result = $con->query($sql);
if($result->num_rows >0){
    while($row = $result->fetch_assoc()){
       echo"id : ".$row["사용자ID"]."<br>";

    }
}
else{
    echo"0 results";
}
$con->close();


?>