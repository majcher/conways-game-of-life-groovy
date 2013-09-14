package pl.mmajcherski.gameoflife

import spock.lang.*

class PositionSpec extends Specification {
	
	def "Position in 2-dimensional space should have 8 neighbours"() {
		given: "position in 2-dimensional space"
		def position = Position.withCoordiantes(0, 0)
		
		when: "get neighbours"
		Set<Position> neighbours = position.neighbours();

		then: "size is equal to 8"
		neighbours.size() == 8
	}

}