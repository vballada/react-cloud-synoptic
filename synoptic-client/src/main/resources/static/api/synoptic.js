var React = require('react');
var ReactDOM = require('react-dom');
var SockJS = require('sockjs-client');
var Stomp = require('stompjs');
var stompClient;

module.exports = React.createClass({
	displayName : 'Synoptic',
	getInitialState: function() {
		  return {message: []};
	},
	componentDidMount: function() {
			var socket = new SockJS('/socksynop');
			stompClient = Stomp.over(socket);
			var callback = this.handleNotification;
			stompClient.connect({}, function(frame) {
			     stompClient.subscribe("/topic/synop", callback);
			});
	},
	componentWillUnmount: function () {
		stompClient.disconnect(); 
	},
	handleNotification: function(response){
		if (this.isMounted && response.body) {
		  var event = JSON.parse(response.body);
		  this.setState({message: event.message});
		}
    },
	render:function(){
		return (
				<span>Message : {this.state.message}</span>
		);
	}
});


