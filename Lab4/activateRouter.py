from dijsktra import Algorithm
import topology as tp 
import sqlite3

class Activate:
	def __init__(self, routerName):
		print('here')
		self.routerName = routerName
		self.data = {}
		self.costs = []
		self.routes = []
		self.dk = Algorithm()
		self.initialize()

	def initialize(self):
		ip = tp.ipAddress[self.routerName]
		self.data = {'Name': self.routerName, 'ipAddress': ip}
		self.runAlgorithm()

	def runAlgorithm(self):
		self.dk.run(self.routerName)
		self.costs = self.dk.shortestPath
		self.routes = self.dk.routes.paths
		self.buildTable()

	def getCost(self, routerName):
		for i in self.costs:
			if i[0] == routerName:
				cost = i[1]
				return cost

	def getData(self, router):
		data = []
		path = self.dk.routes.paths[router]
		cost = self.getCost(router)
		return path[1], cost

	def buildTable(self):
		connection = sqlite3.connect('routerInformation_'+self.routerName+'.db')
		db = connection.cursor()

		db.execute('CREATE TABLE information(routerName text, ipAddress text)')
		info = [self.routerName, tp.ipAddress[self.routerName]]
		db.execute('INSERT INTO information VALUES(?, ?)',info)
		connection.commit()

		db.execute('CREATE TABLE routingTable(destination char, nextHop text, cost integer, interface integer)')
		connection.commit()

		routerList = tp.routers
		for i in routerList:
			interface = 0
			nextHop, cost = self.getData(i)
			print(i, nextHop, cost)
			parameters = [i, nextHop, cost, interface]
			db.execute('INSERT INTO routingTable VALUES(?, ?, ?, ?)', parameters)
			connection.commit()



r = Activate('B')