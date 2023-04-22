<?php

$file = 'test_registry.json';

if(isset($_POST['json'])) {
    $json = $_POST['json'];
    file_put_contents($file, json_encode(json_decode($json), JSON_PRETTY_PRINT));
    echo 'Data saved successfully';
}

?>
