package pl.mmajcherski.gameoflife

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(callSuper = true)
@ToString(includeSuper = true)
class LiveCell extends Cell {

	public LiveCell(Position position) {
		super(position)
	}

	def static LiveCell at(int x, int y) {
		new LiveCell(Position.withCoordiantes(x, y))
	}

	def Cell nextCellStateForLiveNeighboursCount(int liveNeighboursCount) {
		if (liveNeighboursCount == 2 || liveNeighboursCount == 3) {
			return this;
		}
		
		return new DeadCell(this.position)
	}
}
