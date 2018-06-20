<?php

	error_reporting(0);
	require_once('connection.php');
	  
	$android_id	= $_REQUEST['android_id'];
	$date		= date('Y-m-d H:i:s');
	$get		= 0;
	
	// read
	$query1 = mysqli_query($conn, "SELECT * FROM tbl_pekerja WHERE android_id='$android_id'");
	while ($row = mysqli_fetch_row($query1)) { $get ++; }

	if($get > 0) {

		// read
	    $query2 = mysqli_query($conn, "SELECT * FROM tbl_pekerja WHERE android_id='$android_id'");
	    $query3 = mysqli_query($conn, "UPDATE tbl_pekerja SET last_login='$date' WHERE android_id='$android_id' ");

		while ($row = mysqli_fetch_assoc($query2)) { 

			$created = date("d/m/y h:i A", strtotime($row['created']));
			// // $created = date("d/m/y h:i A", strtotime($row['last_login']));
			// $last_login = date("d/m/y h:i A", strtotime($row['last_login']));
			
			// $response 	= $row['response'];

			$id			= $row['id'];
			$android_id = $row['android_id'];
			// $phone 		= $row['phone'];
			$created 	= $created;
			// $last_login	= $last_login;

		}

		echo json_encode(array(
			'response'		=> 'success',
			'id'		=> $id,
			'android_id' 	=> $android_id,
			'created' 		=> $created
			// 'last_login' 	=> $last_login
			));

	} else {
		
		if (!empty($android_id) || $android_id != '') {

			
			echo json_encode(array('response'=>'belum'));
		}
	}
?>