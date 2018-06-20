<?php 

require_once('connection.php');

$id_kategori = $_REQUEST['id_kategori'];
$query = mysqli_query($conn, "SELECT * FROM tbl_pertanyaan AS A JOIN tbl_jawaban AS B ON A.id_pertanyaan=B.id_pertanyaan WHERE A.id_kategori='$id_kategori'");

$query2 = mysqli_query($conn, "SELECT * FROM tbl_pertanyaan WHERE id_kategori='$id_kategori' ");

$result = array();
$result2 = array();

while($row = mysqli_fetch_array($query)){
		// $created = date("d/m/y h:i A", strtotime($row['created']));
		// $updated = date("d/m/y h:i A", strtotime($row['updated']));
	array_push($result,array(
			// 'id_pertanyaan'=> $row['id_pertanyaan'],
			// 'id_kategori'  => $row['id_kategori'],
			// 'pertanyaan'   => $row['pertanyaan'],
		'jawaban'   => $row['jawaban'],
		'value'   => $row['value']
			// 'image'		=> $row['image'],
			// 'pertanyaan'		=> '145',
			// 'created'	=> $created,
			// 'updated'	=> $updated
	));

		// array_push($result2,array(
		// 	// 'id_pertanyaan'=> $row['id_pertanyaan'],
		// 	// 'id_kategori'  => $row['id_kategori'],
		// 	// 'pertanyaan'   => $row['pertanyaan'],
		// 	'jawaban'   => $row['jawaban']
		// 	// 'image'		=> $row['image'],
		// 	// 'pertanyaan'		=> '145',
		// 	// 'created'	=> $created,
		// 	// 'updated'	=> $updated
		// ));




}

while($row = mysqli_fetch_array($query2)){
		// $created = date("d/m/y h:i A", strtotime($row['created']));
		// $updated = date("d/m/y h:i A", strtotime($row['updated']));
	array_push($result2,array(
		'id_pertanyaan'=> $row['id_pertanyaan'],
			// 'id_kategori'  => $row['id_kategori'],
		'pertanyaan'   => $row['pertanyaan'],
			// 'jawaban'   => $row['jawaban']
			// 'image'		=> $row['image'],
			// 'pertanyaan'		=> '145',
			// 'created'	=> $created,
			// 'updated'	=> $updated
	));

		// array_push($result2,array(
		// 	// 'id_pertanyaan'=> $row['id_pertanyaan'],
		// 	// 'id_kategori'  => $row['id_kategori'],
		// 	// 'pertanyaan'   => $row['pertanyaan'],
		// 	'jawaban'   => $row['jawaban']
		// 	// 'image'		=> $row['image'],
		// 	// 'pertanyaan'		=> '145',
		// 	// 'created'	=> $created,
		// 	// 'updated'	=> $updated
		// ));




}

echo json_encode(array('result'=>$result, 'result2'=>$result2));
mysqli_close($conn);

?>