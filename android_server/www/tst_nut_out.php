tst_nut_out
<?php
$con = mysqli_connect("localhost",
"computernano","computer2024!","computernano");



//카운트 갯수
$count_num = 0;
//1.단백질
$sum_protein = 0;
//2.탄수화물
$sum_carbo = 0;
//3.지방
$sum_fat = 0;
/*
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
*/
/*
$sql = "SELECT * FROM healthdata_nut";
$result = $con->query($sql);
$arr = mysqli_fetch_array($result);

for($i =0; $i<$dataCount;$i++){
    $memberInfo = $result->fetch_array(MYSQLI_BOTH);
    echo"-".$row[0].":".$row[1]."<br>";


}*/
$query = "SELECT * FROM h_nut where 사용자_이름 = 'tst_2024_03_04'";
$result = mysqli_query($con,$query);
$ary = mysqli_fetch_array($result);
//0: 사용자ID  1: 일       2: 아점저
//3: 탄수화물  4: 단백질   5: 지방
//6: 비타민C   7: 칼슘     8: 인
//9: 철       10: 나트륨  11: 칼륨
/*
if(!$result){
    die('쿼리 실패: '.mysqli_error($con));
}*/


echo"<br>";
echo"<br>";
$a = $ary[0];
$b = $ary[1];
$c = $ary[2];
$sum_carbo = $ary[3];
$sum_protein = $ary[4];
$sum_fat = $ary[5];

while($row = mysqli_fetch_assoc($result)){
$sum_protein += $row['단백질'];
$count_num++;
}

printf("사용자ID : %s, 일수 :  %.0f, 아점저 : %s",$a,$b,$c);

$con->close();

echo"<br>"."Sum of Protein : ".$sum_protein;
printf("현재 사용자의 탄단지 섭취량");
echo"<br>";
printf("탄수화물: %.2f",$sum_carbo);
echo"<br>";
printf("단백질 : %.2f",$sum_protein);
echo"<br>";
printf("지방 : %.2f",$sum_fat);

?>