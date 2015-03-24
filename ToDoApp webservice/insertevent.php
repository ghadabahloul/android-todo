 <?php

	// Create connection
	
	
	$host='localhost';
	$uname='root';
	$pwd='000000';
	$db="ToDoApp";

	$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
	mysql_select_db($db,$con) or die("db selection failed");
	 
	$idevent=$_REQUEST['idevent'];
        $type=$_REQUEST['type'];
	$titre=$_REQUEST['titre'];
        $disc=$_REQUEST['disc'];
        $date=$_REQUEST['date'];
        $uid=$_REQUEST['uid'];
       

	$flag['code']=0;

	if($r=mysql_query("insert into event values('$idevent','$type','$titre','$disc','$date','$uid') ",$con))
	{
		$flag['code']=1;
		
	}

	print(json_encode($flag));
	mysql_close($con);
 
?>
