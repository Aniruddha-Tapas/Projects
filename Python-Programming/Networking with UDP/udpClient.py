import socket


def Main1():
    host = '127.0.0.1'
    port = 5001

    server = ('127.0.0.1',5000) #create a server on this machine

    s = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)  # create a socket object
    s.bind((host,port))

    message = input("-> ")
    while message != 'q':
        s.sendto(message.encode('utf-8'),server)  # send message
        data , addr = s.recvfrom(1024)
        data= data.decode('utf-8')
        print("Received from server : " + data)
        message = input("-> ")
    s.close()

if __name__ == '__main__':
    Main1()
