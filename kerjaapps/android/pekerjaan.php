 <?php 

 require_once('connection.php');

	// $title = $_REQUEST['title'];
 $id_kategori = $_REQUEST['id_kategori'];

 $query = mysqli_query($conn, "SELECT  *  FROM tbl_kategori WHERE id_kategori = $id_kategori "
);

 $result = array();
 while($row = mysqli_fetch_array($query)){
 	$hasil = "Anda 80 % adalah seorang ".$row['nama_kategori'];
 	array_push($result,array(
 		'hasil'		=> $hasil

 	));
 }

 echo json_encode(array('result'=>$result));
 mysqli_close($conn);

 ?>