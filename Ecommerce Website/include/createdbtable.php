<?php

    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "Millennial";

    $conn = mysqli_connect($servername, $username, $password, $dbname);

    if (!$conn){
        die("Connection failed: ".mysqli_connect_error());
    }

    $sql = "CREATE TABLE Enquiry(
        ID INT(4) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL,
        FIRSTNAME VARCHAR(20) NOT NULL,
        LASTNAME VARCHAR(20) NOT NULL,
        EMAIL VARCHAR(30) NOT NULL,
        PHONE INT(10) NOT NULL,
        STREET VARCHAR(50) NOT NULL,
        CITY VARCHAR(30) NOT NULL,
        STATE VARCHAR(30) NOT NULL,
        POSTCODE INT(5) NOT NULL,
        SUBJECT VARCHAR(50) NOT NULL,
        PRODUCT VARCHAR(30) NOT NULL,
        COMMENT VARCHAR(500) NOT NULL
        )";

    if (mysqli_query($conn, $sql)) {
        echo "Table Enquiry was created successfully";
    } else {
        echo "Error creating table: " . mysqli_error($conn);
    }

    mysqli_close($conn);
?>   