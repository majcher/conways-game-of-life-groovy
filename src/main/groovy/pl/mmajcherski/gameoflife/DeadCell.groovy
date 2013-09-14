package pl.mmajcherski.gameoflife

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString(includeSuper = true)
class DeadCell extends Cell {
	
	public DeadCell(Position position) {
		super(position)
	}

	def static DeadCell at(int x, int y) {
		new DeadCell(Position.withCoordiantes(x, y))
	}

	def Cell nextCellStateForLiveNeighboursCount(int liveNeighboursCount) {
		if (liveNeighboursCount == 3) {
			return new LiveCell(this.getPosition())
		}

        return this
	}

}
