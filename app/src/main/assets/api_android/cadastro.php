<?php

$name = $_POST["name"];
$email = $_POST["email"];
$password = $_POST["password"];

$serverName = "127.0.0.1";
$userName = "327876";
$servPassword = "nerd1234";
$dbname = "327876";

$con = mysqli_connect($serverName, $userName, $servPassword, $dbname);

if (!$con) {
    die("Could not connect: " . mysqli_connect_error());
}

$sql = "INSERT INTO users (name, email, password)
VALUES('$name', '$email', '$password');";

if (mysqli_query($con, $sql)) {
    echo "New record created";
} else {
    echo "Could not insert:" . $sql . "<br>" . mysqli_error($con);
}

mysqli_close($con);
