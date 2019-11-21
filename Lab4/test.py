from dijsktra import Algorithm

dk = Algorithm()

dk.run('A')
print('\nCOSTS A: ', dk.shortestPath)
print('\nPATHS: ', dk.routes.paths)

dk.run('B')
print('\n\nCOSTS B', dk.shortestPath)
print('\nPATHS: ', dk.routes.paths)

dk.run('C')
print('\n\nCOSTS C', dk.shortestPath)
print('\nPATHS: ', dk.routes.paths)

dk.run('D')
print('\n\nCOSTS D', dk.shortestPath, '\n\n')
print('\nPATHS: ', dk.routes.paths)

dk.run('E')
print('\n\nCOSTS E', dk.shortestPath, '\n\n')
print('\nPATHS: ', dk.routes.paths)
