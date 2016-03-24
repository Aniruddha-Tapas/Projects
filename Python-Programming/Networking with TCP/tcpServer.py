import socket


def Main():
    host = '127.0.0.1'
    port = 5000

    s = socket.socket()  # create a socket object
    s.bind((host, port))  # bind the socket to this machine

    s.listen(1)  # tell socket to listen
    c, addr = s.accept()
    print("Connection from: " + str(addr))
    while True:
        data = c.recv(1024).decode('utf-8')  # receive data from clientscdecoded from raw butes
        if not data:
            break
        print("From connected user :" + data)
        data = data.upper()
        print("Sending: " + data)
        c.send(data.encode('utf-8'))  # encode the data to send
    c.close()


if __name__ == '__main__':
    Main()
