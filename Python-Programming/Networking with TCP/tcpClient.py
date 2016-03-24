import socket


def Main():
    host = '127.0.0.1'
    port = 5000

    s = socket.socket()  # create a socket object
    s.connect((host,port))  # connect to the server

    message = input("-> ")
    while message != 'q':
        s.send(message.encode('utf-8'))  # send message
        data = s.recv(1024).decode('utf-8')
        print("Received from server : " + data)
        message = input("-> ")
    s.close()


if __name__ == '__main__':
    Main()
