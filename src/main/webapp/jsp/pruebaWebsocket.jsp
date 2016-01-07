<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <script src="${pageContext.servletContext.contextPath}/js/sockjs-0.3.4.js"></script>
    <script src="${pageContext.servletContext.contextPath}/js/stomp.js"></script>
    <script type="text/javascript">
        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
        }

        function connect() {
        	//conectamos con el servidor
        	var socket = new SockJS('/sgt/ws');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                //nos subscribimos al canal deseado
                //el segundo parametro podemos escribir la funcion de success o indicar el nombre de a que funcino debe ir en caso de un 200
                //stompClient.subscribe('/topic/ws', funcionMia,funcionError); solo el nombre y definirla dentro de este jsp
                stompClient.subscribe('/topic/ws', function(greeting){
                    showGreeting(JSON.parse(greeting.body).content);
                });
            });
        }

        function disconnect() {
            stompClient.disconnect();
            setConnected(false);
            console.log("Disconnected");
        }

        function sendName() {
            var name = document.getElementById('name').value;
            stompClient.send('/app/admin/hello', {}, JSON.stringify({ 'name': name }));
        }

        function showGreeting(message) {
            alert(message);
        }
    </script>
</head>
<body>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
</div>
</body>
</html>