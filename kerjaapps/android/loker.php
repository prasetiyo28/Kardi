 <?php 

 require_once('connection.php');

	// $title = $_REQUEST['title'];
 $id_kategori = $_REQUEST['id_kategori'];

 $query = mysqli_query($conn, "SELECT k.nama_kategori as kategori,l.*  FROM tbl_loker l inner join tbl_kategori k on l.id_kategori = k.id_kategori  WHERE l.id_kategori = $id_kategori "
);

 $result = array();
 while($row = mysqli_fetch_array($query)){
 	$created = date("M, d Y", strtotime($row['created']));
 	array_push($result,array(
 		'id_loker'	=> $row['id_loker'],
 		'title'		=> $row['title'],
 		'deskripsi' => $row['deskripsi'],
 		'image'		=> $row['image'],
 		'salary'		=> $row['salary'],
 		'kategori'		=> $row['kategori'],
 		'created'	=> $created
 	));
 }

 echo json_encode(array('result'=>$result));
 mysqli_close($conn);

 ?>