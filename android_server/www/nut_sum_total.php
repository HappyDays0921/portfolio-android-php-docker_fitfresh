nut_sum_total
<?php
$con = mysqli_connect("localhost",
"computernano","computer2024!","computernano");

//카운트 갯수
$cnt = 1;
//1.단백질
$sum_protein = 0;
//2.탄수화물
$sum_carbo = 0;
//3.지방
$sum_fat = 0;

/*
$sql = "SELECT * FROM healthdata_nut";
$result = $con->query($sql);
$arr = mysqli_fetch_array($result);

for($i =0; $i<$dataCount;$i++){
    $memberInfo = $result->fetch_array(MYSQLI_BOTH);
    echo"-".$row[0].":".$row[1]."<br>";


}*/
//tst_2024_03_04
//적정데이터
$query = "SELECT * FROM h_nut where 사용자_이름 = 'tst_2024_03_04'";
$result = mysqli_query($con,$query);
$ary = mysqli_fetch_array($result);


echo"<br>";
echo"<br>";
$a = $ary[0];//이름
$b = $ary[1];//일수
$c = $ary[2];//시간대
$sum_carbo = $ary[3];   //탄수화물 총합
$sum_protein = $ary[4]; //단백질 총합
$sum_fat = $ary[5];     //지방 총합

while($row = mysqli_fetch_assoc($result)){
$sum_protein += $row['단백질'];
++$cnt;
}

$avrg_sum_carbo = ($sum_carbo)/$cnt;
$avrg_sum_protein = ($sum_protein)/$cnt;
$avrg_sum_fat = ($sum_fat)/$cnt;
printf("사용자ID : %s, 일수 :  %.0f, 아점저 : %s",$a,$b,$c);
echo $cnt;

$con->close();
//탄단지 섭취량
echo "<br>"."<br>".$a."님의 하루 탄수화물 단백질 지방 섭취량을 계산하였습니다"."<br>";
echo "20~29세의 하루평균 탄수화물 섭취량은 260.1(g)입니다"."<br>";
echo "20~29세의 하루평균 단백질 섭취량은 76.4(g)입니다"."<br>";
echo "20~29세의 하루평균 지방 섭취량은 60.15(g)입니다"."<br>";

echo"<br>"."cnt : ".$cnt."<br>";

echo "==="."<br>".$a."님의 하루 평균 탄수화물 섭취량은 ".$avrg_sum_carbo."(g)입니다"."<br>";
$m_carbo = 206.1-$avrg_sum_carbo;
//탄수 부족
if($avrg_sum_carbo < 260.1)
    echo"현재 탄수화물이 평균 연령대보다 ".$m_carbo."(g)만큼 부족합니다"."<br>";
//정량
    else if(!($avrg_sum_carbo-260.1))
    echo"현재 적정수준의 탄수화물을 섭취하고 계십니다"."<br>";
//탄수 과다
else{
    $m_carbo *=-1;
    echo"현재 탄수화물을 평균 연령대보다 ".$m_carbo."(g)더 섭취합니다"."<br>";
}

echo  "==="."<br>".$a."님의 하루 평균 단백질 섭취량은 ".$avrg_sum_protein."(g)입니다"."<br>";
$m_pro = 76.4-$avrg_sum_protein;
//단백질 부족
if($avrg_sum_protein < 76.4)
    echo"현재 단백질이 평균 연령대보다 ".$m_pro."(g)만큼 부족합니다"."<br>";
//정량
else if(!($avrg_sum_protein-76.4))
echo"현재 적정수준의 단백질을 섭취하고 계십니다"."<br>";
//단백질 과다
else{
    $m_pro*=-1;
    echo"현재 단백질을 평균 연령대보다 ".$m_pro."(g)더 섭취합니다"."<br>";
}

echo  "==="."<br>".$a."님의 하루 평균 지방 섭취량은 ".$avrg_sum_fat."(g)입니다"."<br>";
$m_fat = 60.16-$avrg_sum_fat;
//지방 부족
if($avrg_sum_fat < 60.16)
    echo"현재 지방이 평균 연령대보다 ".$m_fat."(g)만큼 부족합니다"."<br>";
//정량
else if(!($avrg_sum_fat-60.16))
echo"현재 적정수준의 지방을 섭취하고 계십니다"."<br>";
//지방 과다
else{
    $m_fat*=-1;
    echo"현재 지방을 평균 연령대보다 ".$m_fat."(g)더 섭취합니다"."<br>";
}

?>
