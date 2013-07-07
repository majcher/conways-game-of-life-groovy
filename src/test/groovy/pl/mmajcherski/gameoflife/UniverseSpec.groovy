package pl.mmajcherski.gameoflife

import spock.lang.*

class UniverseSpec extends spock.lang.Specification {
	
	def "Live cell with no neighbours should die after tick"() {
		given: "a universe with one live cell"
		def universe = new Universe()
		universe.add(LiveCell.at(0, 0))
		
		when: "times tick"
		universe.tick()

		then: "cell dies"
		universe.cellAt(Position.withCoordiantes(0, 0)) instanceof DeadCell
	}
	
	def "Live cell with one neighbour should die after tick"() {
		given: "a universe with one live cell"
		def universe = new Universe()
		universe.add(LiveCell.at(0, 0))
		
		and: "one neighbour"
		universe.add(LiveCell.at(0, 1))
		
		when: "times tick"
		universe.tick()

		then: "cell dies"
		universe.cellAt(Position.withCoordiantes(0, 0)) instanceof DeadCell
	}
	
	def "Live cell with two or three live neighbours lives on to the next generation"() {
		given: "a universe with one live cell"
		def universe = new Universe()
		universe.add(LiveCell.at(0, 0))
		
		and: "two neighbours"
		neighbours.each { n -> universe.add(n) }
		
		when: "times tick"
		universe.tick()
		
		then: "cell lives on to the next generation"
		universe.cellAt(Position.withCoordiantes(0, 0)) instanceof LiveCell
		
		where:
		neighbours << [
				[LiveCell.at(0, 1), LiveCell.at(1, 1)],
				[LiveCell.at(0, 1), LiveCell.at(1, 1), LiveCell.at(1, 0)]
			]
	}
	
	def "Live cell with more than three live neighbours dies"() {
		given: "a universe with one live cell"
		def universe = new Universe()
		universe.add(LiveCell.at(0, 0))
		
		and: "four neighbours"
		neighbours.each { n -> universe.add(n) }
		
		when: "times tick"
		universe.tick()
		
		then: "cell dies by overcrowding"
		universe.cellAt(Position.withCoordiantes(0, 0)) instanceof DeadCell
		
		where:
		neighbours << [
				[LiveCell.at(0, 1), LiveCell.at(1, 1), LiveCell.at(1, 0), LiveCell.at(1,-1)],
				[LiveCell.at(0, 1), LiveCell.at(1, 1), LiveCell.at(1, 0), LiveCell.at(1,-1), LiveCell.at(0,-1)]
			]
	}

}