<?php
$db_name = "id8827944_iptk_db";
$mysql_username = "id8827944_admin";
$mysql_password = "admin";
$server_name = "localhost";
$con = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);
if($con){
    echo "connection success";
}else{
    echo "not success";
}

//$db_name = "iptk_db";
//$mysql_username = "root";
//$mysql_password = "root";
//$server_name = "localhost";
//$con = mysqli_connect($server_name, $mysql_username, $mysql_password, $db_name);
//if($con){
//    echo "connection success";
//}else{
//    echo "not success";
//}
