<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$serverSocket=socket_create(AF_INET,SOCK_STREAM,SOL_TCP);
	$address = '192.168.0.103';
	$port = 8483;

	if(($socket = socket_connect($serverSocket,$address,$port)) === false){
		echo "socket_connect() failed! - Motivo:".socket_strerror(socket_last_error($serverSocket))."\n";
	}else{
		$msg = socket_read($serverSocket, 1024);
		echo "$msg \n";

		if(socket_write($serverSocket, "LOGIN:-:fernanda@gmail.com",1024) === false){
			echo "Error write\n";
		}else{
			$msg = socket_read($serverSocket, 1024);
			echo "$msg \n";
		}


	}
	
	socket_close($serverSocket);
?>

