<?php
	
	require_once('connection.php');

	$umur 		= $_REQUEST['umur'];
	$lulusan 	= $_REQUEST['lulusan'];
	$bidang 	= $_REQUEST['bidang'];
	$date		= date('Y-m-d H:i:s');
	

	// create
	$query1 		= mysqli_query($conn, "INSERT INTO tbl_pekerja (umur, lulusan, bidang, created) VALUES ('$umur', '$lulusan', '$bidang', '$date') ");

	if($query1) {
		echo json_encode(array('response'=>'success'));
	} else {
	    echo json_encode(array('response'=>'failed'));
	}
?>
