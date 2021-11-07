window.addEventListener('load', function () {
    connect()
});

let stompClient = null;

function connect() {
    let socket = new SockJS('/buttonbattle');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function (message) {
            showMessage(JSON.parse(message.body));
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function sendMessage(buttonType) {
    stompClient.send("/app/buttonbattle", {},
        JSON.stringify({'buttonType': buttonType}));
}

function showMessage(message) {
    const buttonType = message.buttonType
    let clicksContainer;
    if (buttonType === 'BRO') {
        renderMessage('broFrom', 'broTime', 'broMessage',
            'Last bro click from:', 'broAt', message)
        clicksContainer = document.getElementById('broClicks')
    } else {
        renderMessage('sisFrom', 'sisTime', 'sisMessage',
            'Last sis click from:', 'sisAt', message)
        clicksContainer = document.getElementById('sisClicks')
    }


    let number = parseInt(clicksContainer.innerText);
    clicksContainer.innerText = ++number + '';
}

function renderMessage(fromContainerId, timeContainerId, messageContainerId, typeMessage, atContainerId, message) {
    document.getElementById(fromContainerId).innerText = message.from
    document.getElementById(timeContainerId).innerText = message.time
    document.getElementById(messageContainerId).innerText = typeMessage
    document.getElementById(atContainerId).innerText = 'at'
}