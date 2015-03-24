<?php
if ($_GET['uid']!="") {
	mysql_connect("localhost","root","000000");
	mysql_select_db("ToDoApp");
 
		$sql=mysql_query("select * from event where event.uid like ".$_GET['uid'] );
  
	while($row=mysql_fetch_assoc($sql))
  $output[]=$row;
  print("{\"eveeeeeeeent\": ".json_encode($output)."}");
  mysql_close();
  }
?>
