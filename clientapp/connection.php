<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of connection
 *
 * @author jederson
 */
class Connection {
    //put your code here
    private $address;
    private $serverSocket;
    private $port;
    
    function __construct($address,$port) {
        $this->address = $address;
        $this->serverSocket = socket_create(AF_INET,SOCK_STREAM,SOL_TCP);
        $this->port = $port;
    }
    
    public function getSocket(){
        return socket_connect($serverSocket,$address,$port);
    }
    
    function getAddress() {
        return $this->address;
    }

    function getServerSocket() {
        return $this->serverSocket;
    }

    function getPort() {
        return $this->port;
    }

    function setAddress($address) {
        $this->address = $address;
    }

    function setServerSocket($serverSocket) {
        $this->serverSocket = $serverSocket;
    }

    function setPort($port) {
        $this->port = $port;
    }



}
