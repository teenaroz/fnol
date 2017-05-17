#!/usr/bin/env node

var path = require('path');
var express = require('express');
var app = express();

var indexHtml = null;


startExpressServer();

function startExpressServer() {
	//app.use('/fnol',express.static(path.join(__dirname, '/app/fnol.html')));
    app.get('/fnol', function(req, res) {
        res.sendFile(path.join(__dirname + '/app/fnol.html'));
    });

	var PORT = 8000;
	app.listen(PORT, function() {
		console.log('server listening on port:' + PORT);
	});
}