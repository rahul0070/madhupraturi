import socket
from activateRouter import Activate

class Router:
	def __init__(self, ):
		self.ipAddress = ipAddress
		self.routerName = routerName


if __name__ == '__main__':
	routerName = input('Enter router name: ')
	router = Activate(routerName)

	interface1 = socket.socket(family = socket.AF_INET, type = socket.SOCK_DGRAM)
	interface1.bind(('127.0.0.1', 20001))

	interface2 = socket.socket(family = socket.AF_INET, type = socket.SOCK_DGRAM)
	interface2.bind(('127.0.0.1', 20002))

	interface3 = socket.socket(family = socket.AF_INET, type = socket.SOCK_DGRAM)
	interface3.bind(('127.0.0.1', 20003))

	inputInterface = socket.socket(family = socket.AF_INET, type = socket.SOCK_DGRAM)
	inputInterface.bind(('127.0.0.1', 20004))



	while True:
		data, senderAddress = inputInterface.recvfrom(4096)
		print(data)
		interface1.sendto(data, ('127.0.0.1',10004))

	
