package pl.mmajcherski.gameoflife

import groovy.transform.EqualsAndHashCode
import groovy.transform.Immutable
import groovy.transform.ToString

@Immutable
@EqualsAndHashCode
@ToString
class Position {

	int x
	int y
	
	public static Position withCoordiantes(int x, int y) {
		new Position(x: x, y: y)
	}

	public Set<Position> neighbours() {
		def relativeCoordinates = [[0,1], [1,1], [1,0], [1,-1], [0,-1], [-1,-1], [-1,0], [-1,1]]
		relativeCoordinates.collect { coordinate ->
			Position.withCoordiantes(x + coordinate[0], y + coordinate[1])
		}
	}
	
}
