import { useState } from 'react';
import SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';


const ChatPage = () => {
    const [username, setUsername] = useState<string>('');
    const [messages, setMessages] = useState<any[]>([]);
    const [stompClient, setStompClient] = useState<any>(null);

    const colors = [
        '#2196F3', '#32c787', '#00BCD4', '#ff5652',
        '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
    ];

    const connect = (event: React.FormEvent) => {
        event.preventDefault();

        if (username) {
            const socket = new SockJS('http://localhost:8080/ws');
            const client = Stomp.over(socket);

            client.connect({}, () => {
                client.subscribe('/topic/public', onMessageReceived);
                client.send("/app/chat.addUser", {}, JSON.stringify({ sender: username, type: 'JOIN' }));
                setStompClient(client);
            }, onError);
        }
    };

    const onMessageReceived = (payload: any) => {
        const message = JSON.parse(payload.body);
        setMessages((prevMessages) => [...prevMessages, message]);
    };

    const onError = (error: any) => {
        console.error('Could not connect to WebSocket server. Please refresh this page to try again!');
    };

    const sendMessage = (event: React.FormEvent) => {
        event.preventDefault();

        const messageContent = (document.querySelector('#message') as HTMLInputElement).value.trim();
        if (messageContent && stompClient) {
            const chatMessage = {
                sender: username,
                content: messageContent,
                type: 'CHAT'
            };
            stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
            (document.querySelector('#message') as HTMLInputElement).value = '';
        }
    };

    const getAvatarColor = (messageSender: string) => {
        let hash = 0;
        for (let i = 0; i < messageSender.length; i++) {
            hash = 31 * hash + messageSender.charCodeAt(i);
        }
        const index = Math.abs(hash % colors.length);
        return colors[index];
    };

    return (
        <div className="h-full">
            <div id="username-page" className="text-center">
                <div className="username-page-container bg-white shadow-lg mx-auto mt-40 p-8 rounded w-full max-w-md">
                    <h1 className="title mb-8">Type your username to enter the Chatroom</h1>
                    <form id="usernameForm" name="usernameForm" onSubmit={connect}>
                        <div className="form-group mb-4">
                            <input
                                type="text"
                                id="name"
                                placeholder="Username"
                                autoComplete="off"
                                className="form-control w-full px-4 py-2 border border-gray-300 rounded"
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                            />
                        </div>
                        <div className="form-group">
                            <button type="submit" className="accent username-submit px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600">Start Chatting</button>
                        </div>
                    </form>
                </div>
            </div>

            <div id="chat-page" className="hidden">
                <div className="chat-container bg-white shadow-lg mx-auto mt-20 p-8 rounded w-full max-w-md">
                    <div className="chat-header">
                        <h2>Spring WebSocket Chat Demo - By Alibou</h2>
                    </div>
                    <div className="connecting">
                        Connecting...
                    </div>
                    <ul id="messageArea" className="overflow-auto h-80 mb-4">
                        {messages.map((message, index) => (
                            <li key={index} className={message.type === 'JOIN' || message.type === 'LEAVE' ? 'event-message' : 'chat-message'}>
                                {message.type === 'CHAT' &&
                                    <div className="flex items-center">
                                        <div className="w-10 h-10 rounded-full bg-blue-500 text-white flex items-center justify-center mr-4">
                                            {message.sender[0]}
                                        </div>
                                        <div>
                                            <span className="font-semibold">{message.sender}</span>
                                            <p>{message.content}</p>
                                        </div>
                                    </div>
                                }
                                {(message.type === 'JOIN' || message.type === 'LEAVE') &&
                                    <p className="text-gray-700">{message.sender} {message.type === 'JOIN' ? 'joined!' : 'left!'}</p>
                                }
                            </li>
                        ))}
                    </ul>
                    <form id="messageForm" name="messageForm" onSubmit={sendMessage}>
                        <div className="form-group">
                            <div className="input-group clearfix">
                                <input
                                    type="text"
                                    id="message"
                                    placeholder="Type a message..."
                                    autoComplete="off"
                                    className="form-control w-full px-4 py-2 border border-gray-300 rounded mr-2"
                                />
                                <button type="submit" className="primary px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600">Send</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default ChatPage;
