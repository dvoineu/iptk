<?php
require "conn.php";
$name = $_GET["name"];
$user_name = $_GET["user_name"];
$user_email = $_GET["email"];
$user_password = $_GET["password"];

$sql = "select * from employee where name = '$name'";

$result = mysqli_query($con, $sql);

if(mysqli_num_rows($result)>0){
    $status = "exist";
}else{
    $sql = "insert into employee (name, user_name, email, password) values ('$name', '$user_name', '$user_email', '$user_password')";

    if(mysqli_query($con, $sql)){
        $status = "ok";

    }else{
        $status = "error";
    }
}

echo json_encode(array("response"=>$status));

mysqli_close($con);